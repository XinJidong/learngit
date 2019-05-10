package com.oracle.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.oracle.dao.LoginDaoImply;
import com.oracle.entity.User;
import com.oracle.exception.NullUserException;
import com.oracle.utils.DButil;

public class LoginServiceImply implements LoginService {
	LoginDaoImply daoImply = new LoginDaoImply();

	@Override
	public Connection getByUser(User user) throws NullUserException {
		// TODO Auto-generated method stub
		Connection connection = DButil.getConnection();
		
		try {
			User newuser = daoImply.getByUser(connection, user);
			if (newuser.getUser().equals(user.getUser()) && newuser.getPassword().equals(user.getPassword())) {
				
			}else {
				throw new NullUserException("当前用户不存在!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	
}
