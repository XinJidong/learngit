package com.oracle.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.oracle.entity.User;
import com.oracle.exception.ExistUserException;
import com.oracle.service.RegisterServiceImply;

public class RegisterController {
	
	public void Register() {
		RegisterServiceImply registerServiceImply = new RegisterServiceImply();
		User new_user = new User();
		Scanner scanner = new Scanner(System.in);
		System.out.println("======ע�����======");
		
		System.out.println("�������û�����");
		String username = scanner.next(); 
		System.out.println("���������룺");
		String password = scanner.next();
		System.out.println("ȷ�����룺");
		String password2 = scanner.next();
			
		if (password.equals(password2)) {
			new_user.setUser(username);
			new_user.setPassword(password);
			try {
				registerServiceImply.setUser(new_user);					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExistUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} else {
			System.out.println("�������벻��ͬ��������������Ϣ��");
			Register();
		}	
		
	}
}
