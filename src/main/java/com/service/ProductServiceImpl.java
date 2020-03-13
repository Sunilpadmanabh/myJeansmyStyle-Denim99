package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDao;
import com.model.Product;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	


	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Transactional
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
	@Transactional
	public List<Product> getAllProductsForMen() {
		return productDao.getAllProductsForMen();
	}
	
	@Transactional
	public List<Product> getAllProductsForWomen() {
		return productDao.getAllProductsForWomen();
	}
	
	@Transactional
	public List<Product> getAllProductsForKids() {
		return productDao.getAllProductsForKids();
	}

	
	
	

	@Transactional
	public List<Product> getAllProductsOfOffer() {
		return productDao.getAllProductsOfOffer();
	}
	
	
	
	
	public Product getProductById(int productId) {
		return productDao.getProductById(productId);
	}

	
	public void deleteProduct(int productId) {
		productDao.deleteProduct(productId);
	}
	
	public void addProduct(Product product){
		productDao.addProduct(product);
	}
	
	public void editProduct(Product product){
		productDao.editProduct(product);
	}

	public List<Product> getSearchItems(String text) {
	
		return productDao.getSearchItems(text);
	}

}
