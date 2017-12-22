1. 	drop table emp_zlm;
	create table emp_zlm(
		id number(7),
		name varchar2(20),
		sal number(10,2),
		deptno number(7),
		mobile varchar2(20),
		birthday date
	);
	drop table dept_zlm;
	create table dept_zlm(
		id number(7),
		name varchar2(20)
	);
2.	insert into dept_zlm values(1,’sales’);
	insert into dept_zlm values(2,’teacher’);
	insert into emp_zlm values(1,’zhangfei’,1200.0,1,136000000,to_date(‘1980-01-01’,’yyyy-MM-dd’));
	insert into emp_zlm values(2,’guanyu’,1600.0,1,183000000,to_date(‘1900-01-01’,’yyyy-MM-dd’));
	commit;
3.	select e.name,e.sal,d.name from emp_zlm e join dept_zlm d on (e.deptno = d.id);
	select deptno,avg(sal) from emp_zlm group by deptno having avg(sal)>2000;
	select id,name,sal,birthday from emp_zlm e where （to_char(sysdate,’yyyy’) - to_char(birthday,’yyyy’)） > 25;
	select (to_char(birthday,’yyyy’) + 25) || to_char(birthday,’-mm-dd’) from emp_zlm;

一、事务处理
1.1 事务的自动提交：
	1.执行了 DDL 语句，自动 commit。create（创建）、drop（删除表）、alter、truncate（删除表所有数据）
	2.正常退出的 sqlplus，会自动提交。（exit）
1.2 事物的自动回滚：
	1.非正常的退出 sqlpus。

二、建表（正式版）
1.建表的完整语法：
	create table 表名(
		字段名1 字段类型 default 值 字段级约束，
		……
		表级约束1，
		……
	);
	其中，default 值可以省略不写，写了效果就是默认值不再是 null，而是指定的值。约束也可以不写，但正规的建表都是带约束的。约束就是对表中的数据进行限制，从而让数据更有效。

	Oracle 的字段类型：
		常见的就是数值型、文本型、日期型；
		除了这三种之外，还包括很多其他的特殊类型，比如：图片、大字段类型 CLOB/BLOB（最大能达到4G）等。

三、 约束
	3.1 数据库的常见约束包括5种：
		1.非空约束   not null  — 该字段不能为null；
		2.唯一约束  unique   — 该字段的值不能重复，但可以为 null；
		3.主键约束  primary key  — 是数据的唯一标识，效果等同于 非空+唯一
		4.外键约束  foreign key   — 体现表和表之间的一对多的关系
		5.检查约束  check  — 可以检查任意的条件，可以跟条件的表达式

	3.2 主键约束最重要，绝大数的表都有主键约束。其次是非空约束和外键约束，唯一约束也常用，check 约束很少用。
	约束可以保证数据的有效性，但也会影响部分性能。因此约束要适度使用。
		drop table student;
		create table student(
			id number(7),
			name varchar2(20) not null,  — 非空约束
			mobile varchar2(20) constraint stu_uni unique  — 唯一约束 constraint 约束名
		);
		insert into student values(1,’zhangfei’,’123’);
		insert into student values(2,’guanyu’,’123’);
		insert into student values(3,null,’120’);
		commit;

	3.3 主键约束 不能随便使用，只有唯一标识的字段才能使用主键约束。特殊情况下，主键可以死多个字段一起，叫联合主键，当很少使用。
		drop table student;
		create table student(
			id number(7) constraint stu_pk primary key,
			name varchar2(20) not null,  — 非空约束
			mobile varchar2(20) constraint stu_uni unique  — 唯一约束 constraint 约束名
		);
		insert into student values(1,’zhangfei’,’123’);
		insert into student values(2,’guanyu’,’123’);
		insert into student values(3,null,’120’);
		commit;

	3.4 外键约束
		两个表之间是一对多关系时，比如：员工和部门，员工表需要记录部门信息，一般都是编号做关联字段，这个部门编号（关联字段）的值应该是：空或者来自于部门表，绝对不能是部门表中没有的值。外键约束就是解决这个问题的。当子表（多的一方，比如员工）中使用了外键约束时，可以保证关联字段的值只能是空或者来自于父表（一的一方，比如部门）。
		外键的使用方式：
			建议外键都是用表级约束的写法。字段级约束就是约束写在字段的后面，表级约束就是约束和字段平级写，写在表中。除了非空约束只有字段级写法，其他约束都是两种写法都支持。在运行时没有区别。
			一对多关系的两张表，父表不需要额外做任何其他事。子表先要加一个关联字段，一般都是关联父表的主键字段；然后在关联字段上加上外键约束，将 父表的主键和子表的关联字段 对应起来。
		表级外键约束的语法：
			constraint 约束名 foreign key（子表的关联字段） references 父表（主键字段）
				on delete cascade  或者  on delete set null
				on delete 可以不写，当删除父表数据时，会有问题；
				on delete cascade 级联删除，就是删除父表数据之前，自动删除子表相关数据；
				on delete set null 置空，就是删除父表数据之前，子表的相关数据的关联字段置为空；

		drop table student;
		create table class(
			id number(7) constraint cla_pk primary key,
			name varchar2(20) not null
		);
		create table student(
			id number(7) constraint stu_pk primary key,
			name varchar2(20) not null,  — 非空约束
			mobile varchar2(20)  unique，  — 唯一约束 constraint 约束名
			deptno number(7),
			constraint stu_cla_fk foreign key (deptno) references class(id)
		);

		insert into class values(1,’Java16’);
		insert into class values(2,’Java17’);
		insert into class values(3,’PHP195’);
		insert into student values(1,’zhangfei’,’123’,1);
		insert into student values(2,’guanyu’,’120’,null);
		insert into student values(3,’liubei’,’124’,4);   —— 违反了约束
		commit;

























