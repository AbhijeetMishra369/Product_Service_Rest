package com.abhijeet.productservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhijeet.productservice.entity.Product;
import com.abhijeet.productservice.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<Product> findAllProduct() 
	{	
		return productRepo.findAll();
	}

	@Override
	public Product findBypname(String pname) 
	{
		
		return productRepo.findBypname(pname).
				orElseThrow(()->new RuntimeException("Product Not Found"));
	}

	@Override
	public Product saveProduct(Product p)
	{
		return productRepo.save(p);
	}

	@Override
	public Product updateProduct(int pId, Product pr) 
	{
		Product existingProduct = productRepo.findById(pId).
		orElseThrow(()->new RuntimeException("No Product is available in this Id"+pId));
		if(pr.getPname()!=null)
			existingProduct.setPname(pr.getPname());
		 if(pr.getPrice()!=null)
			 existingProduct.setPrice(pr.getPrice());
		 if(pr.getQuantity()!=null)
			 existingProduct.setQuantity(pr.getQuantity());
		
		return productRepo.save(existingProduct);
	}

	@Override
	public String deleteProduct(int pid) 
	{
		productRepo.findById(pid).
		orElseThrow(()->new RuntimeException("No product Available in thid id::"+pid));
		productRepo.deleteById(pid);
		return "Product Deleted";
	}

	
	

}
