一、分页
OracleSQL的 top n 问题和分页的解决方案：rownum
1. rownum 是 Oracle 数据库提供的解决方案，但很别扭；
	查询工资前五的员工信息：
		select empno,ename,sal from emp order by sal desc;
		select empno,ename,sal from emp where rownum<6 order by sal desc;  — 先 where 后排序，结果与预期不符
		select * from (select empno,ename,sal from emp order by sal desc) where rownum<6;
	查询工资6-10的员工信息：
		select * from (select empno,ename,sal from emp order by sal desc) where rownum between 6 and 10; — 没有结果，但有数据
		select * from (select empno,ename,sal from emp order by sal desc) where rownum>5; — 没有结果

2.rownum 很特殊，只有小于（小于等于）可以用，等于或者大于都查不出数据。分页问题，Oracle 需要用别名的特殊写法。
		select * from (
			select rownum row_num,empno,ename,sal from 
				（select empno,ename,sal from emp order by sal desc) 
			) where row_num between 6 and 10; 

二、PL/SQL  — 不同的数据库都是不一样的，没有通用性
	PL/SQL 是数据库的开发，是数据库的程序。
	软件的结构：
		客户端  => 应用服务器  =>  数据库服务器
	PL/SQL 主要是数据库服务器的开发
		Pl/SQL 的重点：游标、存储过程、函数
	常见的访问数据库的技术：
		PL/SQL              过程化的 sql
		proc/c++            用 c 或者 c++语言访问Oracle
		ODBC/ADO        VC 访问数据库的技术
		OCI                   Oracle 底层的连接接口
		SQLJ/JDBC       Java 语言访问数据库
		O/R Mapping     对象和关系映射技术，用面向对象的方式去操作关系型数据库
						Hibernate 和 Mybatis 框架都是 O/R Mapping 的实现

2.1 PL/SQL 的内容：
	变量  类型（sql 的类型均包含）
	和控制语句   循环语句  其他的对象以及函数
2.2 PL/SQL 程序的组成：
	declare       
		— 声明区
	begin         
		— 执行区
	exception   
		— 异常处理函数
	end；
	示例：
		begin
			dbms_out.put_line("hello!");
		end；
	输出默认是关闭的，需要打开才能看到输出。打开方式：set serveroutput on

	初始化 赋值是通过  :=   来表达的
	declare
		var_i  number;
		/*初始化*/
		var_j number := 100;
	begin
		/*赋值*/
		var_i :=1;
		dbms_output.put_line(var_i || ':' || var_j);
	ends;

	constant 定义常量
	not  null  就是表达不能为空 
	当一个变量定义之后 如果没有赋初值则变量的值是null
三、变量的类型
1.标量类型
	数字   		binary_integer  number
	字符串 		char(n)  varchar2(n)
  	布尔   		boolean ---- true  false  null 
  	日期   		date

2.组合类型
	record(记录)   table(表)   cursor(游标)

3.引用类型
	ref cursor （参考类型）
4.大类型
	blob
	clob 
	bfile 
	-----------------------------------------------
	在申明区定义两个变量  
		id   
		name

	把emp 表中的id为1的empno,ename
	数据查询出来放入变量中
	然后输出

	declare
    		id    number;
    		name  varchar2(10); 
	begin
    		select empno,ename into id,name -- into 就是把结果放入变量中
    		from emp where empno=7369;
    		dbms_output.put_line(id||':'||name);
	end;
=================================================================================
	PL/SQL 中用来取表中字段类型的语法
	%type 代表 的类型

	declare
    		id    emp.empno%type;
    		name  emp.ename%type; 
	begin
    		select empno,ename into id,name from emp where empno=7369;
    		dbms_output.put_line(id||':'||name);
	end;

=================================================================================

	把emp 表中empno为7369的empno  ename sal
	查询出来放入一个类型的变量中

	结构体类型  -------  record 类型
	在申明区中定义一个类似于结构体类型(类)的类型

	declare 
   		 /*定义一个记录类型 叫emprectype*/
    		TYPE  emprectype  IS RECORD(
        		id     emp.empno%type,
			name   emp.ename%type,
			salary emp.sal%type
   	 	);
    		/*用上面的类型定义一个变量*/
    		var_emp   emprectype;
	begin
    		select empno,ename,sal  into var_emp -- 次序不可混乱
    			from emp where empno=7369;
    		dbms_output.put_line(var_emp.id||':'||
    		var_emp.name||':'||var_emp.salary);
	end;

=================================================================================
	
	declare 
    		/*定义一个记录类型 叫emprectype*/
    		TYPE  emprectype  IS RECORD(
        		id     emp.empno%type,
			name   emp.ename%type,
			salary emp.sal%type
   		 );
    		/*用上面的类型定义一个变量*/
    		var_emp   emprectype;
	begin
    		select empno,ename  into var_emp.id,var_emp.name from emp where empno=7369;
    		dbms_output.put_line(var_emp.id||':'||
    		var_emp.name||':'||var_emp.salary);
	end;
	备注:如果查询的字段 少于记录类型的字段 
	则可以把记录类型的字段取出来单独赋值
	不赋值的字段就是null值.

