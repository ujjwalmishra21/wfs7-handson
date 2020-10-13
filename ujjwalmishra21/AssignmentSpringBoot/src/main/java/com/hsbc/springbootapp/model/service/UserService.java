package com.hsbc.springbootapp.model.service;

import java.util.List;

import com.hsbc.springbootapp.model.beans.User;

public interface UserService {
	public User createUser(User user);
	public List<User> fetchUsers();
	public void deleteByUserId(int id);
	public User fetchUserById(int id);
	public User updateSalary(User user);
}
