package service;

import com.brigths.Final.Countdown.Project.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long id);
    void deleteUserById(long id);

    User getUserByCredentials(String username, String password);

    User getUserByEmail(String email);
}
