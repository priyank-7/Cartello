package com.retail.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.retail.entity.Category;
import com.retail.entity.Product;
import com.retail.helper.ConnectionProvider;

@Component
public class CategoryDao {

//	@Autowired
//	private HibernateTemplate hibernetTemplate;
//	
	@Autowired
	private static Connection con;
	
	// Get All Categories
	public List<Category> getCategories(){
//		List<Category> category = this.hibernetTemplate.loadAll(Category.class);
//		return category;
				
		con = ConnectionProvider.getConnection();
		List<Category> products = new ArrayList<Category>();
		
		try {		
			ResultSet rs  = con.createStatement().executeQuery("Select * from category");
			while(rs.next()) {
				products.add(new Category(rs.getInt("id"),rs.getString("categoryName")));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
}
