package com.oracle.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.entity.User;
import com.oracle.utils.DButil;
import com.oracle.utils.Session;

public class LoginDaoImply implements LoginDao {

	@Override
	public User getByUser(Connection connection,User user) throws SQLException {
		// TODO Auto-generated method stub
		User user2 = new User();
		ResultSet resultSet = DButil.executeQuery(connection, "select * from users where user=? and password=?", new Object[]{user.getUser(),user.getPassword()});
		while (resultSet.next()) {
			user2.setId(resultSet.getInt(1));
			user2.setUser(resultSet.getString(2));
			user2.setPassword(resultSet.getString(3));
			user2.setAddress_id(resultSet.getInt(4));
			user2.setRole(resultSet.getInt(5));			
		}
		Session.getSession().setValue("userId", String.valueOf(user2.getId()));
		return user2;
	
	}

}
