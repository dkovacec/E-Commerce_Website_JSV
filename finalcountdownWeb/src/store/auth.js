import { defineStore } from "pinia";

const LOCAL_STORAGE_KEY_NAME = "lastLogin"

const persistState = (isAuthenticated) => {
    if (isAuthenticated) {
        localStorage.setItem(LOCAL_STORAGE_KEY_NAME, JSON.stringify(Date.now()))
    } else {
        localStorage.removeItem(LOCAL_STORAGE_KEY_NAME);
    }
}

const handleReponse = async (response, store) => {
    if (response.ok) {
        const data = await response.json();
        store.isAuthenticated = !!data && !!data.id;
        persistState(store.isAuthenticated);
        return data;
    } else {
        const error = await response.json();
        store.isAuthenticated = false;
        persistState(store.isAuthenticated);
        throw {
            message: error,
            error: new Error(`HTTP ${response.status}: ${response.statusText}`)
        }
    }
}

export const useAuthStore = defineStore("auth", {
    state: () => ({
        isAuthenticated: localStorage.getItem(LOCAL_STORAGE_KEY_NAME) !== null,
        user: null,
    }),
    actions: {
        async check() {
            const response = await fetch('/api/auth/check')
            this.isAuthenticated = response.ok;
            persistState(this.isAuthenticated);
        },
        async register(user) {
            const response = await fetch('/api/auth/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(user)
            });

            return await handleReponse(response, this);
        },
        async login(user) {
            const response = await fetch('/api/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(user)
            });            
            return await handleReponse(response, this);
        },
        async logout() {
            const response = await fetch('/api/auth/logout', {
                method: 'POST'
            })
            this.isAuthenticated = false;
            this.user = null;
            persistState(this.isAuthenticated);
        },

        async retrieveUserData(userId) {
            const response = await fetch(`/api/users/${userId}`)
          
              if (response.ok) {
                this.user = await response.json();
              }


          }
    }
})