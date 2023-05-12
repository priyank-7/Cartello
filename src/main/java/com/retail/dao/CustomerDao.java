package com.retail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.retail.entity.Address;
import com.retail.entity.Customer;
import com.retail.helper.ConnectionProvider;

@Component
public class CustomerDao {

	@Autowired
	private HibernateTemplate hiberneteTemplate;
	
	@Autowired
	private static Connection con;
	
	@Autowired
	private AddressDao addressdao;
	
	public boolean insert(Customer c, Address a) {
		
		try {
			
			String q = "select * from customer";
			ResultSet rs = ConnectionProvider.getConnection().prepareCall(q).executeQuery();
			if(rs.next()) {
				String q1 = "update customer set firstName=?, lastname=?, middelName=?, mobile1=?, mobile2=? where customerId=?";
				PreparedStatement ps =  ConnectionProvider.getConnection().prepareStatement(q1);
				ps.setString(1, c.getFirstName());
				ps.setString(2,	c.getLastName());
				ps.setString(3, c.getMiddelName());
				ps.setString(4, c.getMobile1());
				ps.setString(5, c.getMobile2());
				ps.setString(6, c.getCustomerId());
				ps.executeUpdate();
				
				return addressdao.update(a);
				
			}
			else {
				String q2 = "insert into customer values(?,?,?,?,?,?)";
				PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q2);
				ps.setString(1, c.getCustomerId());
				ps.setString(2, c.getFirstName());
				ps.setString(3,	c.getLastName());
				ps.setString(4, c.getMiddelName());
				ps.setString(5, c.getMobile1());
				ps.setString(6, c.getMobile2());
				ps.executeUpdate();
				
				return addressdao.insert(a);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Customer getCustomer(String userId) {
		Customer c = null;
		
		try {
			String q = "select * from customer";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ps.setString(1, userId);
			c = (Customer) ps.executeQuery();
			return c;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
