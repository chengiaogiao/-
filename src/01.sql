#创建数据库
create database cyj_01;
#创建数据库并设置编码
create database cyj_02 character set utf8;
#船舰数据库并设置编码 以及校对规则
create database cyj_03 character set utf8 collate utf8mb3_bin;
create database cyj_04;
#删除数据库
drop database cyj_03;
#显示所有数据库
show databases;
#显示指定数据库信息
show create database cyj_03;
#关键字用反引号
create database `creat`;
#备份
#mysqldump -u root -p -B cyj_03>f:\\bak.sql
#建表  unsigned  无符号  从负的开始   有符号从0开始   自动更新时间戳
create table user1
(
    id int unsigned,
    name varchar(255),
    password varchar(32),
    birthday date,
    test varchar(3),
    t timestamp not null default  current_timestamp on update  current_timestamp
) character set utf8 collate utf8mb3_bin engine innodb;
create table emp
(
    id int unsigned,
    name varchar(255),
    sex char(1),
    birthday date,
    entry_date timestamp not null default  current_timestamp,
    job varchar(20),
    salary double,
    resume text,
    t timestamp not null default  current_timestamp on update  current_timestamp
) character set utf8 collate utf8mb3_bin engine innodb;
insert into `user` values (125,'张三','123456', '2026-09-16',null);

TRUNCATE TABLE cyj_03.`user`;