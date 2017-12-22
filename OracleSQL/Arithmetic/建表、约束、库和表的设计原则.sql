练习：
1. 	创建员工信息表和部门表
	drop table emp_zlm;
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

2.	分别在两张表中插入数据
	insert into dept_zlm values(1,’sales’);
	insert into dept_zlm values(2,’teacher’);
	insert into emp_zlm values(1,’zhangfei’,1200.0,1,136000000,to_date(‘1980-01-01’,’yyyy-MM-dd’));
	insert into emp_zlm values(2,’guanyu’,1600.0,1,183000000,to_date(‘1900-01-01’,’yyyy-MM-dd’));
	commit;

3.	查询
	select e.name,e.sal,d.name from emp_zlm e join dept_zlm d on (e.deptno = d.id);
	select deptno,avg(sal) from emp_zlm group by deptno having avg(sal)>2000;
	select id,name,sal,birthday from emp_zlm e where （to_char(sysdate,’yyyy’) - to_char(birthday,’yyyy’)） > 25;
	select (to_char(birthday,’yyyy’) + 25) || to_char(birthday,’-mm-dd’) from emp_zlm;

一、事务处理
1. 事务的自动提交：
	1.执行了 DDL 语句，自动 commit。create（创建）、drop（删除表）、alter、truncate（删除表所有数据）
	2.正常退出的 sqlplus，会自动提交。（exit）
2. 事物的自动回滚：
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
1.  数据库的常见约束包括5种：
	1.非空约束   not null  — 该字段不能为null；
	2.唯一约束  unique   — 该字段的值不能重复，但可以为 null；
	3.主键约束  primary key  — 是数据的唯一标识，效果等同于 非空+唯一
	4.外键约束  foreign key   — 体现表和表之间的一对多的关系
	5.检查约束  check  — 可以检查任意的条件，可以跟条件的表达式

2. 主键约束最重要，绝大数的表都有主键约束。其次是非空约束和外键约束，唯一约束也常用，check 约束很少用。
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

3. 主键约束 不能随便使用，只有唯一标识的字段才能使用主键约束。特殊情况下，主键可以死多个字段一起，叫联合主键，当很少使用。
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

4. 外键约束
	两个表之间是一对多关系时，比如：员工和部门，员工表需要记录部门信息，一般都是编号做关联字段，这个部门编号（关联字段）的值应该是：空或者来自于部门表，绝对不能是部门表中没有的值。外键约束就是解决这个问题的。当子表（多的一方，比如员工）中使用了外键约束时，可以保证关联字段的值只能是空或者来自于父表（一的一方，比如部门）。

4.1 外键的使用方式：
	建议外键都是用表级约束的写法。字段级约束就是约束写在字段的后面，表级约束就是约束和字段平级写，写在表中。除了非空约束只有字段级写法，其他约束都是两种写法都支持。在运行时没有区别。
	一对多关系的两张表，父表不需要额外做任何其他事。子表先要加一个关联字段，一般都是关联父表的主键字段；然后在关联字段上加上外键约束，将 父表的主键和子表的关联字段 对应起来。

4.2 表级外键约束的语法：
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

	delete  from class where id = 1;  —— 违反约束，如果仅仅删除父表数据，子表的数据没有关联

4.3 序列
	Oracle 用序列解决主键的值 Sequence
	序列和表一样，都是 Oracle 数据库的对象（表、序列、视图、索引、同义词）。同一用户下，所有 Oracle 的对象不能重名。
	序列与表平级，没有从属关系，只是为表提供主键的值。
	序列的创建：
		create sequence 序列名 start with 初始值；
		create sequence seq_student start with 1；（初始值为 1 可以省略，默认从 1 开始）
	
	1. 序列的用法：
		序列名.nextval  — 下一个值，就是自增以后的值
		序列名.currval   — 当前的值，没有自增（初次使用时，必须向 nextval）
		select seq_student.nextval from dual;
		select seq_student.currval from dual;

		insert into student values(seq_student.nextval,’zhangfei’,’110’,1); 
		insert into student values(seq_student.nextval,’guanyu’,’111’,1); 
		insert into student values(seq_student.nextval,’liubei’,’112’,1); 
		commit;

		序列在使用时是连续递增的，但在数据库中的数据并不能保证连续。
		一般来说，序列只为一张表提供主键的值，因此，有主键的表必须建一个序列。
		删除序列使用 drop sequence 序列化名。
		关于修改的命令 alter，需要用的时候百度就行。

