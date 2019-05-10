package com.oracle.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


public class DButil {
	private static PreparedStatement prepareStatement;
	private static ResultSet resultSet;
	private static DataSource dataSource;
	
	static{
		/*
		 * 加载资源
		 */
		Properties properties = new Properties();
		InputStream inputStream = DButil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			properties.load(inputStream);
			dataSource = DruidDataSourceFactory.createDataSource(properties);			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/*
	* 获取connection
	*/
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			
			connection=dataSource.getConnection();
			
			//connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	/*
	 * 增删改方法      insert into test(username,passwords)values(?,?)       xxx,xxx
	 */
	public static boolean executeUpdate(Connection connection,String sql,Object[] objects) throws SQLException{
		 prepareStatement = connection.prepareStatement(sql);
		for (int i=1;i<=objects.length;i++) {
			prepareStatement.setObject(i, objects[i-1]);
		}
		if (prepareStatement.executeUpdate()>0) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * 查询方法
	 */
	public static ResultSet executeQuery(Connection connection,String sql,Object[] objects) throws SQLException{
		prepareStatement = connection.prepareStatement(sql);
		
		if (objects !=null) {
			for (int i=1;i<=objects.length;i++) {
				prepareStatement.setObject(i, objects[i-1]);
				
			}
		}
		
		resultSet = prepareStatement.executeQuery();
		return resultSet;
		
	}
	/*
	 * 关闭
	 */
	public static void close(Connection connection){
		
		if (resultSet !=null) {
			
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (prepareStatement !=null) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (connection !=null) {
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
}
