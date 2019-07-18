package com.sapient.productservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.productservice.model.Product;
import com.sapient.productservice.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/products")
@PropertySource("classpath:documentation.properties")
public class ProductController {

	@Autowired
	ProductService empser;
	
	@GetMapping(value="/",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	//@ApiOperation(value = "Fetch all employees", notes = "API to fetch all the employees")
	public List<Product> listAll()
	{
		  List<Product> products = new ArrayList<>();

	    products = empser.fetchAllProducts();
		
		return products;
		
	}

	@GetMapping(value="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Fetch all employees", notes = "API to fetch all the employees")
	public Product findById(@ApiParam(value="${ProductController.FetchByID}",required=true)@PathVariable("id") int id)
	{

	    Product p = empser.findById(id);
	    
		return p;
		
	}

	@PostMapping (value="/",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Product saveProduct(@RequestBody Product product)
	{

		System.out.println("inside save of contr");
	    Product p = empser.saveProduct(product);

		return p;
	}

	@PutMapping(value="/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public void updateProduct(@PathVariable("id") int id,@RequestBody Product product)
	{
		System.out.println("came inside the update method");
		System.out.print(product.getName());
	   empser.updateProduct(id,product);

		
	}
	@DeleteMapping(value="/{id}")
	public void deleteProduct(@PathVariable("id") int id)
	{
		System.out.println("came inside the delete method");

	    
	    empser.deleteProduct(id);
		
	}
}
