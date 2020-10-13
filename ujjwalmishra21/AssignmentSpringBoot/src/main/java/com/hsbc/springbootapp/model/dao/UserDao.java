package com.hsbc.springbootapp.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsbc.springbootapp.model.beans.User;


public interface UserDao extends JpaRepository<User, Integer> {

}
