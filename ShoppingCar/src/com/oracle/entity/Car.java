package com.oracle.entity;

import java.sql.Date;

public class Car {
	private Integer id;
	private Integer goods_id;
	private Integer counts;
	private Double totalprice;
	private Date add_time;
	private Integer user_id;
	private Integer goods_states;
	
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
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getGoods_states() {
		return goods_states;
	}
	public void setGoods_states(Integer goods_states) {
		this.goods_states = goods_states;
	}
	@Override
	public String toString() {
		return "[���=" + id + ", ��Ʒ���=" + goods_id + ", ����=" + counts + ", �ܼ�=" + totalprice
				+ ", ���ʱ��=" + add_time + ", �û����=" + user_id + ", ��Ʒ״̬ =" + goods_states + "]\n";
	}
	
	
}