=================================================================================

	记录类型的整体赋值
	declare  
    		/*定义一个记录类型 叫emprectype*/
    		TYPE  emprectype  IS RECORD(
        		id     emp.empno%type,
			name   emp.ename%type,
			salary emp.sal%type
    		);
    		/*用上面的类型定义一个变量*/
    		var_emp    emprectype;
    		var_emp2   emprectype;
	begin
    		select empno,ename,sal  into var_emp2 from emp where empno=7369;
   		var_emp:=var_emp2;
    		dbms_output.put_line(var_emp.id||':'||
    		var_emp.name||':'||var_emp.salary);
	end;

	除了整体赋值之外 也支持单个字段的赋值
	declare  
    		/*定义一个记录类型 叫emprectype*/
    		TYPE  emprectype  IS RECORD(
        		id     emp.empno%type,
			name   emp.ename%type,
			salary emp.sal%type
    		);
    		/*用上面的类型定义一个变量*/
    		var_emp    emprectype;
    		var_emp2   emprectype;
	begin
    		select empno,ename,sal  into var_emp2 from emp where empno=7369;
    		var_emp.id:=var_emp2.id;
    		var_emp.name:=var_emp2.name;
    		dbms_output.put_line(var_emp.id||':'||
    		var_emp.name||':'||var_emp.salary);
	end;

=================================================================================

	如果把emp 表中empno为1的所有数据  都放入一个记录类型定义的变量中?
 	%rowtype 取得一个表的一行对应的类型

		emp%rowtype   dept%rowtype

	一个表中的所有字段对应的一个记录类型
	字段排放顺序 和desc 表名得到的顺序相同并且字段名和record的成员名也一致。

	declare
   		/*用记录类型定义变量*/
   		var_emp  emp%rowtype;
	begin
   		select * into var_emp  from emp where empno=7369;
   		dbms_output.put_line(var_emp.empno|| ':' ||var_emp.ename);
	end;

	%rowtype 就是全字段的记录类型  除了语法上和记录类型有差别之外，定义完变量后的操作和记录类型完全相同。
	如:
		declare
   			/*用记录类型定义变量*/
   			var_emp   emp%rowtype;
		begin
   			select empno,ename,sal  into var_emp.empno,var_emp.ename,var_emp.sal from emp where empno=7369;
   			dbms_output.put_line(var_emp.empno || ':' || var_emp.ename);
		end;

=================================================================================

	表   table 可以放多行记录
	--------和Java中的数组/Map很相似

	table类型的数据
	如何定义table类型
	怎么使用类型定义变量
	怎么操作table类型的变量

	table像数组，但下标没有任何的限制，随便用，不连续，也可以为负数，没有定义过的下标直接报错。

	declare
    		/*定义一个table类型 放整数类型*/
    		TYPE  tablenumbertype  IS TABLE  OF emp.empno%type index by  binary_integer;
    		/*定义一个table 类型的变量*/
    		var_nums  tablenumbertype;
	begin
    		var_nums(0):=100;
    		var_nums(3):=200;
    		var_nums(4):=400;
    		dbms_output.put_line('var_nums(4):' || var_nums(4));
	end;
	/*把这个table类型的变量中所包含的所有数据输出*/

	declare
    		/*定义一个table类型 放整数类型*/
    		TYPE  tablenumbertype  IS TABLE   OF s_emp.id%type index by  binary_integer;
    		/*定义一个table 类型的变量*/
    		var_nums  tablenumbertype;
	begin
    		var_nums(0):=100;
    		var_nums(3):=200;
    		var_nums(4):=400;
    		dbms_output.put_line('var_nums(2):'  || var_nums(2));
	end;

	访问没有赋值的下标
	ERROR at line 1:
	ORA-01403: no data fou
	ORA-06512: at line 11

=================================================================================

	迭代器思想
		table 类型提供的函数
		first() 得到table类型的第一个元素对应的下标 
		next(下标)  得到一个下标的下一个元素的下标 
		last()  得到最后一个元素对应的下标

	declare
   		/*定义一个table类型 放整数类型*/
    		TYPE  tablenumbertype  IS TABLE   OF emp.empno%type index by binary_integer;
    		/*定义一个table 类型的变量*/
    		var_nums  tablenumbertype;
    		/*定义一个元素下标变量*/
    		var_ind   binary_integer;
	begin
    		var_nums(0):=100;
    		var_nums(3):=200;
    		var_nums(-4):=400; --  按下标排序，不按先后次序。
    		var_ind:=var_nums.first();
    		dbms_output.put_line(var_nums(var_ind)||':'||var_ind); -- 100
    		var_ind:=var_nums.next(var_ind); 
    		dbms_output.put_line(var_nums(var_ind)||':'||var_ind);-- 200
    		var_ind:=var_nums.next(var_ind); 
    		dbms_output.put_line(var_nums(var_ind)||':'||var_ind);-- 400
    		dbms_output.put_line(var_nums(var_nums.last()));
	end;

