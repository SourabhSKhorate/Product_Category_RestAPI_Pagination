package com.nimap.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.java.dto.Category;
import com.nimap.java.dto.Product;
import com.nimap.java.dto.ResponseStructure;
import com.nimap.java.service.Category_Product_Service;

@RestController
@RequestMapping("/api")
public class Category_Product_Controller {

	
	@Autowired
	Category_Product_Service category_Product_Service;

	// CREATE CATEGORY
	@PostMapping("/categories")
	public ResponseStructure<Category> saveCatogery(@RequestBody Category category) {
		return category_Product_Service.saveCategory(category);
	}

	// GET ALL CATEGORY
	@GetMapping("/categories")
	public List<Category> getAllCategory(@RequestParam(value = "pageNumber",defaultValue = "1",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize){
		return category_Product_Service.getAllCategoryt(pageNumber,pageSize);
	}

	// GET CATEGORY BY ID
	@GetMapping("/categories/{id}")
	public ResponseStructure<Category> getCategoryById(@PathVariable int id) {
		return category_Product_Service.getCategoryById(id);
	}

	// UPDATE CATEGORY BY ID
	@PutMapping("/categories/{id}")
	public Category updateCategoryById(@PathVariable int id, @RequestBody Category category) {
		return category_Product_Service.updatedCategoryById(id, category);
	}

	// DELETE CATEGORY BY ID
	@DeleteMapping("/categories/{id}")
	public boolean deleteById(@PathVariable int id) {
		return category_Product_Service.deleteCategorytById(id);
	}

	// CREATE PRODUCT
	@PostMapping("/products")
	public ResponseStructure<Product> saveProduct(@RequestBody Product product) {
		return category_Product_Service.saveProduct(product);
	}

	// GET ALL PRODUCT
	@GetMapping("/products")
	public List<Product> getAllProduct(@RequestParam(value = "pageNumber",defaultValue = "1",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize){
		return category_Product_Service.getAllProduct(pageNumber,pageSize);
	}

	// GET BY ID
	@GetMapping("/products/{id}")
	public ResponseStructure<Product> getProductById(@PathVariable int id) {
		return category_Product_Service.getProductById(id);
	}

	// UPDATE PRODUCT BY ID
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product products) {
		return category_Product_Service.upateProductById(id, products);

	}

	// DELETE BY ID
	@DeleteMapping("/products/{id}")
	public boolean deleteProductById(@PathVariable int id) {
		return category_Product_Service.deleteCategorytById(id);
	}
}
