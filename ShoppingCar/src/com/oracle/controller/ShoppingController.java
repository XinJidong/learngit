package com.oracle.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.oracle.entity.Address;
import com.oracle.entity.Car;
import com.oracle.entity.Goods;
import com.oracle.service.ShoppingServiceImply;
import com.oracle.utils.Session;

public class ShoppingController {
	
	private ShoppingServiceImply shoppingServiceImply = new ShoppingServiceImply();
	Scanner scanner = new Scanner(System.in);
	
	/*
	 * ��ҳ
	 */
	public void ShowGoods(Connection connection) {
		try {
			List<Goods> list = shoppingServiceImply.ShowGoods(connection);
			
			System.out.println(list);
			System.out.println("�Ƿ���������Ʒ���빺�ﳵY/N:");
			String x = scanner.next();
			boolean flg = true;
			if (x.equals("Y")||x.equals("y")) {
				
				flg = setCar(connection);
				if (flg) {
					System.out.println("��ӳɹ���");

				} else {
					System.out.println("���ʧ�ܣ�");
				}
				
			} else if (x.equals("X")||x.equals("x")) {
				System.out.println("�˳���ӹ��ﳵ");
			} else {
				System.out.println("û�д�ѡ�Ĭ��Ϊ�������");
			}
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/*
	 * ���빺�ﳵ
	 */
	public boolean setCar(Connection connection) {	
		System.out.println("������Ҫ��ӵ���Ʒ��ţ�");			
		int goodsId = scanner.nextInt();
		System.out.println("��������Ҫ��ӵ���Ʒ������");
		int count = scanner.nextInt();
		return shoppingServiceImply.setCar(connection,goodsId,count);
		
	}
	
	/*
	 * �鿴���ﳵ
	 */
	public void showCar(Connection connection) {
		System.out.println("===========================");
		System.out.println("��ǰ�û���"+Session.getSession().getValue("userId"));
		System.out.println("��ǰ���ﳵ���ݣ�");
		try {
			List<Car> list = shoppingServiceImply.ShowShopCar(connection);
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("===========================");
	}
	
	/*
	 * �ӹ��ﳵ�Ƴ�
	 */
	public void delCar(Connection connection) {
		System.out.println("���������Ƴ�����Ʒ���");
		int goodsId = scanner.nextInt();
		if(shoppingServiceImply.delCar(connection, goodsId)){
			System.out.println("ɾ���ɹ���");
		}
		
	}
	
	/*
	 * �¶���
	 */
	public void addOrder(Connection connection) {
		System.out.println("��������Ҫ�¶�������Ʒ�Ĺ��ﳵ��ţ�");
		int carId = scanner.nextInt();
		Car car = shoppingServiceImply.getByCarId(connection, carId);
		if(car==null){
			System.err.println("û�д˹��ﳵ��ţ�");
		}		
		System.out.println("��ѡ�� �ջ���ַ��ţ�");
		allAddress(connection);
		int addressId = scanner.nextInt();
		if (shoppingServiceImply.addOrder(connection, addressId, car)) {
			System.out.println("�¶����ɹ���");
		}	
		
	}
	
	/*
	 * ����ջ���ַ
	 */
	public void addAddress(Connection connection){
		Address address = new Address();
		System.out.println("�������ջ���ַ��");
		address.setAddress(scanner.next());
		address.setAddress_status(0);
		address.setUser_id(Integer.parseInt(Session.getSession().getValue("userId")));
		 if(shoppingServiceImply.addAddress(connection, address)){
			 System.out.println("��ӳɹ���");
		 }
	}
	/*
	 * ɾ���ջ���ַ
	 */
	public void delAddress(Connection connection) {
		System.out.println("������Ҫɾ���ĵ�ַ��ţ�");
		int addressId = scanner.nextInt();
		if(shoppingServiceImply.delAddress(connection, addressId)){
			System.out.println("ɾ���ɹ���");
		}
	}
	/*
	 * ���µ�ַ
	 */
	public void updateAddress(Connection connection) {
		System.out.println("������Ҫ���µĵ�ַ��ţ�");
		int addressId = scanner.nextInt();
		System.out.println("�������µĵ�ַ��");
		shoppingServiceImply.updateAddress(connection, addressId, scanner.next());
	}
	/*
	 * �鿴�ջ���ַ
	 */
	public void allAddress(Connection connection) {
		int userId = Integer.parseInt(Session.getSession().getValue("userId"));
		shoppingServiceImply.showAddress(connection, userId);
	}
	
	
	/*
	 * �鿴���ж���
	 */
	public void showOrders(Connection connection) {
		shoppingServiceImply.ShowOrders(connection);
	}
}
