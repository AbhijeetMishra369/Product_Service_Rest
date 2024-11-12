package com.abhijeet.productservice.service;

import java.util.List;
import com.abhijeet.productservice.entity.Product;

public interface ProductService
{
	public List<Product>findAllProduct();
	
	public Product findBypname(String pname);
	
	public Product saveProduct(Product p);
	
	public Product updateProduct(int pId,Product pr);
	
	public String deleteProduct(int pid);

}
