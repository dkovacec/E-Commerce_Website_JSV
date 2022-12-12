package com.brigths.Final.Countdown.Project.repository;

import com.brigths.Final.Countdown.Project.model.Product;
import com.brigths.Final.Countdown.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailContainingIgnoreCase (String email);

    List <User> findProductsByUserId (long userId);
}
