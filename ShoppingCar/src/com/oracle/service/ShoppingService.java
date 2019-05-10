package com.oracle.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Address;
import com.oracle.entity.Car;
import com.oracle.entity.Goods;

public interface ShoppingService {
	List<Goods> ShowGoods(Connection connection ) throws SQLException;
	
	//���ﳵ��ɾ��
	boolean setCar(Connection connection,int goodsId,int count);	
	List<Car> ShowShopCar(Connection connection) throws SQLException;	
	Car getByCarId(Connection connection,int carId);
	boolean delCar(Connection connection,int goodsId);
	
	
	//��ַ��ɾ�Ĳ�
	boolean addAddress(Connection connection,Address address);
	boolean delAddress(Connection connection,int addressId);
	boolean updateAddress(Connection connection,int addressId,String newAddress);
	void showAddress(Connection connection,int userId);
	
	
	//��������
	boolean addOrder(Connection connection,int addressId,Car car);	
	void ShowOrders(Connection connection);
	
	
	
	
	
}
