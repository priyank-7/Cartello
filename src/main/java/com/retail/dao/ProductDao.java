package com.retail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.mysql.cj.protocol.Resultset;
import com.retail.entity.Product;
import com.retail.helper.ConnectionProvider;

@Component
public class ProductDao {

//	@Autowired
//	private HibernateTemplate hibernetTemplate;

	@Autowired
	private static Connection con;
			

	// Getting Product with category

	public List<Product> getproducts(int categoryId) {

		
		List<Product> products = new ArrayList<Product>();

		try {
			con = ConnectionProvider.getConnection();
			String q = "Select * from product where categoryId=" + categoryId +" order by productName desc";
			ResultSet rs = con.createStatement().executeQuery(q);
			while (rs.next()) {
				products.add(new Product(rs.getInt("productId"), rs.getFloat("price"), rs.getString("productName"),
						rs.getString("productSize"), rs.getString("productColor"), rs.getString("imageUrl"),
						rs.getInt("categoryId")));
			}			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;

	}
	
	
	public List<Product> getFiltredProduct(float value, int categoryId){
		List<Product> products = new ArrayList<Product>();
		
		try {
			con = ConnectionProvider.getConnection();
			String q = "Select * from product where categoryId= ? and price <= ?";
			
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, categoryId);
			ps.setFloat(2, value);
			
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				products.add(new Product(rs.getInt("productId"), rs.getFloat("price"), rs.getString("productName"),
						rs.getString("productSize"), rs.getString("productColor"), rs.getString("imageUrl"),
						rs.getInt("categoryId")));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return products;
		
	}
	
	public Product getProductDetail(int productId) {
		Product p = new Product();
		
		try {
			con = ConnectionProvider.getConnection();
			String q = "select * from product where productId = ?";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString("productName"));
				p.setImageUrl(rs.getString("imageUrl"));
				p.setPrice(rs.getFloat("price"));
				p.setCategoryId(rs.getInt("categoryId"));
				p.setProductSize(rs.getString("productSize"));
				p.setProductColor(rs.getString("productColor"));
				
			}
			return p;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public List<Product> getProductFromList(List<Integer> list){
		List<Product> products = new ArrayList<Product>();
		try {
			
			for(int i : list) {		
				products.add(getProductDetail(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List<Product> getSearchedProduct(String search){
		
		List<Product> products = new ArrayList<Product>();
		
		try {
			String q = "select * from product where productName like '%"+ search +"%'";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				products.add(new Product(rs.getInt("productId"), rs.getFloat("price"), rs.getString("productName"),
						rs.getString("productSize"), rs.getString("productColor"), rs.getString("imageUrl"),
						rs.getInt("categoryId")));
			}
			return products;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

}
