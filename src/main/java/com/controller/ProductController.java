
package com.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.model.CartItem;
import com.model.CartItemWithoutLogin;
import com.model.Customer;
import com.model.CustomerWithoutLogin;
import com.model.Product;
import com.service.CustomerService;
import com.service.CustomerWithoutLoginService;
import com.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductService getProductOffer() {
		return productOffer;
	}

	public void setProductOffer(ProductService productOffer) {
		this.productOffer = productOffer;
	}

	@Autowired
	private CustomerWithoutLoginService customerServiceWithoutLogin;

	@Autowired
	private ProductService productOffer;
	// Getters and Setters

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	private CustomerService customerService;

	// Getters and Setters

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// Configuration for MultiPartResolver
	// Multipart resolver is for uploading images and other media
	// maxupload size is for image size should not be maximum than 10240000

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10240000);
		return multipartResolver;
	}

	// Request Mapping

	// which displays the list of products to the productList page

	/*
	 * Product List using Angular
	 * 
	 * @RequestMapping("/getAllProducts") public ModelAndView getAllProducts() {
	 * List<Product> products = productService.getAllProducts(); return new
	 * ModelAndView("productListAngular", "products", products); }
	 */
	// Normal ProductList view
	@RequestMapping("/getAllProducts")
	public String getAllProducts(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
		List<Product> products = productService.getAllProducts();
		model.put("products", products);
		if (request.getUserPrincipal() != null) {
			model.put("currentUser", customerService.getCurrentUser());
		}
		setItemCount(request.getSession().getId(), model);
		return "productList";
	}

	@RequestMapping("/getAllProductsForMen")
	public String getAllProductsForMen(HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model) {
		List<Product> products = productService.getAllProductsForMen();
		model.put("products", products);
		if (request.getUserPrincipal() != null) {
			model.put("currentUser", customerService.getCurrentUser());
		}
		setItemCount(request.getSession().getId(), model);
		return "menPage";
	}

	@RequestMapping("/getAllProductsForWomen")
	public String getAllProductsForWomen(HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model) {
		List<Product> products = productService.getAllProductsForWomen();
		model.put("products", products);
		if (request.getUserPrincipal() != null) {
			model.put("currentUser", customerService.getCurrentUser());
		}
		setItemCount(request.getSession().getId(), model);
		return "womenPage";
	}

	@RequestMapping("/getAllProductsForKids")
	public String getAllProductsForKids(HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model) {
		List<Product> products = productService.getAllProductsForKids();
		model.put("products", products);
		if (request.getUserPrincipal() != null) {
			model.put("currentUser", customerService.getCurrentUser());
		}
		setItemCount(request.getSession().getId(), model);
		return "kidsPage";
	}

	private void setItemCount(String id, Map<String, Object> model) {
		Customer customer = customerService.getCustomer();
		if (!customer.getFirstName().equals(" ")) {
			List<CartItem> cartitems = customer.getCart().getCartItem();
			if (cartitems != null) {

				int itemcount = cartitems.size();
				model.put("itemcount", itemcount);
				return;
			}
		} else {
			CustomerWithoutLogin cust = customerServiceWithoutLogin.getCustomerWithoutLogin(id);
			if (cust != null) {
				List<CartItemWithoutLogin> cartitemswithoutlogin = cust.getCartWithoutLogin().getCartItemWithoutLogin();
				if (cartitemswithoutlogin != null) {
					int itemcount = cartitemswithoutlogin.size();
					model.put("itemcount", itemcount);
					return;
				}
			}
		}
		model.put("itemcount", 0);
	}

	@RequestMapping("/getAllProductsOfOffer")
	public String getAllProductsOfOffer(HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> model) {
		List<Product> products = productOffer.getAllProductsOfOffer();
		model.put("products", products);
		if (request.getUserPrincipal() != null) {
			model.put("currentUser", customerService.getCurrentUser());
		}
		setItemCount(request.getSession().getId(), model);
		return "offerPage";
	}

	// this is used for getting the product by productId

	@RequestMapping("getProductById")
	public String getProductById(HttpServletRequest request, @RequestParam("id") int productId,
			HttpServletResponse response, Map<String, Object> model) {
		Product product = productService.getProductById(productId);
		model.put("productObj", product);
		if (request.getUserPrincipal() != null) {
			model.put("currentUser", customerService.getCurrentUser());
		}
		setItemCount(request.getSession().getId(), model);
		return "productPage";
	}

	@RequestMapping("/admin/delete/{productId}")
	public String deleteProduct(@PathVariable(value = "productId") int productId) {

		// Here the Path class is used to refer the path of the file

		Path path = Paths.get("./src/main/webapp/WEB-INF/resource/images/products/" + productId + ".jpg");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		productService.deleteProduct(productId);
		// http://localhost:8080/shoppingCart/getAllProducts
		return "redirect:/getAllProducts";
	}

	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.GET)
	public String getProductForm(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
		Product product = new Product();
		// New Arrivals
		// set the category as 1 for the Book book
		product.setProductCategory("Men");
		model.put("productFormObj", product);
		if (request.getUserPrincipal() != null) {
			model.put("currentUser", customerService.getCurrentUser());
		}
		setItemCount(request.getSession().getId(), model);
		return "addProduct";

	}

	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute(value = "productFormObj") Product product, BindingResult result) {
		// Binding Result is used if the form that has any error then it will
		// redirect to the same page without performing any functions
		if (result.hasErrors())
			return "addProduct";
		productService.addProduct(product);
		MultipartFile image = product.getProductImage();
		if (image != null && !image.isEmpty()) {
			Path path = Paths
					.get("C:/Users/Ismail/workspace/ShoppingCart/src/main/webapp/WEB-INF/resource/images/products/"
							+ product.getProductId() + ".jpg");

			try {
				image.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return "redirect:/getAllProducts";
	}

	@RequestMapping(value = "/admin/product/editProduct/{productId}")
	public String getEditForm(@PathVariable(value = "productId") int productId, HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model) {
		Product product = productService.getProductById(productId);
		model.put("editProductObj", product);
		if (request.getUserPrincipal() != null) {
			model.put("currentUser", customerService.getCurrentUser());
		}
		setItemCount(request.getSession().getId(), model);
		return "editProduct";
	}

	@RequestMapping(value = "/admin/product/editProduct", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute(value = "editProductObj") Product product) {
		productService.editProduct(product);
		return "redirect:/getAllProducts";
	}

	@RequestMapping("/getProductsList")
	public @ResponseBody List<Product> getProductsListInJson() {
		return productService.getAllProducts();
	}

      @RequestMapping("/search")
	public String getSearchItems(@RequestParam("searchtext")String text, HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
		List<Product> products= productService.getSearchItems(text);
		model.put("products", products);
		if (request.getUserPrincipal() != null) {
			model.put("currentUser", customerService.getCurrentUser());
		}
		setItemCount(request.getSession().getId(), model);
		return "index1";
	}
	
	@RequestMapping("/productsListAngular")
	public String getProducts(Map<String, Object> model) {
		model.put("currentUser", customerService.getCurrentUser());
		return "productListAngular";
	}

}
