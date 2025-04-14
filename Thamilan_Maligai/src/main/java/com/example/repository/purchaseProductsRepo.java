package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.purchasingDetailes;
@Repository
public interface purchaseProductsRepo extends JpaRepository<purchasingDetailes, Integer>{

}
