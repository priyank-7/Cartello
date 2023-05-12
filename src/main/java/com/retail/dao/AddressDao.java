package com.retail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.retail.entity.Address;
import com.retail.helper.ConnectionProvider;

@Component
public class AddressDao {

	@Autowired
	private HibernateTemplate hiberneteTemplate;
	
	@Autowired
	private static Connection con;
	
	
	public boolean insert(Address address) {
		
		try {
			String q = "insert into address values(?,?,?,?,?,?,?)";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ps.setString(1, address.getUserId());
			ps.setString(2, address.getAddress1());
			ps.setString(3, address.getAddress2());
			ps.setString(4, address.getCity());			
			ps.setString(5, address.getCountry());
			ps.setString(6,address.getPinCode());
			ps.setString(7, address.getState());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Address address) {
		
		try {
			String q = "update address set address1=?, address2=?, city=?, country=?, pinCode=?, state=?  where userId =?";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);			
			ps.setString(1, address.getAddress1());
			ps.setString(2, address.getAddress2());
			ps.setString(3, address.getCity());			
			ps.setString(4, address.getCountry());
			ps.setString(5,address.getPinCode());
			ps.setString(6, address.getState());
			ps.setString(7, address.getUserId());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
