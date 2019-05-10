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
	 * 首页
	 */
	public void ShowGoods(Connection connection) {
		try {
			List<Goods> list = shoppingServiceImply.ShowGoods(connection);
			
			System.out.println(list);
			System.out.println("是否有心仪物品加入购物车Y/N:");
			String x = scanner.next();
			boolean flg = true;
			if (x.equals("Y")||x.equals("y")) {
				
				flg = setCar(connection);
				if (flg) {
					System.out.println("添加成功！");

				} else {
					System.out.println("添加失败！");
				}
				
			} else if (x.equals("X")||x.equals("x")) {
				System.out.println("退出添加购物车");
			} else {
				System.out.println("没有此选项！默认为您不添加");
			}
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/*
	 * 加入购物车
	 */
	public boolean setCar(Connection connection) {	
		System.out.println("输入想要添加的商品编号：");			
		int goodsId = scanner.nextInt();
		System.out.println("请输入想要添加的商品数量：");
		int count = scanner.nextInt();
		return shoppingServiceImply.setCar(connection,goodsId,count);
		
	}
	
	/*
	 * 查看购物车
	 */
	public void showCar(Connection connection) {
		System.out.println("===========================");
		System.out.println("当前用户："+Session.getSession().getValue("userId"));
		System.out.println("当前购物车内容：");
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
	 * 从购物车移除
	 */
	public void delCar(Connection connection) {
		System.out.println("请输入想移除的商品编号");
		int goodsId = scanner.nextInt();
		if(shoppingServiceImply.delCar(connection, goodsId)){
			System.out.println("删除成功！");
		}
		
	}
	
	/*
	 * 下订单
	 */
	public void addOrder(Connection connection) {
		System.out.println("请输入想要下订单的商品的购物车编号：");
		int carId = scanner.nextInt();
		Car car = shoppingServiceImply.getByCarId(connection, carId);
		if(car==null){
			System.err.println("没有此购物车编号！");
		}		
		System.out.println("请选择 收货地址编号：");
		allAddress(connection);
		int addressId = scanner.nextInt();
		if (shoppingServiceImply.addOrder(connection, addressId, car)) {
			System.out.println("下订单成功！");
		}	
		
	}
	
	/*
	 * 添加收货地址
	 */
	public void addAddress(Connection connection){
		Address address = new Address();
		System.out.println("请输入收货地址：");
		address.setAddress(scanner.next());
		address.setAddress_status(0);
		address.setUser_id(Integer.parseInt(Session.getSession().getValue("userId")));
		 if(shoppingServiceImply.addAddress(connection, address)){
			 System.out.println("添加成功！");
		 }
	}
	/*
	 * 删除收货地址
	 */
	public void delAddress(Connection connection) {
		System.out.println("请输入要删除的地址编号：");
		int addressId = scanner.nextInt();
		if(shoppingServiceImply.delAddress(connection, addressId)){
			System.out.println("删除成功！");
		}
	}
	/*
	 * 更新地址
	 */
	public void updateAddress(Connection connection) {
		System.out.println("请输入要更新的地址编号：");
		int addressId = scanner.nextInt();
		System.out.println("请输入新的地址：");
		shoppingServiceImply.updateAddress(connection, addressId, scanner.next());
	}
	/*
	 * 查看收货地址
	 */
	public void allAddress(Connection connection) {
		int userId = Integer.parseInt(Session.getSession().getValue("userId"));
		shoppingServiceImply.showAddress(connection, userId);
	}
	
	
	/*
	 * 查看所有订单
	 */
	public void showOrders(Connection connection) {
		shoppingServiceImply.ShowOrders(connection);
	}
}
