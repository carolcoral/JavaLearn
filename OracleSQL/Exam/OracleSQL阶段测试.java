选择题（每题2分，共30分）
1.下列哪个选项表示Oracle中select语句的功能？ C
 A．可以用select语句改变Oracle中的数据 
 B．可以用select语句删除Oracle中的数据 
 C．可以用select语句和另一个表的内容生成一个表 
 D．可以用select语句对表结构进行修改

2.在Oracle中，有一个教师表 
teacher的结构如下：
 ID NUMBER(5)
 NAME VARCHAR2(25)
 EMAIL VARCHAR2(50) 

下面哪个语句查询没有Email地址的教师姓名（C）。
     
 A. SELECT name FROM teacher WHERE email = NULL; 
 B. SELECT name FROM teacher WHERE email  != NULL; 
 C.SELECT name FROM teacher WHERE email IS NULL;  
D. SELECT name FROM teacher WHERE email IS NOT NULL;

3.PL/SQL代码段中注释符号是（C）。 
 A、//        B、\\       C、--         D、’

4.下面删除test100这张表的指令是（C ）
A.alter table  test100；
B.delete table test100;
C.drop  table test100; 
D.delete from test100;

5.SQL语言又称为(C)
A.结构化定义语言
B.结构化控制语言
C.结构化查询语言
D.结构化操纵语言

6.cost表中id,unit_cost列数据如下：
ID    UNIT_COST
1     NULL
2     0.40
3     0.30
4     0.20
5     0.10
6     0.50 
sql语句select count(unit_cost) from cost 查询的结果为(C)：
A.2
B.6
C.5
D.0

7.在Oracle中，删除表Student中的所有数据，可以使用的Sql是（B）。
A.DROP TABLE Student
B.DELETE FROM Student
C.DELETE * FROM Student
D.DROP * FROM Student

8.select 语句中用来连接字符串的符号是（ C）
A."+"
B."&"
C."||"
D."|"

9.从 "员工" 表的"姓名"字段中找出名字包含"玛丽"的人，下面哪条 select 语句正确（D ）
A.select * from 员工 where 姓名='_玛丽_';
B.select * from 员工 where 姓名='%玛丽_';
C.select * from 员工 where 姓名 like '_玛丽%';
D.select * from 员工 where 姓名 like '%玛丽%'; 
10.有如下 SQL 片段：
delete from asdfh a where a.kaihrq > '20091214' and a.jiluzt != 1;
其含义为（A ）
A.对表 asdfh 中删除 kaihrq 大于 2009 年 12 月 14 日，且 jiluzt 不为 1 的记录做一个删除标记
B.从表 asdfh 中删除 kaihrq 和 jiluzt 列
C.从表 asdfh 中删除 kaihrq 大于 2009 年 12 月 14 日，且 jiluzt 不为 1 的记录
D.以上都不正确
11.sql语句中如何判断一个字段f的值是NULL值? D
  A  f==NULL   B f=NULL  C f is not NULL    D. f is NULL
12. 在Oracle中， 获得当前系统时间的查询语句是: C
A．sysdate；  
B．select sysdate；  
C．select sysdate from dual；  
D．select sysdate where common；
13.下面不是游标属性的是:D
A. FOUND
B．NOTFOUND
C. ISOPEN D. ISNULL 
14.回滚一个没有提交的事务可以使用的命令是：B
A．commit              
B．rollback  
C．savepoint          
D．connect
15. 如果为下列预编译SQL的第三个问号赋值，那么正确的选项是哪一个？ B
UPDATE emp SET ename=?,job=?,salary=? WHERE empno=?;
A. pst.setInt("3",2000);
B. pst.setInt(3,2000);
C. pst.setFloat(2,2000);
D. pst.setString("salary","2000");
 



简答题（每题5分，共20）
1.数据库语言可以分成5大类，分别是哪几种。
DML\DQL\DDL\TCL\DCL

2.Java中访问数据库的步骤?
Connection getConnection(){
	String url = “jdbc:mysql://localhost:3306/test”;
	String name = “root”;
	String passwd = “root”;
	Class.forname(“com.mysql.jdbc.Driver”);
	Connection connection = null;
	connection = DriverManager.getConnection(url,name,passwd);
}

