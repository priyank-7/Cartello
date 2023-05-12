package com.retail.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.retail.entity.User;

@Component
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	// Create/Update User
	@Transactional
	public boolean createUser(User user) {
		
		this.hibernateTemplate.save(user);
		return true;
	}
	
	// Check User
	public User ckUser(User user) {
		User temp = this.hibernateTemplate.get(User.class, user.getUserId());
		System.out.println(temp);
		if(!temp.equals(null)) {
			return this.hibernateTemplate.get(User.class, user.getUserId());
		}
		return null;
	}
	
	
	// Get a User
	public User getUser(String userId) {
		return this.hibernateTemplate.get(User.class, userId);
	}
	
	
	// delete User
	@Transactional
	public void deleteUser(String userId) {
		User user = this.hibernateTemplate.get(User.class, userId);
		this.hibernateTemplate.delete(user);
	}
	
	public boolean updateUser(User user) {
		
		return false;
	}
}
