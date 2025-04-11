package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.addProduct;

@Repository
public interface addProductRepo extends JpaRepository<addProduct, Integer> {
}
