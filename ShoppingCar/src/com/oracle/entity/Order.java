package com.oracle.entity;

import java.sql.Date;

public class Order {
	private Integer id;
	private Integer goods_id;
	private Integer user_id;
	private Integer address_id;
	private Integer counts;
	private Double totalprice;
	private Integer order_satus;
	private Date order_time;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public Integer getOrder_satus() {
		return order_satus;
	}
	public void setOrder_satus(Integer order_satus) {
		this.order_satus = order_satus;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	@Override
	public String toString() {
		return "[订单编号=" + id + ", 商品编号=" + goods_id + ", 用户编号=" + user_id + ", 地址编号=" + address_id
				+ ", 数量=" + counts + ", 总价=" + totalprice + ", 订单状态=" + order_satus + ", 下单时间="
				+ order_time + "]";
	}
	
	
	

}
