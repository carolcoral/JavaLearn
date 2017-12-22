select e.empno,e.ename,e.sal,d.dname from emp e,dept d where e.deptno = d.deptno;

select e.empno,e.ename,e.sal,d.dname from emp e 
  join dept d on (e.deptno = d.deptno);    -- Oracle9开始，新的写法更高效，推荐使用

select e.empno,e.ename,e.sal,d.dname from emp e cross join dept d; -- 笛卡尔积

查询员工信息(编号/姓名/薪水/薪水等级) 

 select e.empno,e.ename,e.sal,s.grade from emp e,salgrade s 
  where e.sal between s.losal and s.hisal;   

 多表连接包括四种：
  1 等值连接，就是 用等号做连接条件的。绝大多数的多表连接都是等值连接。
  2 非等值连接，就是 不用等号做连接条件的。小部分多表连接使用非等值连接。
  3 外连接，就是 把匹配的数据和不匹配的数据都显示出来。
  4 自连接，就是 用别名把一张表当成两/多张表进行连接。

 练习：
   1 使用join on 写法实现查询薪水等级的sql。
   2 三表连接，要求写两种SQL语句。
    查询员工信息(员工姓名、薪水、部门名称、薪水等级)
 select e.empno,e.ename,e.sal,s.grade from emp e join salgrade s 
  on (e.sal between s.losal and s.hisal);   

 select e.ename,e.sal,d.dname,s.grade from emp e,dept d,salgrade s 
  where e.deptno=d.deptno and e.sal between s.losal and s.hisal;

 select e.ename,e.sal,d.dname,s.grade from emp e 
  join dept d on (e.deptno=d.deptno)
  join salgrade s on (e.sal between s.losal and s.hisal);

 外连接
 select e.empno,e.ename,e.sal,d.deptno,d.dname from emp e,dept d 
   where e.deptno = d.deptno;   -- 只有匹配成功的数据，没有匹配的数据无法显示
 select * from dept;
 如果想让匹配和和没有匹配到的都显示，只能使用外连接。
 (+) 就可以实现外连接。
 select e.empno,e.ename,e.sal,d.deptno,d.dname from emp e,dept d 
   where e.deptno(+) = d.deptno;  -- 没有(+)的一端表 中可以显示未匹配的数据

 insert into emp(empno,ename,sal) values (9999,'zhangfei',2500); -- 插入新数据
 commit;
 
 select e.empno,e.ename,e.sal,d.deptno,d.dname from emp e,dept d 
   where e.deptno = d.deptno(+);
 select e.empno,e.ename,e.sal,d.deptno,d.dname from emp e,dept d 
   where e.deptno(+) = d.deptno(+);  --  错，老写法不支持 全外连接
 
 select e.empno,e.ename,e.sal,d.deptno,d.dname from emp e 
   left outer join dept d on (e.deptno = d.deptno);  -- 左外连接
 select e.empno,e.ename,e.sal,d.deptno,d.dname from emp e 
   right outer join dept d on (e.deptno = d.deptno); -- 右外连接
 select e.empno,e.ename,e.sal,d.deptno,d.dname from emp e 
   full outer join dept d on (e.deptno = d.deptno);  -- 全外连接

  自连接 
 select empno,ename,sal,mgr from emp ;  -- 可以查询管理者，但编号很不直观
 查询员工信息(编号/姓名/工资/管理者姓名) 
 select e.empno,e.ename,e.sal,m.ename manager from emp e,emp m 
  where e.mgr = m.empno;    -- 两个表，员工表e 和 管理者表 m
 select e.empno,e.ename,e.sal,m.ename manager from emp e,emp m 
  where e.mgr = m.empno(+);

 自连接必须在数据库设计时就预留了相关字段，才能使用。

 union  合并两个结果集 然后排重(去掉重复)。 
 select empno,deptno from emp where deptno = 20  union 
 select empno,deptno from emp where deptno != 30;

 分组函数(多行函数)
  常见的分组函数有5个： 
   count()  -- 统计总记录数
   sum()    -- 求和，只能用于数值类型
   avg()    -- 求平均值，只能用于数值类型
   max()    -- 最大值，可以用于数值/文本/日期
   min()    -- 最小值，可以用于数值/文本/日期

 select count(empno) from emp;
 select count(*) from emp;    -- 统计员工人数
 select sum(sal),avg(sal),max(sal),min(sal) from emp;
 select sum(ename) from emp; -- 错，不能对文本求和
 select max(ename) from emp; -- 文本可以求最大值
 select max(hiredate),min(hiredate) from emp;  -- 最新入职，和入职最久

 分组函数自动过滤空值，分组函数的各种运算都不带空值。
 select count(comm) from emp;
 select avg(comm) from emp;  -- 过滤了空值，计算结果有偏差
 如果空值需要参与分组函数的运算，先使用nvl()处理空值。
 select avg(nvl(comm,0)) from emp;   -- 所有员工都参与了运算

 如何分组？ 用 group by 子句进行分组。group by 子句放在where的后面。
 
 select deptno,avg(sal) from emp group by deptno;  -- 按部门显示平均工资
 select deptno,avg(sal) from emp where deptno in (10,20) group by deptno; -- 对
 select deptno,avg(sal) from emp group by deptno where deptno in (10,20); -- 错

 select deptno,avg(sal) from emp where avg(sal)>2000 group by deptno;  -- 错
 
 where子句中，不允许使用分组函数作查询条件。(原因一会说)
 
 having 子句 允许使用分组函数作查询条件，having和where很相似，最大的区别就是：分组函数作条件。 如果分组函数作条件，必须使用having，其它时候使用where，也可以同时出现。

 select deptno,avg(sal) from emp having avg(sal)>2000 group by deptno;  -- 对

 select deptno,avg(sal),ename from emp group by deptno;  -- 报错，ename有多个

 select e.deptno,avg(e.sal),d.dname from emp e,dept d    -- 报错，但dname没有多个
  where e.deptno = d.deptno group by e.deptno; 

 select e.deptno,avg(e.sal),d.dname from emp e,dept d   
  where e.deptno = d.deptno group by e.deptno,d.dname;   -- 正确

 select语句中使用分组函数，那么select的其它字段必须确保唯一性：
  1 在group by中出现的字段确保唯一。
  2 字段不单独出现，做分组函数的参数出现。

 子查询
  查询工资最高的员工信息(编号/姓名/工资)  
   1 select max(sal) from emp;    -- 查询最高工资
   2 select empno,ename,sal from emp where sal = 第一条SQL的查询结果;
  
  子查询可以把这两条SQL查询合成为一条SQL，子查询一般用 括号起来，放在where子句的右边做条件。
  select empno,ename,sal from emp where sal = (select max(sal) from emp);
  ()中的叫子查询，外面的叫主查询；子查询先于主查询而运行。 子查询也可以用于建表。

  查询每个部分工资最高的员工信息。
  select empno,ename,sal from emp where sal = 
    (select max(sal) from emp group by deptno);   -- 错，返回多行不能使用 = 
  select empno,ename,sal from emp where sal in  
    (select max(sal) from emp group by deptno);   -- in 可以做多行的条件

  select empno,ename,sal from emp where sal = 
    any (select max(sal) from emp group by deptno); -- 多行的返回结果可以使用all/any

 = any  -- 等于任意一个，相当于 in 
 > any  -- 大于任意一个，相当于大于最小的即可 
 > all  -- 大于所有的，相当于大于最大的。

  练习： 查询一下名字叫WARD的员工所在部门的所有员工信息(编号/姓名/工资/部门编号)
  select empno,ename,sal,deptno from emp 
   where deptno = (select deptno from emp where ename = 'WARD') ;

  Select的完整结构：
  select  字段名，表达式   
  from 表名/数据集 
  join 表2 on (连接条件)
  where 条件 
  group by 分组
  having 分组函数作条件
  order by 排序

  执行次序：
  1 from 子句
  2 join on 
  3 如果有多个join on，继续执行 join on 
  4 where 子句
  5 group by 子句
  6 having 子句
  7 select 子句
  8 order by 子句

  这个次序无法改变，除了使用子查询。子查询先于主查询而运行。

  简单的建表和删除表语句：
   create table 表名 (   -- 建表
     字段名1  字段类型1,
     字段名2  字段类型2,
     ...,
     字段名n  字段类型n
   );

   drop table 表名 ;     -- 删除表

  create table student(
      id number(7),
      name varchar2(20),
      birthday date
  );

  drop table student;

  DML语句 -- 增删改
   新增数据 -- insert into 语句
   删除数据 -- delete from 语句
   修改数据 -- update set 语句

  
  DML执行完毕后，并不能立即生效，需要使用事务处理语句生效。
   commit    -- 提交，就是让DML的结果写入数据库。
   rollback  -- 回滚，就是撤销刚才的DML操作。

  insert into 表名 (字段名1, ... , 字段名n)  values (字段值1,...,字段值n) ;
   其中， (字段名) 可以不写，默认就是所有字段都有。
  insert into student (id,name) values (1,'zhangfei');
  insert into student values(2,'guanyu',null);
  commit;
  
  练习：插入新数据刘备，出生日期要求是 1990年1月9日。
  insert into student values(3,'liubei',to_date('1999-01-09','yyyy-mm-dd'));
  commit;

  delete from 表名 where 条件;  -- where条件可以不出现，后果就是全部删除。
  delete from student;  -- 全表删除
  rollback;
  delete from student where id = 1;
  commit;

  update 表名 set 字段1 = 值1, ... 字段n=值n  where 条件; -- where不出现，就是全表修改
  update student set name = 'zhugeliang' ;  -- 全表修改
  rollback;
  update student set name = 'zhugeliang' where id = 3;
  commit;

  事务处理  -- DML语句执行完毕后，数据库中没有生效，只有经过了事务处理才会生效。
   事务处理语句包括： commit 提交     rollback   回滚  
   savepoint 设置断点，可以提交/回滚 ， 用的不是很多
   DML后数据的三种状态：
    执行dml以后，没有进行事务处理时的状态：
     1 数据库里面的数据是修改之前的数据，修改之后的状态仅存于缓存中。
     2 本窗口查询看到的是修改之后数据，其它窗口看到的是修改之前的数据。
     3 被影响的数据处于锁定状态，可以查询，不可以修改(直到事务处理完成)。
    执行dml以后，用commit提交数据后的状态：
     1 数据库里面的数据是修改之后的数据，之前的数据被覆盖，不能再找回。
     2 本窗口和其它窗口都看到的是修改之后的数据。
     3 锁定被解除，可以继续修改。
    执行dml以后，用rollback回滚数据后的状态：
     1 数据库里面的数据是修改之前的数据，本次操作被取消。
     2 本窗口和其它窗口都看到的是修改之前的数据。
     3 锁定被解除，可以继续修改。
  经验：执行DML以后，一定要commit或者rollback。

  事务处理的特点：
   1 原子性 - 就是可以实现N条SQL语句实现同时成功才成功，有一条失败就都回滚
   2 隔离性 - 就是如果不提交DML，只影响本窗口，其它窗口被隔离了。
   3 一致性
   4 持久性





