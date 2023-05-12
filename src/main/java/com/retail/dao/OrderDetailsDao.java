package com.retail.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.retail.entity.OrderDetail;
import com.retail.helper.ConnectionProvider;

@Component
public class OrderDetailsDao {

	@Autowired
	private HibernateTemplate hiberneteTemplate;
	
	
	public boolean insert(OrderDetail od) {
		
		try {
			String q = "insert into orderdetail(orderId, productId, quantity) values (?,?,?)";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ps.setInt(1, od.getOrderId());
			ps.setInt(2, od.getProductId());
			ps.setFloat(3, od.getQuantity());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<OrderDetail> getOrderDetails(int orderId){
		List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
		
		try {
			String q = "select * from orderdetail where orderId = ?";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				orderDetail.add(new OrderDetail(rs.getInt("orderId"), rs.getInt("productId"), rs.getFloat("quantity"), rs.getFloat("total")));
			}
			return orderDetail;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetail;
	}
}