4.4 视图（View）
	create or replace 新建或者替换
	视图就是一个结果集，用查询生成的一个结果集。视图不存储数据，数据只能存在表中。视图是数据的一种展现方式，主要作用就是简化 sql 语句。视图的查询和表的查询基本相同。

4.5 索引（Index）
	索引是用于提升查询效率的工具。
	针对常用的查询字段可以加索引提升查询效率。索引可以提升查询效率，但会降低增删的效率。一般来说，加索引都是 DBA 或者项目经理去做。

五、数据库的设计
	数据库设计的原则叫数据库的设计范式，共有五个，一般遵循到范式3即可。
	范式1：字段不要有重复的。
	范式2：所有的字段都要依赖于主属性字段（主键字段）。
	范式3：不能有更依赖于其他非主属性字段的存在。

	案例：
		有以下的数据，需要设计数据库：
			员工编号、员工年龄、员工电话、员工姓名、工资、部门编号、部门名称、部门所在、员工电脑型号、员工出生日期
		范式1：不能有重复  年龄和出生日期信息是重复的。去掉年龄。
			员工编号、员工电话、员工姓名、工资、部门编号、部门名称、部门所在、员工电脑型号、员工出生日期
		范式2：所有的字段都要依赖于主属性字段（主键字段）  员工电脑型号没有关联性
			员工编号、员工电话、员工姓名、工资、部门编号、部门名称、部门所在、员工出生日期
		范式3：不能有更依赖于其它非主属性字段的存在。   部门编号、部门名称、部门的所在更有依赖关系，单独做表。拆分成两个表。
			emp 表 ：员工编号、员工电话、员工姓名、工资、员工出生日期、部门编号（关联字段）
			dept 表： 部门编号、部门名称、部门所在

六、表间关系的设计
	表间关系包括：一对一关系、一对多关系，多对多关系。
	一对一关系就是两个表互相都是一对一；
	一对多关系就是两个表一边是一对一，一边是一对多；
	多对多关系就是两个表都是一对多；

	一对一关系可以采用相同主键法，两个表如果使用相同的主键，直接并表；
	一对多关系可以采用主外键关联的方式，参考外键的设定。
	多对多关系可以采用第三张表做关联表，关联表中没有主键，只有两个字段分别关联两个表的主键。
	drop table student;
	create table student(
		id number(7) constraint stu_pk primary key,
		name varchar2(20) not null,
		birthday date
	);
	drop table lesson;
	create table lesson(
		id number(7) constraint less_pk primary key,
		name varchar2(20) not null
	);
	drop table stu_les_relation;
	create table stu_les_relation(    — 关系都在这张表中
		s_id number(7),
		l_id number(7),
		constraint stu_rel_fk foreign key (s_id) references student(id) on delete cascade,
		constraint les_rel_fk foreign key (l_id) references lesson(id) on delete cascade
	);
	insert into student values(1,’zhangfei’,null);
	insert into student values(2,’guanyu’,null);
	insert into student values(3,’liubei’,null);
	insert into lesson values(1,’qima’);
	insert into lesson values(2,’shejian’);
	insert into lesson values(3,’changqiang’);
	commit;
	insert into stu_les_relation values(1,1);
	insert into stu_les_relation values(1,3);
	insert into stu_les_relation values(2,1);
	insert into stu_les_relation values(3,2);
	commit;
	select s.id,s.name,l.id,l.name from student s join stu_les_relation r on (s.id = r.s_id) join lesson 1 on (l.id = r.l_id);
	