3 JDBC中 PreparedStatement  比 Statement的优势有哪些  
简化了 sql 语句的拼接，减少了 sql 的频繁操作

4.PLSQL中游标的编写步骤是什么?写出关键语句
declare
	cursor
begin
	open
		fetch
close
编程题（前3题每题10分，最后一题20分 共50）
1.数据库表(Test)结构如下：
ID   NAME   AGE   MANAGER(所属主管人ID)

106   A      30    104
109   B      19    104
104   C      20    111
107   D      35    109
112   E      25    120
119   F      45    NULL

要求:
列出所有的领导 显示ID 和 名字  （分别使用子查询和Oracle的外连接来实现）
select  t.MANAGER  u.name  from Test t join user u on u.MANAGER = t.MANAGER;
commit;
列出所有的普通员工  显示 ID 和 名字 
select t.ID,t.name from Test where MANAGER is not null;
commit;
列出所有年龄比ID 等于112年龄大的员工 显示 ID 和 名字
select t.ID,t.NAME from Test where t.AGE>(select t.AGE from Test where t.ID = 112);
commit;
2.建立一张部门表S_DEPT的表结构是            员工表S_EMP的表结构是 
 ID       number   部门编号 pk               ID   number 员工编号   pk
 NAME    varchar2(30)部门名                   NAME varchar2(30) 地区名
                   SALARY  number   月薪
                   DEPT_ID   number  部门编号  fk
要求建立表之前 先删除表   考虑外键的情况
要求建立 主键约束 和 外键约束 
要求给部门表插入 数据  1  test1    2  test2    注意提交数据
要求给员工表插入 数据  1  ea   10000  1    2  eb   11000  1
3  ec  12000  2      4  ed   20000  2     5  ee  30000   2   注意提交数据
drop table  dept100 cascade constraints;          
  drop table  emp100 cascade constraints;
  create  table dept100(
      id   number  constraint dept100_id_pk  primary key,
      name varchar2(30)
  );
  insert into dept100 values(1,'test1');
  insert into dept100 values(2,'test2');
  commit;
  create table  emp100(
      id   number  constraint emp100_id_pk primary key,
      name  varchar2(30),
      salary  number,
      dept_id  number  constraint emp100_dept_id_fk references dept100(id)
  );
  insert into emp100 values(1,'ea',10000,1);
  insert into emp100 values(2,'eb',11000,1);
  insert into emp100 values(3,'ec',12000,1);
  insert into emp100 values(4,'ed',20000,2);
  insert into emp100 values(5,'ee',30000,2);
  commit;   

3. 写一个存储过程  有两个整数参数  打印两个参数的最大值 并且把两参数的和存入第二个参数中
Create  or replace  procedure   getMax(var_i  in  number,var_j  in out number)
Is
Begin
     If  var_i > var_j  then
         Dbms_output.put_line(var_i);
     Else
         Dbms_output.put_line(var_j);
     End if;
     var_sum:=var_i+var_j;
end;
4.写一个JDBC工具类   来读取项目src下db.properties  来获取连接  并 要在工具类中释放资源 使用工具类获取连接  并查询S_DEPT 表中所有的数据  然后打印这些数据

 db.properties  内容如下
 driverClassName=oracle.jdbc.OracleDriver
 url=jdbc:oracle:thin:@127.0.0.1:1521:xe
 username=system
 password=123456
 S_DEPT 表结构如下
 ID    NAME    REGION_ID

Public static Connection connection = null;
Public static Properties properties = new Properties();
Public void Connection getConnection(){
FileinputStream fis = new FileinputStream(“db.properties”);
properties.load(fis);
fis.close();
String url = properties.getProperty(“url”);
String username = properties.getProperty(“username”);
String password = properties.getProperty(“password”);
String driveClassName = properties.getProperty(“driverClassName”);
connection = DriverManager.getConnection(url,username,password);
Class.forname(driverClassName);
String sql = “select * from S_DEPT”;
PreparedStatement ps = connection.PrepareStatement(sql);
ResultSet res = ps.executeQuery();
while(res.next()){
	System.out.println(res.getString(“ID”)+","+res.getString(“NAME”)+","+res.getString(“REGION_ID”));
}
res.close();
ps.close();
connection.close();
}
