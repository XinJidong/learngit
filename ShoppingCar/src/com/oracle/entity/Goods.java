package com.oracle.entity;

public class Goods {
	private int id;
	private String goods_name;
	private String type_id;
	private double price;
	private int num;
	private int goods_status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getGoods_status() {
		return goods_status;
	}
	public void setGoods_status(int goods_status) {
		this.goods_status = goods_status;
	}


	@Override
	public String toString() {
		return "[商品编号=" + id + ", 商品名称=" + goods_name + ", 价格=" + price + ", 种类=" + type_id + ", 数量=" + num
				+ ", 状态=" + goods_status + "]\n";
	}
	
	
}
