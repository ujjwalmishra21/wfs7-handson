package com.hsbc.contactapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.contactapp.model.beans.Contact;
import com.hsbc.contactapp.model.beans.User;
import com.hsbc.contactapp.model.service.ContactService;
import com.hsbc.contactapp.model.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value="/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public User registerUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public User loginUser(@RequestBody User user) {
		User newUser = userService.getUserById(user.getId());
		if(newUser!= null && newUser.getPassword().equals(user.getPassword())) {
			newUser.setContacts(null);
			return newUser;
		}
		return null;
	}
	
	@RequestMapping(value="/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public User loginUser(@PathVariable("id")long id) {
		User newUser = userService.getUserById(id);
		if(newUser!= null ) {
			newUser.setContacts(null);
			return newUser;
		}
		return null;
	}
	
	@RequestMapping(value="/contact/{userId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Contact addContact(@PathVariable("userId")long userId, @RequestBody Contact contact) {
		
		return 	userService.addContact(userId, contact);
	}
		
	@RequestMapping(value="/contact/{userId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public User getAllContact(@PathVariable("userId")long userId) {
		
		return 	userService.getAllContacts(userId);
	}
		
	@RequestMapping(value="/delete/{userId}/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Contact deleteContact(@PathVariable("userId")long userId,@PathVariable("id")long id) {
		
		return 	userService.deleteContact(userId, id);
	}
	
	
	@RequestMapping(value="/edit/{userId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public User modifyUser(@PathVariable("userId")long userId,@RequestBody User user) {
		
		return 	userService.modifyUser(userId, user);
	}
	
	@RequestMapping(value="/contact/edit/{userId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Contact modifyContact(@PathVariable("userId")long userId,@RequestBody Contact contact) {
		
		return 	userService.modifyContact(userId,contact);
	}
		
}
