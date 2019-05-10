package com.oracle.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Address;
import com.oracle.entity.Car;
import com.oracle.entity.Goods;
import com.oracle.entity.Order;

public interface ShoppingDao {
	List<Goods> ShowGoods(Connection connection) throws SQLException;
	Goods getById(Connection connection,int goodsId) throws SQLException;
	
	//购物车
	void setCar(Connection connection,int goodsID,int count,int userId) throws SQLException;		
	List<Car> ShowShopCar(Connection connection,int userId) throws SQLException;
	Car getByCarId(Connection connection,int carId) throws NumberFormatException, SQLException;
	void delCar(Connection connection,int goodsId,int userId) throws SQLException;
	
	
	//地址
	void addAddress(Connection connection,Address address) throws SQLException;
	void delAddress(Connection connection,int addressId) throws SQLException;
	void updateAddress(Connection connection,int addressId,String newAddress) throws SQLException;
	List<Address> showAddress(Connection connection,int userId) throws SQLException;
	
	
	//订单
	List<Order> ShowOrders(Connection connection) throws NumberFormatException, SQLException;	
	void addOrder(Connection connection,int addressId,Car car) throws SQLException;

}
