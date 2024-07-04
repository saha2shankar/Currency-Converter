package com.services;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.database.database;
import com.model.user;

public class userServiceImpl implements userService {

	@Override
	public void signup(user u) {
		String sql = "INSERT INTO `userinfo` (`username`, `email`, `password`) VALUES ('"+u.getUsername()+"', '"+u.getEmail()+"', '"+u.getPassword()+"');";
		try {
			Statement stm = database.getDatabaseCon().createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Boolean login(String username, String password) {
		String sql= "select * From userinfo where username ='"+username+"' and password ='"+password+"' ";
		try {
			Statement stm = database.getDatabaseCon().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<user> getAllusers() {
		List<user> ulist = new ArrayList<>();
		String sql = "select * from userinfo";
		try {
			Statement stm = database.getDatabaseCon().createStatement();
			ResultSet rs= stm.executeQuery(sql);
			while(rs.next()) {
				user u = new user();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				ulist.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ulist;
	}
	

}
