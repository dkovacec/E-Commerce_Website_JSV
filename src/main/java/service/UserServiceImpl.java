package service;

import com.brigths.Final.Countdown.Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {

        Optional<User> optional = this.userRepository.findById(id);
        User user = null;

        if(optional.isPresent()){
            user = optional.get();
        } else {
            throw  new RuntimeException("User with id " + id + " was not found");
        }

        return user;
    }

    @Override
    public void deleteUserById(long id) {

        if(this.userRepository.existsById(id)){
            this.userRepository.deleteById(id);
        } else {
            throw  new RuntimeException("User with id " + id + " was not found");
        }

    }

    @Override
    public User getUserByCredentials(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email, password);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}

