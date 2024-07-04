package com.services;

import java.util.List;

import com.model.user;

public interface userService {
	void signup(user u);
	Boolean login(String username, String password);
	List<user> getAllusers();

}
