package com.oracle.entity;

public class Address {
	private Integer id;
	private Integer user_id;
	private String address;
	private Integer address_status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAddress_status() {
		return address_status;
	}
	public void setAddress_status(Integer address_status) {
		this.address_status = address_status;
	}
	@Override
	public String toString() {
		return "[��ַ���=" + id + ", ��ǰ�û����=" + user_id + ", ��ַ��Ϣ=" + address + ", �˵�ַ״̬="
				+ address_status + "]\n";
	}
	
	
}
