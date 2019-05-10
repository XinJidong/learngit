package com.java.test;

import java.sql.Connection;
import java.util.Scanner;

import com.oracle.controller.LoginController;
import com.oracle.controller.RegisterController;
import com.oracle.controller.ShoppingController;
import com.oracle.utils.DButil;

public class Test {

	public static void main(String[] args) {
		LoginController loginController = new LoginController();
		RegisterController registerController = new RegisterController();
		ShoppingController shoppingController = new ShoppingController();
		
		Scanner scanner = new Scanner(System.in);
		Connection connection = null  ;
		
		/*
		 * 登录、注册
		 */
		boolean flg = true;
		while(flg){
			System.out.println("-------------------------");
			System.out.println("1.注册		2.登录");
			System.out.println("-------------------------");			
			System.out.println("请选择功能：");
			int ch=scanner.nextInt();
			if (ch==1) {
				registerController.Register();				
			}else if (ch==2) {
				System.out.println("======登录界面======");
				connection = loginController.Login();
				flg = false;
			}else {
				System.out.println("没有此选项!");
			}			
		}
		/*
		 * 登录成功后界面
		 */
		flg = true;
		while (flg) {
			System.out.println("----------------------------------------------------------");
			System.out.println("----------------------------------------------------------");
			System.out.println("	1.首页	2.查看购物车		3.查看订单	");
			System.out.println("		4.管理收货地址	5.退出");
			System.out.println("----------------------------------------------------------");
			System.out.println("----------------------------------------------------------");
			System.out.println("请选择功能：");
			int ch=scanner.nextInt();
			
			switch (ch) {
			case 1:
				shoppingController.ShowGoods(connection);				
				break;		
				
			case 2:				
				shoppingController.showCar(connection);
				while (true) {
					System.out.println("===============================");
					System.out.println("1.购买	2.从购物车移除 	3.退出");
					System.out.println("===============================");
					ch = scanner.nextInt();
					if (ch==1) {
						shoppingController.addOrder(connection);
					}else if (ch==2) {
						shoppingController.showCar(connection);
						shoppingController.delCar(connection);
					}else if (ch==3) {
						System.out.println("退出中...");
						break;
					}else {
						System.out.println("没有此选项，默认为您选择退出...");
						break;
					}
				}
				System.out.println("退出成功！");
				break;	
				
			case 3:
				shoppingController.showOrders(connection);
				break;
				
			case 4:
				while(true){
					System.out.println("==========================================================");
					System.out.println("1.修改地址	2.添加地址 	3.删除地址	4.退出");
					System.out.println("==========================================================");
					System.out.println("当前地址：");
					shoppingController.allAddress(connection);
					System.out.println("请选择：");
					int x = scanner.nextInt();
					if (x==1) {
						shoppingController.updateAddress(connection);
					}else if (x==2) {
						shoppingController.addAddress(connection);
					}else if (x==3) {
						shoppingController.delAddress(connection);
					}else {
						break;
					}
				}
				break;
				
			case 5:
				flg=false;
				break;	
				
			default:
				System.out.println("SORRY!没有此选项，请重新选择！");
				break;
			}
		}
		
	}

}
