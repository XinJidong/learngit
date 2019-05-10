package com.oracle.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.oracle.entity.User;
import com.oracle.exception.ExistUserException;

public interface RegisterDao {
	User setUser(Connection connection,User new_user) throws SQLException, ExistUserException;
}
