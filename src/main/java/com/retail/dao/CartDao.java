package com.retail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.retail.entity.Cart;
import com.retail.entity.Product;
import com.retail.entity.pkCart;
import com.retail.helper.CartItems;
import com.retail.helper.ConnectionProvider;

@Component
public class CartDao {

	@Autowired
	private HibernateTemplate hibernetetemplate;
	
	@Autowired
	private static Connection con;
	
	@Autowired
	private ProductDao productDao;
	
	
	public Boolean insert(Cart cart) {		
		try {						
			
			con = ConnectionProvider.getConnection();
			
			String q1 = "select * from cart where userId = ? and productId = ?";
			PreparedStatement ps1 = ConnectionProvider.getConnection().prepareStatement(q1);
			ps1.setString(1, cart.getPrimary().getUserId());
			ps1.setInt(2, cart.getPrimary().getProductId());
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				return updateCart(cart);				
			}
			else {
				String q = "insert into cart values(?,?,?)";		
				PreparedStatement ps = con.prepareStatement(q);
				ps.setInt(1,cart.getPrimary().getProductId());
				ps.setString(2, cart.getPrimary().getUserId());
				ps.setFloat(3, cart.getQuantity());
				ps.executeUpdate();
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	private Boolean updateCart(Cart cart) {
		
		try {
			String q2 = "update cart set quantity = ? where userId = ? and productId = ?";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q2);
			ps.setFloat(1, cart.getQuantity());
			ps.setString(2, cart.getPrimary().getUserId());
			ps.setInt(3, cart.getPrimary().getProductId());
			ps.executeUpdate();			
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;		
	}
	
	public List<CartItems> getCartItems(String userId){
		
		List<CartItems> list = new ArrayList<CartItems>();
		
		try {			
			String q = "select * from product as t1 INNER JOIN (select * from cart where userId = ?) as t2 using (productId)";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				list.add(new CartItems(new Product(rs.getInt("productId"), rs.getFloat("price"), rs.getString("productName"), rs.getString("productSize") , rs.getString("productColor"), rs.getString("imageUrl"), rs.getInt("categoryId")),rs.getFloat("quantity")));

			}
//			System.out.println(list);
			return list;			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public Boolean remove(int productId, String UserId) {
		
		try {
			String q = "delete from cart where productId = ? and userId = ?";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ps.setInt(1, productId);
			ps.setString(2, UserId);
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
}
