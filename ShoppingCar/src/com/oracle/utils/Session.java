package com.oracle.utils;

import java.util.HashMap;
import java.util.Map;

public class Session {
	private static Session session;
	/*
	 * 存储登陆后的密码
	 */
	private Map<String, String> map = new HashMap(); 	//userId(当前用户id)--
	 
	public static Session getSession() {
		if (session == null) {
			session = new Session();
		}
		return session;
	}

	public String getValue(String key) {
		return map.get(key);
	}

	public void setValue(String key,String i) {
		map.put(key, i);
	}
	
	
}
