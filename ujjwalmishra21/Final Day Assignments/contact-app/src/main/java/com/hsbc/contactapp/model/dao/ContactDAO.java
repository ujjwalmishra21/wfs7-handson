package com.hsbc.contactapp.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsbc.contactapp.model.beans.Contact;

public interface ContactDAO extends JpaRepository<Contact, Long> {

}
