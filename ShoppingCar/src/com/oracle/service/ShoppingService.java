package com.oracle.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Address;
import com.oracle.entity.Car;
import com.oracle.entity.Goods;

public interface ShoppingService {
	List<Goods> ShowGoods(Connection connection ) throws SQLException;
	
	//购物车增删查
	boolean setCar(Connection connection,int goodsId,int count);	
	List<Car> ShowShopCar(Connection connection) throws SQLException;	
	Car getByCarId(Connection connection,int carId);
	boolean delCar(Connection connection,int goodsId);
	
	
	//地址增删改查
	boolean addAddress(Connection connection,Address address);
	boolean delAddress(Connection connection,int addressId);
	boolean updateAddress(Connection connection,int addressId,String newAddress);
	void showAddress(Connection connection,int userId);
	
	
	//订单增查
	boolean addOrder(Connection connection,int addressId,Car car);	
	void ShowOrders(Connection connection);
	
	
	
	
	
}
