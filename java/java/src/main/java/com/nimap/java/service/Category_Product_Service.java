package com.nimap.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nimap.java.dao.Category_Product_Dao;
import com.nimap.java.dto.Category;
import com.nimap.java.dto.Product;
import com.nimap.java.dto.ResponseStructure;

@Service
public class Category_Product_Service {

	@Autowired
	Category_Product_Dao category_Product_Dao;

	public ResponseStructure<Category> saveCategory(Category category) {
		ResponseStructure<Category> responseStructure = new ResponseStructure<Category>();
		if (category != null) {
			responseStructure.setData(category_Product_Dao.saveCategory(category));
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setMessage("Category saved Successful");
			return responseStructure;
		} else {
			ResponseStructure<Category> responseStructure2 = new ResponseStructure<Category>();
			responseStructure2.setData(null);
			responseStructure2.setStatus_code(400);
			responseStructure2.setMessage("Category not found");
			return responseStructure2;
		}
	}

	public boolean deleteCategorytById(int id) {
		return category_Product_Dao.deleteCategory(id);
	}

	public Category updatedCategoryById(int id, Category category) {
		Category c = category_Product_Dao.getCategoryById(id);
		if (c != null) {
			c.setCategory(category.getCategory());
			return category_Product_Dao.updateCategoryById(id, c);
		} else {
			return null;
		}
	}

	public ResponseStructure<Category> getCategoryById(int id) {
		ResponseStructure<Category> responseStructure = new ResponseStructure<Category>();
		Category category = category_Product_Dao.getCategoryById(id);
		if (category != null) {
			responseStructure.setData(category);
			responseStructure.setMessage("Category Found");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			return responseStructure;
		} else {
			ResponseStructure<Category> responseStructure2 = new ResponseStructure<Category>();
			responseStructure2.setData(null);
			responseStructure2.setStatus_code(400);
			responseStructure2.setMessage("Category not found");
			return responseStructure2;
		}
	}

	public List<Category> getAllCategoryt(Integer pageNumber, Integer pageSize) {
		return category_Product_Dao.getAllCategory(pageNumber, pageSize);
	}

	// Product

	public ResponseStructure<Product> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		if (product != null) {
			responseStructure.setData(category_Product_Dao.saveProduct(product));
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setMessage("Product saved Successful");
			return responseStructure;
		} else {
			ResponseStructure<Product> responseStructure2 = new ResponseStructure<Product>();
			responseStructure2.setData(null);
			responseStructure2.setStatus_code(400);
			responseStructure2.setMessage("Product not found");
			return responseStructure2;
		}
	}

	public boolean deleteProductById(int id) {
		return category_Product_Dao.deleteCategory(id);
	}

	public Product upateProductById(int id, Product product) {
		Product p = category_Product_Dao.getProductById(id);
		if (p != null) {
			p.setProduct(product.getProduct());
			p.setPrice(product.getPrice());
			return category_Product_Dao.updateproduct(id, p);
		} else {
			return null;
		}
	}
	public ResponseStructure<Product> getProductById(int id) {
		ResponseStructure<Product> responseStructure= new ResponseStructure<Product>();
		Product product= category_Product_Dao.getProductById(id);
		if(product!=null) {
			responseStructure.setData(product);
			responseStructure.setMessage("Product Found");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			return responseStructure;
		}else {
			ResponseStructure<Product> responseStructure2= new ResponseStructure<Product>();
			responseStructure2.setData(null);
			responseStructure2.setMessage("Product not found");
			responseStructure2.setStatus_code(400);
			return responseStructure2;
		}
	}
	
	public List<Product> getAllProduct(Integer pageNumber, Integer pageSize) {
		return category_Product_Dao.getAllProduct(pageNumber, pageSize);
	}
}
