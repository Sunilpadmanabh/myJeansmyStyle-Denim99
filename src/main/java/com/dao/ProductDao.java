package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {

	List<Product> getAllProducts();
	
	
	List<Product> getAllProductsForMen();
	
	List<Product> getAllProductsForWomen();
	List<Product> getAllProductsForKids();
	
	
	List<Product> getAllProductsOfOffer();

	Product getProductById(int productId);

	void deleteProduct(int productId);

	void addProduct(Product product);
	
	void editProduct(Product product);


	List<Product> getSearchItems(String text);
	
}
