早测
  建表 学生表和班级表，学生表：学号/姓名/出生日期/电话/班级编号；班级表：编号/名称。(序列和约束要求自己建)
  插入一些数据，实现如下查询：
  1 查询电话号码是138，139开头的学生信息(学号/姓名/电话)
  2 查询出生时间在下午2点到3点之间的学生信息(学号/姓名/电话/出生日期)
  3 查询学生信息(学号/姓名/班级名称)
  
Oracle的数据字典  --  就是Oracle的系统表，记录了用户的各种操作。
 select table_name from tabs;   -- 查看当前用户都有哪些表   user_tables
 select table_name from user_tables;
 select object_name,object_type from user_objects; -- 查看当前用户都有哪些对象
 select constraint_name,constraint_type,table_name from user_constraints;
 
异常
    系统预定义异常
    1001  
    用户自定义异常 

    create table test(id number primary key,
    name  varchar2(30));

    declare
        var_name  emp.ename%type;
    begin
        select ename  into var_name from emp
	where empno>1;
	dbms_output.put_line('hello');
    exception
        when  too_many_rows   then
	    -- 处理返回过多行
	    dbms_output.put_line(sqlcode||'@'||sqlerrm);
	    dbms_output.put_line('too many rows');     
	when  no_data_found  then
	    --记录日志
            dbms_output.put_line('no data found!!');
	    rollback; 	
         when  others  then
	    -- 其它异常的处理
	    dbms_output.put_line('other exception');
    end;
---------------------------------------------
用户自定义异常
declare
    too_many_emp    exception; 
    too_many_dept   exception; 
    var_name       varchar2(30); 
begin
    /*根据条件抛出异常*/
    if 1=1  then
        raise too_many_dept;
    end if; 
    if  1=1  then
        raise  too_many_emp;
    end if; 
exception
    when  too_many_emp  then
        dbms_output.put_line('too many emp');
    when  too_many_dept  then
        dbms_output.put_line('too many dept');
	dbms_output.put_line(sqlcode||'@'||sqlerrm);
end;

捕获到异常之后:
    1.记录错误相关信息  放入相关日志表  
      SQLCODE   SQLERRM
    2.如果有事务相关的操作
      一般是要rollback
---------------------------------------------
过程和函数
 
定义两个整数   在执行区判断那个大就输出那个
declare
    var_x   number:=1;
    var_y   number:=100;
begin
    if  var_x>var_y then
        dbms_output.put_line(var_x);
    else
        dbms_output.put_line(var_y);
    end if;
end;

上面的代码 叫匿名块

存储过程   
create or replace procedure getmax
is
    var_x   number:=1;
    var_y   number:=100;
begin
    if  var_x>var_y then
        dbms_output.put_line(var_x);
    else
        dbms_output.put_line(var_y);
    end if;
end;

查看存储过程  
desc  getmax

调用存储过程
call  getmax();
存储过程创建时并不执行，想执行必须call。

带参数的存储过程：
create or replace procedure getmax(var_x number,var_y number)
is
begin
    if  var_x>var_y then
        dbms_output.put_line(var_x);
    else
        dbms_output.put_line(var_y);
    end if;
end;

Argument Name                  Type                    In/Out Default?
------------------------------ ----------------------- ------ --------
VAR_X                          NUMBER                  IN
VAR_Y                          NUMBER                  IN

call  getmax(1,9527);

