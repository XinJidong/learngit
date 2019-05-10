package com.oracle.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.oracle.dao.RegisterDaoImply;
import com.oracle.entity.User;
import com.oracle.exception.ExistUserException;
import com.oracle.utils.DButil;

public class RegisterServiceImply implements RegisterService {

	@Override
	public void setUser(User new_user) throws SQLException, ExistUserException {
		// TODO Auto-generated method stub
		Connection connection = DButil.getConnection();
		
		RegisterDaoImply registerDaoImply = new RegisterDaoImply();
						
		User user2 = registerDaoImply.setUser(connection, new_user);
		if(user2.getUser()!=null) {
			
			throw new ExistUserException("当前用户已存在！");

		} else {
			
			DButil.executeUpdate(connection, "insert into users(user,password) values(?,?)", new Object[]{new_user.getUser(),new_user.getPassword()});
			System.out.println("注册成功！");
			
		}
		DButil.close(connection);
	}
	
}
