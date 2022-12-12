package service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    public boolean loginCheck(HttpSession session){
        if (session.getAttribute("user") == null) {
            return false;
        } else {
            return true;
        }
    }
}
