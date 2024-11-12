package com.abhijeet.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhijeet.productservice.entity.Product;
import com.abhijeet.productservice.service.ProductService;

@RestController
public class ProductController 
{
	@Autowired
	private ProductService ps;
	
	@GetMapping("/products")
	public List<Product>findAll()
	{
		return ps.findAllProduct();
	}
	
	@GetMapping("/products/{name}")
	public ResponseEntity<Product> findByName(@PathVariable("name")String name)
	{
		return new ResponseEntity<Product>(ps.findBypname(name),HttpStatus.OK);
	}
	
	@PutMapping("/update/{pid}")
	public ResponseEntity<Product>updateProduct(@PathVariable int pid,@RequestBody Product pr)
	{
		return new ResponseEntity<Product>(ps.updateProduct(pid, pr),HttpStatus.CREATED);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product>createProduct(@RequestBody Product pr)
	{
		return new ResponseEntity<Product>(ps.saveProduct(pr),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable int pid)
	{
		return new ResponseEntity<String>(ps.deleteProduct(pid),HttpStatus.OK);
	}
	

}
