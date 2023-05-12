package com.retail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.retail.entity.PaymentMethod;
import com.retail.helper.ConnectionProvider;

@Component
public class PaymentMethodDao {

	@Autowired
	private HibernateTemplate hiberneteTemplate;
	
//	@Autowired
//	private Connection con;
	
	
	public List<PaymentMethod> getPaymentMethods(){
		
		List<PaymentMethod> list = new ArrayList<PaymentMethod>();
		
		try {
			String q = "select * from paymentmethod";
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new PaymentMethod(rs.getInt("methodId"), rs.getString("methodType")));
			}
			return list;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