=================================================================================

	把 empno 是7369，7900，7902的所有员工信息  放入一个table类型的变量中

	使用迭代器思想 输出这些数据的 id  first_name salary 

	declare
    		/*定义一个table类型 放整数类型*/
    		TYPE  tablenumbertype  IS TABLE   OF emp%rowtype index by  binary_integer;    
    		var_nums  tablenumbertype; /*定义一个table 类型的变量*/
    		var_ind   binary_integer;  /*定义一个元素下标变量*/
	begin
    		select *  into var_nums(0) from emp where empno=7369;
    		select *  into var_nums(1) from emp where empno=7900;
    		select *  into var_nums(2) from emp where empno=7902;
    		var_ind:=var_nums.first();
    		dbms_output.put_line(var_nums(var_ind).empno || ',' || var_nums(var_ind).ename || ',' || var_nums(var_ind).sal);
    		var_ind:=var_nums.next(var_ind);
    		dbms_output.put_line(var_nums(var_ind).empno || ',' || var_nums(var_ind).ename || ',' || var_nums(var_ind).sal);
    		var_ind:=var_nums.next(var_ind);
    		dbms_output.put_line(var_nums(var_ind).empno || ',' || var_nums(var_ind).ename || ',' || var_nums(var_ind).sal);
	end;

=================================================================================

	变量的作用域和可见性 
 	PL/SQL块的嵌套

 	declare
     		var_i   number:=1;
 	begin
      		declare
          		var_j   number:=10;
      		begin
          		/*可不可以访问到全局的var_i*/
      			exception 
 
      		end;
      		/*不能访问var_j*/
 		exception 
 	end;

 	declare
     		var_i   number:=1;
 	begin
      		declare
          		var_i   number:=10;
      		begin
          		/*访问的是局部的*/
          		dbms_output.put_line(var_i);  
 		end;
	end;

	<<abc>>
 	declare
     		var_i   number:=1;
 		begin
      			declare
          			var_i   number:=10;
      			begin
          			/*访问的是局部的*/
          			dbms_output.put_line(var_i);  
          			dbms_output.put_line(abc.var_i);  
     			 end;
      
 		end;

=================================================================================

	控制语句、条件语句

	if   表达式   then
    		满足条件
	elsif  表达式 then
    
	elsif  表达式 then

	else

	end if;

	if   表达式   then
    		满足条件
	end if;


	if   表达式   then
    		满足条件
	else
    		其它情况
	end if;

	if   表达式   then
    		满足条件
	elsif  表达式 then

	elsif  表达式 then
	end if;

	针对于boolean  类型 NULL 相当于false
	判断NULL的运算特点
	定义两个变量  不赋值
	var_x   var_y
	如果var_x>var_y  
   	就输出  'var_x>var_y'
	var_x  is var_y   //error
	var_x  is null  and  var_y  is null

	declare
    		var_x   number:=5;
    		var_y   number;
	begin
    		if  var_x>var_y then
			dbms_output.put_line('var_x>var_y');
    		elsif var_x<var_y then
        		dbms_output.put_line('var_x<var_y');
    		elsif var_x=var_y then
        		dbms_output.put_line('var_x=var_y'); 
    		elsif var_x is null and var_y is null then
        		dbms_output.put_line('var_x is null var_y is null');
    		else
        		dbms_output.put_line('var_x other var_y'); 
    		end if;
	end; 

=================================================================================

循环语句
1.简单循环 
  	输出1到10   
  	declare
  			var_i   number:=1;
  		begin
      		dbms_output.put_line(var_i);
      		var_i:=var_i+1;
  	end;

/*死循环  无限循环 不要执行*/
  	declare
  			var_i   number:=1;
  	begin
  			loop
     			dbms_output.put_line(var_i);
     			var_i:=var_i+1;
  			end loop;
  	end; 

/*循环的退出*/
	exit   when   退出条件;
	等价于
	if   退出条件  then
    		exit;
	end if;

  	declare
  			var_i   number:=1;
  	begin
  			loop
     			exit when var_i=11;
     			dbms_output.put_line(var_i);
     			var_i:=var_i+1;
  			end loop;
  	end; 

  	declare
  			var_i   number:=1;
  	begin
  			loop
     			if var_i=11  then exit;
     			end if;
     			dbms_output.put_line(var_i);
     			var_i:=var_i+1;
  			end loop;
  	end; 

=================================================================================

while 循环 

	while  条件  loop

	end  loop;

	满足条件就进入循环

	输出1到10 

	declare
    		var_i   number:=1;
	begin
    		while var_i<11 loop
        		dbms_output.put_line(var_i);
			var_i:=var_i+1;
    		end loop;
	end;

	declare
    		var_i   number:=1;
	begin
    		while var_i<11   loop
        		/*循环体中满足循环退出*/       
        		dbms_output.put_line(var_i);
			var_i:=var_i+1;
        		exit  when  var_i=6;
    		end loop;
	end;

=================================================================================

for 循环   
