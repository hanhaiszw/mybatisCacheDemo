# mybatis一级缓存二级缓存使用demo
## 建表语句
```mysql
CREATE TABLE employee(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
loginname VARCHAR(18),
PASSWORD VARCHAR(18),
NAME VARCHAR(18) DEFAULT NULL,
sex CHAR(2) DEFAULT NULL,
age INT(11) DEFAULT NULL,
phone VARCHAR(21),
sal DOUBLE,
state VARCHAR(18)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO employee (loginname,PASSWORD,NAME,sex,age,phone,sal,state) VALUES('jack','123456','杰克','男',26,'12345678936',9800,'ACTIVE');
INSERT INTO employee (loginname,PASSWORD,NAME,sex,age,phone,sal,state) VALUES('rose','123456','露丝','女',21,'78965412395',6800,'ACTIVE');
INSERT INTO employee (loginname,PASSWORD,NAME,sex,age,phone,sal,state) VALUES('tom','123456','汤姆','男',25,'13902017777',8800,'ACTIVE');
INSERT INTO employee (loginname,PASSWORD,NAME,sex,age,phone,sal,state) VALUES('alice','123456','爱丽丝','女',20,'74185296375',5800,'ACTIVE');
```
[参考网址](https://blog.csdn.net/zouxucong/article/details/68947052)
