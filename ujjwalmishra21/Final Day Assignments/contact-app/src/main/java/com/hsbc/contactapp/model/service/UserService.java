package com.hsbc.contactapp.model.service;

import java.util.List;

import com.hsbc.contactapp.model.beans.Contact;
import com.hsbc.contactapp.model.beans.User;

public interface UserService {
	public User addUser(User user);
	public User getUserById(long  id);
	public User modifyUser(long id, User user);
	public Contact addContact(long id, Contact contact);
	public Contact modifyContact(long id, Contact contact);
	public Contact deleteContact(long id, long contactId);
	public User getAllContacts(long id);
}
