package com.retail.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.retail.entity.Payment;
import com.retail.helper.ConnectionProvider;

@Component
public class PaymentDao {

	@Autowired
	private HibernateTemplate hiberneteTemplate;

	
	public int insert(Payment payment) {		
		try {
			String q = "inesrt into payment (customerId, paymentDate, paymentMethodId) values (?, sysdate, ?)";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ps.setString(1, payment.getCustomerId());
			ps.setInt(2, payment.getPaymentMethodId());
			ps.executeUpdate();
			
			String q1 = "SELECT LAST_INSERT_ID()";
			ResultSet rs = ConnectionProvider.getConnection().prepareCall(q1).executeQuery();
			while(rs.next()) {
				return rs.getInt(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Payment getPaymentDetails(int orderId){
		
		Payment p = new Payment();
		try {
			String q = "select * from payment where paymentId = ?";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ps.setInt(1, orderId);
			return (Payment) ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	
	public List<Payment> getUserPayment(String userId){
		List<Payment> payments = new ArrayList<Payment>();
		
		try {
			String q = "select * from payment where userId = ?";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				payments.add(new Payment(rs.getInt("paymentId"), rs.getInt("paymentMethodId"), rs.getTimestamp("paymentDate"), rs.getString("userId")));
			}
			return payments;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payments;
	}
}
