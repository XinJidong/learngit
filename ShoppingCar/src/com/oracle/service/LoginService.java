package com.oracle.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.oracle.entity.User;
import com.oracle.exception.NullUserException;

public interface LoginService {

	Connection getByUser(User user) throws SQLException, NullUserException;
}
