package com.oracle.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.entity.User;
import com.oracle.exception.ExistUserException;
import com.oracle.utils.DButil;

public class RegisterDaoImply implements RegisterDao {

	@Override
	public User setUser(Connection connection,User new_user) throws SQLException, ExistUserException {
		// TODO Auto-generated method stub
		
		User user2 = new User();
		ResultSet resultSet = DButil.executeQuery(connection, "select * from users where user=?", new Object[]{new_user.getUser()});
		while (resultSet.next()) {
			user2.setUser(resultSet.getString(2));
		}
		return user2;
		

	}

}
