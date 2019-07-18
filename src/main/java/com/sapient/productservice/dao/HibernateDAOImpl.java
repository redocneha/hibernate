package com.sapient.productservice.dao;




import com.sapient.productservice.model.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
@Repository(value = "hibernateDAOImpl")
public class HibernateDAOImpl implements ProductDAO {

	@Autowired
    private SessionFactory sessionFactory;

	public List<Product> fetchAllProducts() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Product").list();
		
	}

	

	public void deleteProduct(int id) {
		 Session session = sessionFactory.getCurrentSession();
	        Product employee = session.byId(Product.class).load(id);
	        session.delete(employee);
		
	}

	
	public Product saveProduct(Product employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
        return employee;
	
	}



	@Override
	public void updateProduct(int id, Product employee) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
        


		  
	       
		
	}



	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		  return sessionFactory.getCurrentSession().get(Product.class, id);
	}

	

}