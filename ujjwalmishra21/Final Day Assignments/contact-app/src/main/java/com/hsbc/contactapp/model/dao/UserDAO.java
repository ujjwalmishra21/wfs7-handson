package com.hsbc.contactapp.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsbc.contactapp.model.beans.User;

public interface UserDAO extends JpaRepository<User, Long> {

}
