package com.oracle.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.oracle.dao.shoppingDaoImply;
import com.oracle.entity.Address;
import com.oracle.entity.Car;
import com.oracle.entity.Goods;
import com.oracle.entity.Order;
import com.oracle.utils.Session;

public class ShoppingServiceImply implements ShoppingService {
	
	private shoppingDaoImply shoppingdaoImply = new shoppingDaoImply();
	
	//��ʾ������Ʒ
	@Override
	public List<Goods> ShowGoods(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		return shoppingdaoImply.ShowGoods(connection);

	}
	
	
	
	//���빺�ﳵ
	@Override
	public boolean setCar(Connection connection,int goodsId,int count) {
		// TODO Auto-generated method stub

		try {
			Goods goods = shoppingdaoImply.getById(connection, goodsId);
			if (goods.getId()== goodsId) {
				int userId = Integer.parseInt(Session.getSession().getValue("userId"));
				shoppingdaoImply.setCar(connection,goodsId,count,userId);							
			}
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
					
	}

	//�鿴���ﳵ
	@Override
	public List<Car> ShowShopCar(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(Session.getSession().getValue("userId"));
		return shoppingdaoImply.ShowShopCar(connection,userId);		
	}
	
	//��ѯ���ﳵ����Ϣ
	@Override
	public Car getByCarId(Connection connection, int carId) {
		// TODO Auto-generated method stub
		Car car = null;
		try {
			car = shoppingdaoImply.getByCarId(connection, carId);
			return car;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;
	}
	
	//�Ƴ����ﳵ����Ʒ
	@Override
	public boolean delCar(Connection connection, int goodsId) {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(Session.getSession().getValue("userId"));
		try {
			shoppingdaoImply.delCar(connection, goodsId, userId);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//��ӵ�ַ
	@Override
	public boolean addAddress(Connection connection, Address address) {
		// TODO Auto-generated method stub
		try {
			shoppingdaoImply.addAddress(connection, address);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//�鿴��ַ
	@Override
	public void showAddress(Connection connection, int userId) {
		// TODO Auto-generated method stub
		try {
			List<Address> liAddresses = shoppingdaoImply.showAddress(connection, userId);
			System.out.println(liAddresses);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//�鿴����
	@Override
	public void ShowOrders(Connection connection) {
		// TODO Auto-generated method stub
		try {
			List<Order> list =shoppingdaoImply.ShowOrders(connection);
			System.out.println(list);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//��Ӷ���
	@Override
	public boolean addOrder(Connection connection, int addressId, Car car) {
		// TODO Auto-generated method stub
		try {
			shoppingdaoImply.addOrder(connection, addressId, car);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	//ɾ����ַ
	@Override
	public boolean delAddress(Connection connection, int addressId) {
		// TODO Auto-generated method stub
		try {
			shoppingdaoImply.delAddress(connection, addressId);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	//���µ�ַ
	@Override
	public boolean updateAddress(Connection connection, int addressId, String newAddress) {
		// TODO Auto-generated method stub
		try {
			shoppingdaoImply.updateAddress(connection, addressId, newAddress);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}



	


	



	




	

}
