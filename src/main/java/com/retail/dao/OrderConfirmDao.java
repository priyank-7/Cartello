package com.retail.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.retail.entity.OrderConfirm;
import com.retail.entity.Payment;
import com.retail.helper.ConnectionProvider;

@Component
public class OrderConfirmDao {

	@Autowired
	private HibernateTemplate hiberneteTemplate;
	
	@Autowired
	private PaymentDao paymentdao;
	
	public boolean insert(OrderConfirm orderconfirm, Payment p) {
		
		try {
			int orderID = paymentdao.insert(p);
			String q = "insert into orderConfirm (orderId, customerId, orderDate) values (?,?,sysdate)";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ps.setInt(1, orderID);
			ps.setString(2, orderconfirm.getCustomerId());
			ps.execute();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public OrderConfirm getOrderByOrderId(int orderId) {
		OrderConfirm oc = new OrderConfirm();
		
		try {
			String q = "select * from orderconfirm where orderId = ?";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ps.setInt(1, orderId);
			return (OrderConfirm)ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oc;
	}
	
	public List<OrderConfirm> getOrderByUserId(String userId){
		List<OrderConfirm> orders = new ArrayList<OrderConfirm>();
		
		try {
			String q = "select * from orderconfirm where userId = ?";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				orders.add(new OrderConfirm(rs.getInt("orderId"), rs.getString("customerId"), rs.getDate("orderDate")));
			}
			return orders;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
}
