package com.nimap.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.java.dto.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
