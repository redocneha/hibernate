package com.sapient.productservice.dao;

import com.sapient.productservice.model.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
@Repository(value = "productDAOImpl")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate;


    public ProductDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

   
   
   

	

	public List<Product> fetchAllProducts() {
		// TODO Auto-generated method stub
		List<Product> employeeList = jdbcTemplate.query("select * from products",
	               ( rs, rowNum)-> new Product(rs.getInt(1), rs.getString(2),rs.getDouble(3)));
	       return employeeList;
	}

	

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from products where id="+id);
		System.out.print("inside delete method");
		
	}

	
	public Product saveProduct(Product employee) {
		// TODO Auto-generated method stub
		  jdbcTemplate.execute("insert into products(id,name,price) values ('"+employee.getId()+"','"+employee.getName()+"','"+employee.getPrice()+"')");
	        return employee;
	
	}



	@Override
	public void updateProduct(int id, Product product) {
		// TODO Auto-generated method stub

		String updateQuery = "update products set id=?,name = ?,price=? where id = ?";
		System.out.print(product.getName());
		jdbcTemplate.update(updateQuery, product.getId(),product.getName(),product.getPrice(), id);


		  
	       
		
	}



	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from products where id=" + id,
                (rs, rowNum) -> {
                 Product employee =  new Product(rs.getInt(1), rs.getString(2),rs.getDouble(3));
                           
                           return employee;
                });
	}

	

}