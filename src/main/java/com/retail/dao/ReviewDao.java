package com.retail.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.retail.entity.Review;
import com.retail.helper.ConnectionProvider;

@Component
public class ReviewDao {

	@Autowired
	private HibernateTemplate hibernetTemplate;
	
	@Autowired
	private static Connection con;
	
	@Transactional
	public boolean addReview(Review review) {
		
		java.util.Date date = new java.util.Date();		
		Timestamp ts = new Timestamp(date.getTime());
		review.setTimestamp(ts);
		
		this.hibernetTemplate.save(review);
		return true;
	}
	
	public List<Review> getReviewsOnProduct(int productId){
		List<Review> reviews = new ArrayList<Review>();
		try {
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement("select * from review where productId = ?");
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reviews.add(new Review(rs.getInt("reviewId"),rs.getString("userId"), rs.getInt("productId"),rs.getFloat("rating"),rs.getString("review"),rs.getTimestamp("timestamp")));
			}
			return reviews;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return reviews;
	}
}