练习：
  写一个存储过程，实现转账的功能。
  先建账户表，包括：账号/用户名/密码/金额
  然后插入两条数据，做转出方和转入方，要commit。
  写存储过程，带参(两个账户，一个转账金额)
  然后调用测试。
  drop table account;
  create table account (
   id number(10) primary key,
   name varchar2(40) not null,
   passwd varchar2(20),
   money number(12,2));
  drop sequence seq_account;
  create sequence seq_account start with 100000;
  insert into account values(seq_account.nextval,'zhangfei','111',1000);
  insert into account values(seq_account.nextval,'guanyu','111',1000);
  commit;
  
  create  or replace procedure  movemoney(var_x  number,
   var_y number,var_money number) is
    var_xmoney number;
  begin
    select money into var_xmoney from account where id=var_x;
    dbms_output.put_line(var_xmoney);
    if var_money<=0 then
        dbms_output.put_line('转账金额不能为负数！');
    elsif var_money>=var_xmoney then
        dbms_output.put_line('没有那么多钱了！');
    else
        update account set money=money-var_money where id=var_x;
        update account set money=money+var_money where id=var_y;
        commit;
        dbms_output.put_line('转账完成！！！');
    end if;
    exception
        when too_many_rows then
	    dbms_output.put_line('too many rows');     
	when  no_data_found  then
	    dbms_output.put_line('no data found!!');
            rollback;	    	
        when  others  then
	    dbms_output.put_line('other exception');
            rollback; 
  end;

参数模式：
in        代表输入参数  默认类型
out       输出参数（负责返回结果）
in out    即负责输入又赋值输出 


create  or replace procedure  getmax(var_x  in  number,
var_y  in number, res out number)
is
begin
    if  var_x>var_y then
        dbms_output.put_line(var_x);
    else
        dbms_output.put_line(var_y);
    end if;
    res:=var_x+var_y;
end;

调用：
declare
var_res   number:=0;
begin
getmax(1,9527,var_res);
dbms_output.put_line(var_res);
end;

SQL> desc getmax
PROCEDURE getmax
 Argument Name                  Type                    In/Out Default?
 ------------------------------ ----------------------- ------ --------
 VAR_X                          NUMBER                  IN
 VAR_Y                          NUMBER                  IN
 VAR_Z                          NUMBER                  OUT



out类型的参数必须是变量
in  out   也必须是变量

call getmax(1,9527,变量);
如果存储过程中使用了out类型的参数，call就无法调用，必须再写一个块去调用。
匿名块 或者有名块
declare
var_res   number:=0;
begin
getmax(1,9527,var_res);
dbms_output.put_line(var_res);
end;

另一种调用存储过程的方式

getmax(1,9527,var_res); 是位置调用

还可以使用名字调用
SQL> desc getmax
PROCEDURE getmax
 Argument Name                  Type                    In/Out Default?
 ------------------------------ ----------------------- ------ --------
 VAR_X                          NUMBER                  IN
 VAR_Y                          NUMBER                  IN
 RES                            NUMBER                  OUT

 给参数名 赋值使用=>
declare
var_res   number:=0;
begin
getmax(res=>var_res,var_x=>1,var_y=>9527);
dbms_output.put_line(var_res);
end;

建立一个存储过程？
create or replace procedure 过程名(参数)
is
   相当于申明区
begin
   执行区
end;


查看存储过程  
desc  过程

调用：
    没有out类型 则可以直接使用call
    匿名块或者有名块
    1.位置参数赋值
    2.参数名赋值  =>

函数是什么？
1.建立函数的语法
  create or replace function  函数名(参数)
  return type
  is
  begin
     必须有返回值  
     return 1;
  end;


写一个函数  得到两个数的最大值
drop procedure getmax;
create or replace function getmax(x in number, y in  number)
return  number
is
begin
    if x>y then
        return x;
    end if;
    return y;
end;
select getmax(2,3) from dual;  -- SQL语句可以直接使用函数。
函数和过程的区别？
1.关键字 
2.函数有返回值  过程没有
3.过程是plsql的语句的一部分 
  函数是表达式的一部分
----------------------------------------

包   package

dbms_output.put_line('hello');

查看包
desc dbms_output

包相当于一个命名空间 
会把相关的函数 以及过程  变量  等 封装到一起


