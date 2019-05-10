-- 用户表	role 0用户 1商家 2管理员
create table  users(
id int not null primary key auto_increment,
user varchar(20),
password varchar(10),
address_id int,
role int
);


-- 配送地址    (状态: 1 删除 0正常)
create table address(
id int not null primary key auto_increment,
user_id int ,
address varchar(150),
address_status int
);


-- 商品表    状态1下架， 0正常
create table goods(
id int not null primary key auto_increment,
goods_name varchar(50),
type_id int,
price double,
num int,
goods_status int
);


-- 商品类型
create table goodsType(
id int not null primary key auto_increment,
goods_type_name varchar(20)
);


-- 购物车    状态 1 移除（订单已完成）  0显示(未下订单)
create table car(
id int not null primary key auto_increment,
goods_id int,
counts int ,
totalprice double,
add_time date,
user_id int,
goods_status int
);


-- 订单表     0未支付，1 已完成  时间
create table orders(
id int not null primary key auto_increment,
goods_id int ,
user_id int,
address_id int ,
counts int,
totalprice double,
order_status int,
order_time date
);