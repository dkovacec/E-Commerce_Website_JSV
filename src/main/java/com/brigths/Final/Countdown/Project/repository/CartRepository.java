package com.brigths.Final.Countdown.Project.repository;

import com.brigths.Final.Countdown.Project.model.Cart;
import com.brigths.Final.Countdown.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);


}
