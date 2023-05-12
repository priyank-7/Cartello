package com.retail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.retail.entity.Product;
import com.retail.entity.WishList;
import com.retail.helper.ConnectionProvider;

@Component
public class WishListDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private static Connection con;
	
	@Autowired
	private ProductDao productdao;
	
	
	@Transactional
	public boolean insert(int productId, String userId) {
		
		try {
			con = ConnectionProvider.getConnection();
			
			String q1 = "select productId from wishlist where userId = ? and productId = ?";
			PreparedStatement ps1 = con.prepareStatement(q1);
			ps1.setString(1, userId);
			ps1.setInt(2, productId);			
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				return true;
			}
			
			String q = "insert into wishlist (productId, userId) values (?,?)";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, productId);
			ps.setString(2, userId);
			ps.executeUpdate();
			return true;			
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public List<Product> getWishList(String userId){
		
		List<Integer> list = new ArrayList<Integer>();
		
		try {
			con = ConnectionProvider.getConnection();
			String q = "select productId from wishlist where userId = ?";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("productId"));
			}
			
			 List<Product> products = productdao.getProductFromList(list);
			return products;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean deleteItem(int productId, String userId) {
		
		try {
			con = ConnectionProvider.getConnection();
			String q = "delete from wishlist where userId = ? and productId = ?";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, userId);
			ps.setInt(2, productId);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
}