常见的系统包(代码库API)
    dbms_output

    dbms_random
    select dbms_random.value(0,2) from dual; 
    取得随机整数
    select trunc(dbms_random.value(0,10)) from dual;

    dbms_job  定时任务包
    可以定时执行 存储过程
    Java的定时任务使用 java.util.concurrent.Executors 类可以实现。

    dbms_job.submit(jobno,'test();',
      sysdate,'sysdate+1/24')

    jobno       定时执行的任务编号
                它是一个输出参数 
		
    test();     要定时执行的存储过程
    sysdate     第一次执行程序的时间
    'sysdate+1/24' 下一次执行程序的时间
                 并且第四个参数和第三个参数的
		 差就是执行周期

    dbms_job.run(jobno);  //运行这个任务

  
   create  table  testjob(
       id  number ,
       name varchar2(30)
   );

   create sequence  testjob_seq;

   insert into testjob values(testjob_seq.nextval,'test');

   写一个存储过程 向表中表中插入一条数据
   要求name的值是固定的test  id的值采用序列值
   create or replace procedure insert_job
   is
   begin
       insert into testjob values(testjob_seq.nextval,'test'||testjob_seq.currval);
       commit;
   end;

   /*使用job包调用上面的存储过程*/

   declare
       jobno  binary_integer;
   begin
       dbms_job.submit(jobno,'insert_job();',
       sysdate,'sysdate+1/(24*60)');
       dbms_job.run(jobno);
       dbms_output.put_line(jobno);
   end;

   取消任务1
   begin
       dbms_job.remove(1);
   end;
   
 ---------------------------
 自定义包
  
 包头   header
     create  or replace package mypack 
     is 
         procedure helln(var_n  number);
	 function  getmin(var_x number,var_y number) 
	 return number;
	 var_i   number;
     end  mypack;

 包体
    create or replace package body mypack 
     is 
         procedure helln(var_n  number) is
	 begin
             for  a in 1..var_n loop
                 dbms_output.put_line('hello');
	     end loop;
	 end;
	 function  getmin(var_x number,var_y number) 
	 return number is
	 begin
             if var_x<var_y then
	        return var_x;
             end if;
	        return var_y;  
	 end;
	
     end  mypack;

写一些初始化的代码
create  or replace  package body mypack 
     is 
         procedure helln(var_n  number) is
	 begin
             for  a in 1..var_n loop
                 dbms_output.put_line('hello');
	     end loop;
	 end;
	 function  getmin(var_x number,var_y number) 
	 return number is
	 begin
             if var_x<var_y then
	        return var_x;
             end if;
	        return var_y;  
	 end;
     begin
         var_i:=10000;
     end  mypack;

怎么来调用包中的过程和函数 以及变量
要加包名
begin
    mypack.helln(10);
    dbms_output.put_line(mypack.var_i);
end;

-------------------------------
触发器
    dml 的触发器
       insert  update  delete 
      
       before
       after   正常情况下 这两种没区别
               但非正常情况下不同

       for each  row
               没有这个限制时  是dml语句
	       无论影响多少行数据 触发器都
	       触发一次
	       但有for each row  则影响多少
	       行触发多少次
    
dml   12种基础触发器

create  or  replace trigger  emptrigger
before  update   on s_emp  
declare
begin
    dbms_output.put_line('update s_emp');
end;

create  or  replace trigger  emptrigger
before  update   on s_emp  for each row
declare
begin
    dbms_output.put_line('update s_emp');
end;
    
create table test100 as select * from test;
create table test100 as select * from test 
where 1=2;

触发器中有很多限制
不能有任何的事务控制语句？
dml  ------事务特性的

delete  ------触发器 commit  rollback

rollback;

一般  事务谁发起 谁结束

