package com.oracle.controller;

import java.sql.Connection;
import java.util.Scanner;

import com.oracle.entity.User;
import com.oracle.exception.NullUserException;
import com.oracle.service.LoginServiceImply;
import com.oracle.utils.Session;

public class LoginController {
	
	private LoginServiceImply loginServiceImply = new LoginServiceImply();
	public Connection Login() {		
		
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		Connection connection = null;
		
		System.out.println("�����û�����");
		String inputUser = scanner.next();
		System.out.println("�������룺");
		String inputPassword = scanner.next();
		user.setUser(inputUser);
		user.setPassword(inputPassword);
		
		try {
			connection=loginServiceImply.getByUser(user);
			System.out.println("��½�ɹ���");
		} catch (NullUserException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}	
		return connection;
	}
}
