-- �û���	role 0�û� 1�̼� 2����Ա
create table  users(
id int not null primary key auto_increment,
user varchar(20),
password varchar(10),
address_id int,
role int
);


-- ���͵�ַ    (״̬: 1 ɾ�� 0����)
create table address(
id int not null primary key auto_increment,
user_id int ,
address varchar(150),
address_status int
);


-- ��Ʒ��    ״̬1�¼ܣ� 0����
create table goods(
id int not null primary key auto_increment,
goods_name varchar(50),
type_id int,
price double,
num int,
goods_status int
);


-- ��Ʒ����
create table goodsType(
id int not null primary key auto_increment,
goods_type_name varchar(20)
);


-- ���ﳵ    ״̬ 1 �Ƴ�����������ɣ�  0��ʾ(δ�¶���)
create table car(
id int not null primary key auto_increment,
goods_id int,
counts int ,
totalprice double,
add_time date,
user_id int,
goods_status int
);


-- ������     0δ֧����1 �����  ʱ��
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