数据库阶段作业：设计网上商城的数据库。
  商品信息 - 商品编号、商品名称、商品价格、供货商
  create table product(
    pro_id number(10) constraint product_pk primary key,
    pro_name varchar2(30) not null,
    pro_price number(10,2),
    pro_provider varchar2(50)
  );
  用户信息 - 用户编号、用户名、密码、收货地址、电话
  create table users(
    user_id number(10) constraint users_pk primary key,
    user_name varchar2(30) not null,
    passwd varchar2(30),
    address varchar2(100),
    mobile varchar2(20) unique
  );
  订单信息 - 订单编号、订单日期、商品编号、商品数量、金额、用户ID。
  create table orders(
    order_id number(10) primary key,
    order_date date,
    order_sum number(10,2),
    user_id number(10), -- 外键关联字段，关联用户表
    constraint orders_user_fk foreign key (user_id) references users (user_id)
     on delete set null
  );
  create table orders_item(
    item_id number(10) primary key,
    pro_id number(10),  -- 外键关联字段，关联product表
    pro_num number(5),
    order_id number(10), -- 外键关联字段，关联orders表
    ....
  );
 需要建立序列提供主键值。
  create sequence seq_orders;
  create sequence seq_item;
  create sequence seq_users;
  create sequence seq_product;
  insert into orders values(seq_orders.nextval,sysdate,计算结果,1);
  insert into orders_item values
   (seq_item.nextval,1,20,seq_orders.currval);
  commit;
 要求：1 使用序列提供主键。
       2 每个表插入一些测试数据。
       3 实现以下查询：
         3.1 显示订单的详细信息(订单编号/总金额/商品名称/商品数量/用户名/用户地址/电话)
         3.2 显示今天下午2点到3点之间的订单信息(订单编号、订单日期、商品编号、商品数量、金额、用户ID)
         3.3 分页显示商品信息。

  JAVA和数据库
   Java访问数据库的技术  -- JDBC，是一套的接口，具体实现由 数据库厂商完成。
   Java程序员操作数据库的方式：
    JDBC - Java 数据库 连接技术(轻量级的连接，是框架的基础操作)
    O/R Mapping  - 对象关系映射技术，用对象直接操作数据库。
                 框架就是代码集，作用提升开发效率，降低开发的难度。
                 EJB - 重量级的，现在很少使用了
                 Hibernate - 后面讲
                 Mybatis   - 后面讲
   Java提供了 java.sql 包 和 javax.sql 包，用于操作数据库。对数据库的增删改查。
   
   JDBC编程类库：
   DriverManager - 数据库驱动的管理程序，也是JDBC的入口。
 核心方法：
 static Connection getConnection(String url,String user,String password) 
  其中，url是连接字符串，user是用户名，passwd是密码。
  url格式：
    jdbc:oracle:thin:@localhost:1521:SID
   其中，SID是service Id，安装数据库时填写。
  SID如何查看：
   首先以system用户登录，然后在SQLPLUS中，敲 show parameter service 
  
  Connection - 数据库连接 接口
  核心方法：
   close() - 关闭连接
   commit()/rollback() - 提交事务/回滚事务
   setAutoCommit(boolean autoCommit)  -  设置是否自动提交，默认自动提交
   Statement createStatement() - 创建一个Statement对象，用于执行sql语句。
   PreparedStatement prepareStatement(String sql) - 创建PreparedStatement对象，执行sql语句(更靠谱)。
   CallableStatement prepareCall(String sql) - 调用存储过程

  Statement - 执行SQL语句的平台
   close() - 关闭Statement
   ResultSet executeQuery(String sql)  - 执行查询语句，返回结果集。
   int executeUpdate(String sql) - 执行DML语句，返回操作的行数。

  ResultSet - 查询结果集
   close() - 关闭结果集
   ResultSetMetaData getMetaData() - 返回结果集的元数据，包括：字段信息。
   各种类型的get方法 - 有两种参数，第一个字段名，第二个就是序号，可以取记录的字段的值。
   boolean next() - 将游标从当前位置向下移一行，并返回是否有数据。作循环条件

  技巧：如果sql语句中需要拼接变量，在两个单引号中敲2个双引号，在2个双引号中敲两个+号，在中间写上变量名即可。(数值类型不需要单引号)

   写JDBC之前，先要导入数据库官方的驱动库，Oracle使用OJDBC6.jar 。



