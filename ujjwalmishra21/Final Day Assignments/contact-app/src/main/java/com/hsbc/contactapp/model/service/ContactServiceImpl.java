package com.hsbc.contactapp.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsbc.contactapp.model.beans.Contact;
import com.hsbc.contactapp.model.beans.User;
import com.hsbc.contactapp.model.dao.ContactDAO;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	public Contact addContact(Contact contact) {
		return contactDAO.save(contact);
	}

	@Override
	public Contact modifyContact(long id, Contact contact) {
		Optional<Contact> optional = contactDAO.findById(id);
		if(optional.isPresent()) {
			Contact fetchContact = optional.get();
			if(contact.getName() != null)
				fetchContact.setName(contact.getName());
			if(contact.getPhone() != null){
				fetchContact.setPhone(contact.getPhone());
			}
			return contact;
		}
		return null;
	}

	@Override
	public Contact deleteContact(long id) {
		Optional<Contact> optional = contactDAO.findById(id);
		if(optional.isPresent()) {
			Contact contact = optional.get();
			contactDAO.deleteById(id);
			return contact;
		}
		return null;
	}

}
