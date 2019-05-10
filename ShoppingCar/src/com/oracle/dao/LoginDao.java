package com.oracle.dao;

import java.sql.Connection;
import java.sql.SQLException;


import com.oracle.entity.User;

public interface LoginDao {

	User getByUser(Connection connection, User user) throws SQLException;
}
