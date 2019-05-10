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
		 * ��¼��ע��
		 */
		boolean flg = true;
		while(flg){
			System.out.println("-------------------------");
			System.out.println("1.ע��		2.��¼");
			System.out.println("-------------------------");			
			System.out.println("��ѡ���ܣ�");
			int ch=scanner.nextInt();
			if (ch==1) {
				registerController.Register();				
			}else if (ch==2) {
				System.out.println("======��¼����======");
				connection = loginController.Login();
				flg = false;
			}else {
				System.out.println("û�д�ѡ��!");
			}			
		}
		/*
		 * ��¼�ɹ������
		 */
		flg = true;
		while (flg) {
			System.out.println("----------------------------------------------------------");
			System.out.println("----------------------------------------------------------");
			System.out.println("	1.��ҳ	2.�鿴���ﳵ		3.�鿴����	");
			System.out.println("		4.�����ջ���ַ	5.�˳�");
			System.out.println("----------------------------------------------------------");
			System.out.println("----------------------------------------------------------");
			System.out.println("��ѡ���ܣ�");
			int ch=scanner.nextInt();
			
			switch (ch) {
			case 1:
				shoppingController.ShowGoods(connection);				
				break;		
				
			case 2:				
				shoppingController.showCar(connection);
				while (true) {
					System.out.println("===============================");
					System.out.println("1.����	2.�ӹ��ﳵ�Ƴ� 	3.�˳�");
					System.out.println("===============================");
					ch = scanner.nextInt();
					if (ch==1) {
						shoppingController.addOrder(connection);
					}else if (ch==2) {
						shoppingController.showCar(connection);
						shoppingController.delCar(connection);
					}else if (ch==3) {
						System.out.println("�˳���...");
						break;
					}else {
						System.out.println("û�д�ѡ�Ĭ��Ϊ��ѡ���˳�...");
						break;
					}
				}
				System.out.println("�˳��ɹ���");
				break;	
				
			case 3:
				shoppingController.showOrders(connection);
				break;
				
			case 4:
				while(true){
					System.out.println("==========================================================");
					System.out.println("1.�޸ĵ�ַ	2.��ӵ�ַ 	3.ɾ����ַ	4.�˳�");
					System.out.println("==========================================================");
					System.out.println("��ǰ��ַ��");
					shoppingController.allAddress(connection);
					System.out.println("��ѡ��");
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
				System.out.println("SORRY!û�д�ѡ�������ѡ��");
				break;
			}
		}
		
	}

}
