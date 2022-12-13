package com.brigths.Final.Countdown.Project.repository;

import com.brigths.Final.Countdown.Project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase (String name);

    List <Product> findProductsByCategoryId (Integer id);

}
