package com.oracle.utils;

import java.util.HashMap;
import java.util.Map;

public class Session {
	private static Session session;
	/*
	 * �洢��½�������
	 */
	private Map<String, String> map = new HashMap(); 	//userId(��ǰ�û�id)--
	 
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
