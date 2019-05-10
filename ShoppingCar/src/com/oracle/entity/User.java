package com.oracle.entity;

import java.util.List;

public class User {
	private int id;
	private String user;
	private String password;
	private int address_id;
	private int role;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "User [uid=" + id + ", user=" + user + ", password=" + password + ", address_id=" + address_id + ",role=" + role + "]";
	}
	
	/*
	 * ¹ºÎï³µ
	 */
	//private List<E>

}
