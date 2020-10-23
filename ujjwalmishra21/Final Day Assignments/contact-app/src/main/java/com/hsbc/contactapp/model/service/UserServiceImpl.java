package com.hsbc.contactapp.model.service;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsbc.contactapp.model.beans.Contact;
import com.hsbc.contactapp.model.beans.User;
import com.hsbc.contactapp.model.dao.ContactDAO;
import com.hsbc.contactapp.model.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	public User getUserById(long id) {
		Optional<User> optional = userDAO.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
	@Override
	public User modifyUser(long id, User user) {
		Optional<User> optional = userDAO.findById(id);
		if(optional.isPresent()) {
			User fetchedUser = optional.get();
			if(user.getPhone() != null)
				fetchedUser.setPhone(user.getPhone());
			if(user.getDob() != null) {
				fetchedUser.setDob(user.getDob());
			}
			return userDAO.save(fetchedUser);
		}
		return null;
	}

	@Override
	public User addUser(User user) {
		return userDAO.save(user);
	}

	@Override
	public Contact addContact(long id, Contact contact) {
		Optional<User> user = userDAO.findById(id);
		if(user.isPresent()) {
			User newUser = user.get();
			contactDAO.save(contact);
			List<Contact> contacts = newUser.getContacts();
			if(contacts == null) {
				contacts = new ArrayList<Contact>();
			}
			contacts.add(contact);
			newUser.setContacts(contacts);
			userDAO.save(newUser);
			return contact;
		}
	
		return null;
	}

	@Override
	public Contact modifyContact(long id, Contact contact) {
		Optional<User> user = userDAO.findById(id);
		if(user.isPresent()) {
			Optional<Contact> optional = contactDAO.findById(contact.getId());
			if(optional.isPresent()) {
				Contact dbContact = optional.get();
				if(!dbContact.getName().equals(contact.getName())){
					dbContact.setName(contact.getName());
				}
				if(!dbContact.getPhone().equals(contact.getPhone())) {
					dbContact.setPhone(contact.getPhone());
				}
				
				return contactDAO.save(dbContact);
			}
		}
		return null;
	}

	@Override
	public Contact deleteContact(long id, long contactId) {
		Optional<User> user = userDAO.findById(id);
		if(user.isPresent()) {
			Optional<Contact> optional = contactDAO.findById(contactId);
			if(optional.isPresent()) {
				contactDAO.deleteById(contactId);
				return optional.get();
			}
		}
	
		return null;
	}

	@Override
	public User getAllContacts(long id) {
		
		Optional<User> user = userDAO.findById(id);
		if(user.isPresent()) {
			User fetchedUser = user.get();
			User data = new User();
			List<Contact> contacts = fetchedUser.getContacts();
			data.setContacts(contacts);
			return data;
		}
			
		return null;
	}


}
