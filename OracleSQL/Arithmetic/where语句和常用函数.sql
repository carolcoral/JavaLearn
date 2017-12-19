
where 字句用于条件查询，比如：查询工资超过1000的员工信息（编号/姓名/工资）

select empno,ename,sal from emp where sal > 1000;
select empno,ename,sal from emp where ename = 'KING';

where 后面的运算符：
> < >= <= != =
between a and b 在a和b之间，包括a和b（双闭区别）
in（a，b，c） a或者b或者c  not in（a,b,c） 不是a b c
like ''  模糊查询
is null     is not null 与空值比较  不能用 = 或者 ！=
逻辑运算符
and - 并且关系
or  - 或者关系
not - 取反

查询工资在1000到1500之间的员工信息
select empno,ename,sal from emp where sal between 1000 and 1500;
select empno,ename,sal from emp where sal >= 1000 and sal <=1500;

经验：尽可能把出现频率高的数据放在in的前面

like的使用
模糊查询就是条件不完整的情况下，对数据进行查询，一般针对字符串
查询名字中包括ar的员工信息
字段 like ‘格式’
其中，格式中包括 模糊的数据， 
      %代表0-n个任意字符
      _ 代表1个任意字符
 like '%AR%'  名字中包含AR的员工
select empno,ename,sal from emp where ename like '%AR%';
   不具备普及性，使用函数
select empno,ename,sal from emp where '%'||ename like '\%AR%' escape '\';
   如果被模糊查询的数据中包括%或_ 需要使用escape指定转义字符

select empno,ename,sal from emp where comm is null；
select empno,ename,sal from emp where comm is not null；

and 和 or的优先级不同，and先算，因此如果多条件时，用括号提升优先级
select empno,ename,sal from emp where sal>1000 and deptno=30 or deptno =20;
select empno,ename,sal from emp where deptno=20 or deptno=30 and sal>1000;
select empno,ename,sal from emp where (deptno=20 or deptno=30) and sal>1000;

排序语句 order by
    默认升序，如果需要降序，在后面加上desc
    order by 字句放在SQL语句的最后面，允许多个字段同时排序，次序就是第一个字段相等，按第二个排
    空值默认为最大
    select empno,ename,sal from emp order by sal;
    select empno,ename,sal from emp order by sal desc;
    select empno,ename,sal from emp order by comm;  带空值排序
    select empno,ename,sal from emp order by 3;
    select empno,ename,sal from emp order by sal，ename desc; 只降序名字？

Oracle函数
   函数分为单行函数和多行函数（分组函数），单行函数就是一行进，一行出。
   多行函数就是多行进，一行出。
   单行函数包括：
       字符函数 ---处理字符串的函数
       数值函数 ---处理数值类型的函数
       日期函数 ---处理日期类型的函数
       转换函数 ---文本类型和数值类型的转换/文本类型和日期类型的转换
       其他函数 ---其他的函数，比如：nv1（）
   字符函数：
	upper（）  ---所有字母全大写
	lower（）  ---所有字母全小写
	initcap（）---所有单词首字母大写
	length（） ---文本的长度
	substr（） ---截取子串

   也即是测试表
    dual 表是一个虚表，里面只有一个字段，但字段类型没有限制。
    select 1+1 from dual；
    select sysdate from dual； --系统的当前时间，是日期函数
    select upper（'hello SQL'）from dual; 
    select lower（'hello SQL'）from dual;
    select initcap（'hello SQL'）from dual;
    select length（'hello SQL'）from dual;
    select substr（'hello SQL',2,3）from dual; 2是从起始位置（从1开始）

   练习： 查询名字中包括ar的员工信息并且忽略大小写。
    select empno,ename,sal from emp where lower(ename) like lower('%ar%');

   数值函数：
   round（） --- 四舍五入
   trunc（） --- 舍弃后面的数
   select round(1234.567,2)from dual; 2134.57
   select round(1234.567,0)from dual; 1235
   select round(1234.567,-2)from dual; 1200
   
   select trunc(1234.567,2)from dual; 1234.56
   select trunc(1234.567,0)from dual; 1234
   select trunc(1234.567,-2)from dual; 1200  ----添0是为了保持权重；

   日期函数：
     sysdate --系统时间，就是现在的时间
     select sysdate-1 from dual; -- 昨天，日期支持加法和减法
    日期在Oracle中包括：世纪/年/月/日/时/分/秒，如果两个日期相等，需要7个部分相等
   
   转换函数：
     to_number() --文本转数字，不重要
     to_char()   --数字转文本，不重要

     to_date()   --文本转日期，重要 插入数据时使用较多
     to_char()   --日期转文本，重要 查询数据时使用较多
     数字和文本的转换，第一个参数是需要转换的数据，第二个参数是格式，包括：
     9  代表任意一个数字，在小数点前面没有强制性，在后面要补0
     0  代表任意一个数字，有强制性，要补0
     $  代表美元符号
     ， 代表千分位
     select to_char(1234.567,'$00000.0000')from dual;
     select to_char(1234.567,'$99999.9999')from dual;
     select to_char(1234.567,'$99,999.9999')from dual; -- 文本转数字

     日期和文本的转换
     select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss')from dual;
     -- 小写可以
     select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS')from dual;
     -- 大写也实现了。使用上不区分大小写，是因为实现了两次

     练习：查询入职时间是今天的所有员工信息（编号/姓名/工资/入资时间）不包括年
     select empno,ename,hiredate from emp 
          where to_char(sysdate,'mm-dd') =  to_char(hiredate,'mm-dd');

     select empno,ename,to_char(hiredate,'yyyy-mm-dd')hiredate from emp;

     to_date() -文本转日期
     select to_date('2013-05-08','yyyy-mm-dd')from dual;
     单行函数可以无限次的嵌套。
     查询每个名字的后3个字母
     select ename,substr(ename,length(ename）-2,3)from emp;

重要的单行函数： upper/lower/length/substr/to_char/to_date/nvl/sysdate

     多表连接
     select empno，ename，sal，deptno from emp;
     如果查询的数据来自于两张或者多张表，需要使用多张表连接进行查询。
     默认情况下，多表连接查询时，会把两个表的数据拼起来，叫笛卡尔积。可以用where条件
从笛卡尔积中筛选出有效数据.
     select empno，ename，dname，emp.deptno,dept.deptno from emp,dept
          where emp.deptno = dept.deptno;
     使用别名可以简化表名：
     select e.empno,e.name,d.dname,e.deptno,d.deptno from emp e,dept d
          where e.deptno = d.deptno;
     笛卡尔积效率比较低，因此多表连接时，表的数量不宜过多，一般4-5张最多
    语法：
        select 表名1.字段1,.....表名2.字段1，....from 表名1 别名1，表名2 别名2
          where 连接的条件；
         其中，表名也可以使用别名。

