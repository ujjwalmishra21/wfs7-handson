package com.hsbc.contactapp.model.service;

import com.hsbc.contactapp.model.beans.Contact;

public interface ContactService {
	public Contact addContact(Contact contact);
	public Contact modifyContact(long id, Contact contact);
	public Contact deleteContact(long id);
}
