package com.oracle.service;

import java.sql.SQLException;

import com.oracle.entity.User;
import com.oracle.exception.ExistUserException;

public interface RegisterService {

	void setUser(User new_user) throws SQLException, ExistUserException;
}
