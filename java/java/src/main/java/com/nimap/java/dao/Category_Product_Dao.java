package com.nimap.java.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.nimap.java.dto.Category;
import com.nimap.java.dto.Product;
import com.nimap.java.repository.CategoryRepository;
import com.nimap.java.repository.ProductRepository;

@Repository
public class Category_Product_Dao {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	// save or create
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	// find by id
	public Category getCategoryById(int id) {
		Optional<Category> optional = categoryRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	// find all
	public List<Category> getAllCategory(Integer pageNumber, Integer pageSize) {
		Pageable p=PageRequest.of(pageNumber, pageSize);
		Page<Category> pageCategory= this.categoryRepository.findAll(p);
		List<Category> allCategory= pageCategory.getContent();
		return allCategory;
		
	}

	// update
	public Category updateCategoryById(int id, Category category) {
		Optional<Category> optional = categoryRepository.findById(id);
		if (optional.isPresent()) {
			return categoryRepository.save(category);
		} else {
			return null;
		}
	}

	// delete
	public boolean deleteCategory(int id) {
		Optional<Category> optional = categoryRepository.findById(id);
		if (optional.isPresent()) {
			categoryRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	// PRODUCT CRUD OPERATIONS

	// save or create
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	// get all product	
	public List<Product> getAllProduct(Integer pageNumber, Integer pageSize) {		
		Pageable p=PageRequest.of(pageNumber, pageSize);
		Page<Product> pageProduct= this.productRepository.findAll(p);
		List<Product> allProduct= pageProduct.getContent();
		return allProduct;
		
	}

	// find by id
	public Product getProductById(int id) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	// update
	public Product updateproduct(int id, Product product) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			return productRepository.save(product);
		} else {
			return null;
		}
	}

	// delete
	public boolean deleteProductById(int id) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			productRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
