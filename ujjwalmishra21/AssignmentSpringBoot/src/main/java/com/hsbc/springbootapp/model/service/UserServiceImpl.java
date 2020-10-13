package com.hsbc.springbootapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsbc.springbootapp.model.beans.User;
import com.hsbc.springbootapp.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User createUser(User user) {
		
		return userDao.save(user);
	}

	@Override
	public List<User> fetchUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void deleteByUserId(int id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);

	}

	@Override
	public User fetchUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).get();
	}

}
