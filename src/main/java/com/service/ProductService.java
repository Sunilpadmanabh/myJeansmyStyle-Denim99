package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public List<Product> getAllProductsForMen();
    public List<Product> getAllProductsForWomen();
    public List<Product> getAllProductsForKids();

    
    public List<Product> getAllProductsOfOffer();
    
    
	Product getProductById(int productId);

	void deleteProduct(int productId);
	
	void addProduct(Product product);
	
	void editProduct(Product product);

	public List<Product> getSearchItems(String text);
}
