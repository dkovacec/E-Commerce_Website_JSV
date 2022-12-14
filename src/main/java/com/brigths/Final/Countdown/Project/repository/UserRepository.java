package com.brigths.Final.Countdown.Project.repository;

import com.brigths.Final.Countdown.Project.model.Product;
import com.brigths.Final.Countdown.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getByEmailContainingIgnoreCase (String email);


    boolean findByEmailContainingIgnoreCase (String email);
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    boolean existsByUsernameIgnoreCase(String username);

//    List <User> findProductsByUserId (long userId);
}
