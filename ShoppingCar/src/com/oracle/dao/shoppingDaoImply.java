package com.oracle.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oracle.entity.Address;
import com.oracle.entity.Car;
import com.oracle.entity.Goods;
import com.oracle.entity.Order;
import com.oracle.utils.DButil;
import com.oracle.utils.Session;

public class shoppingDaoImply implements ShoppingDao {

	/*
	 *显示所有商品 
	 */
	@Override
	public List<Goods> ShowGoods(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		List<Goods>  list = new ArrayList<Goods>();
		
		ResultSet resultSet = DButil.executeQuery(connection, "select * from goods", new Object[]{});
		while (resultSet.next()) {
			Goods goods = new Goods();
			goods.setId(resultSet.getInt(1));
			goods.setGoods_name(resultSet.getString(2));
			goods.setType_id(resultSet.getString(3));
			goods.setPrice(resultSet.getDouble(4));			
			goods.setNum(resultSet.getInt(5));
			goods.setGoods_status(resultSet.getInt(6));
			
			list.add(goods);
		}
		return list;		
	}
	
	/*
	 * 添加到购物车
	 */
	@Override
	public void setCar(Connection connection,int goodsId,int count,int userId) throws SQLException {
		// TODO Auto-generated method stub
		Goods goods = getById(connection, goodsId);
		DButil.executeUpdate(connection, "insert into car(goods_id,counts,totalprice,add_time,user_id,goods_status) values(?,?,?,?,?,?)  ", new Object[]{goodsId,count,count*goods.getPrice(),new Date(),userId,0});
		
	}
	
	/*
	 * 查询出要添加到购物车的商品
	 */
	@Override
	public Goods getById(Connection connection, int goodsId) throws SQLException {
		// TODO Auto-generated method stub
		Goods goods = new Goods();
		ResultSet resultSet = DButil.executeQuery(connection, "select * from goods where id=?", new Object[]{goodsId});
		while (resultSet.next()) {
			goods.setId(resultSet.getInt("id"));
			goods.setPrice(resultSet.getDouble("price"));
			goods.setNum(resultSet.getInt("num"));			
		}
		return goods;
	}
	
	
	/*
	 * 查看购物车
	 */
	@Override
	public List<Car> ShowShopCar(Connection connection,int userId) throws SQLException {
		// TODO Auto-generated method stub
		List<Car> carlist = new ArrayList<Car>();
		ResultSet resultSet = DButil.executeQuery(connection, "select g.goods_name,t.goods_type_name 'type',c.* from goods g,car c,goodstype t where (c.goods_id=g.id and g.type_id=t.id) and c.user_id=? and c.goods_status=0", new Object[]{userId});
		while (resultSet.next()) {
			Car cars = new Car();
			cars.setId(resultSet.getInt("id"));
			cars.setGoods_id(resultSet.getInt("goods_id"));
			cars.setCounts(resultSet.getInt("counts"));
			cars.setTotalprice(resultSet.getDouble("totalprice"));			
			cars.setAdd_time(resultSet.getDate("add_time"));
			cars.setUser_id(resultSet.getInt("user_id"));
			cars.setGoods_states(resultSet.getInt("goods_status"));
			
			carlist.add(cars);
		}
		return carlist;
		
	}

	//查询购物车id
	@Override
	public Car getByCarId(Connection connection,int carId) throws NumberFormatException, SQLException {
		// TODO Auto-generated method stub
		ResultSet resultSet = DButil.executeQuery(connection, "select * from car where id=? and goods_status=0 and user_id=?", new Object[]{carId,Integer.parseInt(Session.getSession().getValue("userId"))});
		Car car = new Car();
		while (resultSet.next()) {
			car.setId(resultSet.getInt(1));
			car.setGoods_id(resultSet.getInt("goods_id"));
			car.setCounts(resultSet.getInt("counts"));
			car.setTotalprice(resultSet.getDouble("totalprice"));			
			car.setAdd_time(resultSet.getDate("add_time"));
			car.setUser_id(resultSet.getInt("user_id"));
			car.setGoods_states(resultSet.getInt("goods_status"));			
		}
		return car;
	}
		
	//删除购物车内商品
	public void delCar(Connection connection, int goodsId, int userId) throws SQLException {
		DButil.executeUpdate(connection, "delete from car where goods_id=? and user_id=?", new Object[]{goodsId,userId});
	}

	//添加地址
	@Override
	public void addAddress(Connection connection, Address address) throws SQLException {
		// TODO Auto-generated method stub
		DButil.executeUpdate(connection, "insert into address(user_id,address,address_status) values(?,?,?)", new Object[]{address.getUser_id(),address.getAddress(),address.getAddress_status()});
		
	}

	//查看地址
	@Override
	public List<Address> showAddress(Connection connection,int userId) throws SQLException {
		// TODO Auto-generated method stub
		List<Address> liAddresses = new ArrayList<Address>();
		ResultSet resultSet = DButil.executeQuery(connection, "select * from address where user_id=?", new Object[]{userId});
		while (resultSet.next()) {
			Address address = new Address();
			address.setId(resultSet.getInt(1));
			address.setUser_id(resultSet.getInt(2));
			address.setAddress(resultSet.getString(3));
			address.setAddress_status(resultSet.getInt(4));
			
			liAddresses.add(address);			
		}
		return liAddresses;
	}

	
	//删除地址
	@Override
	public void delAddress(Connection connection, int addressId) throws SQLException {
		// TODO Auto-generated method stub
		DButil.executeUpdate(connection, "delete from address where id=?", new Object[]{addressId});
	}
	
	//更新地址
	@Override
	public void updateAddress(Connection connection, int addressId ,String newAddress) throws SQLException {
		// TODO Auto-generated method stub
		DButil.executeUpdate(connection, "update address set address=? where id=?", new Object[]{newAddress,addressId});
	}

	//添加订单
		@Override
		public void addOrder(Connection connection, int addressId, Car car) throws SQLException {
			// TODO Auto-generated method stub
			//添加到订单表
			DButil.executeUpdate(connection, "insert into orders(goods_id,user_id,address_id,counts,totalprice,order_status,order_time) values(?,?,?,?,?,?,?)", 
					new Object[]{car.getGoods_id(),car.getUser_id(),addressId,car.getCounts(),car.getTotalprice(),1,new Date()});
			
			//商品表中库存修改
			DButil.executeUpdate(connection, "update goods set num=num-? where id=? and goods_status=0", new Object[]{car.getCounts(),car.getGoods_id()});
			
			
			//购物车表中状态修改为1
			DButil.executeUpdate(connection, "update car set goods_status=1 where id=?", new Object[]{car.getId()});
		}

		
		//查询订单
		@Override
		public List<Order> ShowOrders(Connection connection) throws NumberFormatException, SQLException {
			// TODO Auto-generated method stub
			List<Order> list = new  ArrayList<Order>();
			ResultSet resultSet = DButil.executeQuery(connection, "select * from orders where user_id=?", new Object[]{Integer.parseInt(Session.getSession().getValue("userId"))});
			while(resultSet.next()){
				Order order = new Order();
				order.setId(resultSet.getInt(1));
				order.setGoods_id(resultSet.getInt(2));
				order.setUser_id(resultSet.getInt(3));
				order.setAddress_id(resultSet.getInt(4));
				order.setCounts(resultSet.getInt(5));
				order.setTotalprice(resultSet.getDouble(6));
				order.setOrder_satus(resultSet.getInt(7));
				order.setOrder_time(resultSet.getDate(8));
				list.add(order);
			}
			return list;
		}

}
