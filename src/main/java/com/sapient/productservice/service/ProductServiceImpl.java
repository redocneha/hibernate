package com.sapient.productservice.service;


import com.sapient.productservice.dao.ProductDAO;
import com.sapient.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

    @Autowired( required = true)
    @Qualifier(value = "hibernateDAOImpl")
    private ProductDAO employeeDAO;

  
    public ProductServiceImpl(@Qualifier(value = "hibernateDAOImpl")ProductDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }


    
    @Transactional
    public List<Product> fetchAllProducts() {
        return employeeDAO.fetchAllProducts();
    }

    @Transactional
    public Product findById(int id) {
        return employeeDAO.findById(id);
    }


 
    @Transactional
	@Override
	public Product saveProduct(Product employee) {
		// TODO Auto-generated method stub
		 System.out.println("Inside the save employee method of Employee service class ....");
	        return employeeDAO.saveProduct(employee);
	}

    @Transactional
	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		employeeDAO.deleteProduct(id);
	}

    @Transactional
	@Override
	public void updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		System.out.print(product.getName());
		employeeDAO.updateProduct(id,product);
	}
}