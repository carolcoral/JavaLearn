ResultSetMetaData接口可以对结果集实现动态编程的效果。

练习： 用数据库实现用户登录。
 1 建表，插入用户的数据。
  drop table users_zlm;
  create table users_zlm (
    id number(10) primary key,
    name varchar2(40) not null,
    passwd varchar2(20)
  );
  drop sequence seq_users;
  create sequence seq_users;
  insert into users_zlm values (seq_users.nextval,'zhangfei','123');
  commit;
 2 用IO流实现用户的输入，输入用户名和密码，去数据库验证，然后打印登陆成功或者失败。
  2.1 用IO实现数据的输入。
  2.2 拿到用户名和密码以后查询数据库。

 Statement有大BUG，对SQL注入没有限制。解决方案： PreparedStatement。PreparedStatement是Statement的子接口，是Statement的增强版，安全，高效。

 JDBC的编程步骤：
  1 先写URL，jdbc:oracle:thin:@localhost:1521:SID。
  2 使用DriverManager.getConnection(url,username,passwd) 获取数据库的连接。
  3 使用 conn.prepareStatement(Sql)获取PreparedStatement，sql中包含 ? 做占位符。
  4 ps.setXX(int第几个占位符 ,值)。
  5 ps.executeQuery()执行查询，ps.executeUpdate() 执行 DML 。
  6 如果是查询，用ResultSet的while(rs.next()) { rs.getXX() } 。
  7 关闭各种资源。 rs/ps/conn。

 PreparedStatement除了安全性之外，还提供了 大量数据插入的高效的处理方式： 批处理。
  先用addBatch()加入批处理， 然后用executeBatch() 执行批处理。
  
 Java程序控制事务的方法：
   所有的事务处理都在Connection接口中实现，首先conn.setAutoCommit(false); 取消事务的自动提交；然后由程序员手动 commit()或者rollback() 。

 JAVA操作数据库时，url/用户名/密码其实都应该是可以配置的，随着配置的改变可以操作不同的数据库。配置一般写在文件中，叫配置文件。java.util.Properties类可以直接操作配置文件。
  
 create or replace procedure getmax
 is
 begin
    insert into dept values(21,'chifan','guangzhou');
    commit;
 end;

 作业&练习：
   实现对数据库单表的增删改查。
   新建一个用户表，包括：ID/用户名/密码/邮箱。(约束/序列)
   插入一条数据。
   然后实现对用户表的增删改查。
   先提示，
   输入1新增用户，输入2修改用户，输入3删除用户，输入4查询所有用户信息并显示，输入5退出。
   其中，修改和删除用户时，需要先输入用户的ID。
