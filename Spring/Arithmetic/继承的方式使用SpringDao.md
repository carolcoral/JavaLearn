# 1.和组件创建相关的标注

          @Scope("prototype")    把组件在容器中创建时 设置成非单例
          @PostConstruct         加在组件对应的初始化方法上 
          @PreDestroy            加在组件对应的销毁方法上
  
# 2.和组件装配有关的标注

          @Value   可以装配基本值 也可以借助EL表达式完成对象组件的装配
          @Autowired  可以用在成员变量  set方法 构造方法上 
              注入对象默认必须能从容器中找到 有一个找不到就崩溃 
              这个标注优先按照类型查找  找不到就会启用名字查找  再找不到就抛异常 除非
              加上requried=false。这个标注结合另外一个标注  @Qualifier(不能加在构造上) 
              可以指定名字查找,如果找不到@Autowired 也是抛异常(不会使用类型查找),
              借助requried=false 也可以解决。 
          @Resource  可以用在成员变量 和 set方法上 
               这个标注不属于Spring框架   是JDK中的标注,这个标注优先以名字进行组件查找
               找不到会启用类型进行查找。当然也可以使用name 进行组件指定名字查找.
       
# 3.写一个PlayerDao 接口  

        然后提供这个的实现类,接口中有 插入一个Player的方法 和 根据名字进行删除的一个方法。 实现类中的代码不需要写具体的实现。使用组件扫描加载PlayerDAO的实现类 并容器PlayerDAO的实现类对象。提供一个PlayerService 并使用 PlayerDAO对象 使用组件装配给 PlayerService 装配PlayerDAO,从容器中获取 PlayerService 对象 并调用其中的方法。

# 4.SpringDAO 对JDBC 做了哪些改进

          4.1 封装了JDBC  简化了DAO实现类编写 
          4.2 提供了AOP模式的事务处理 
          4.3 对JDBC中抛出的SQLException 进行封装 封装成了一个运行时异常
             DataAccessException。
     
# 5.SpringDAO 完成数据库访问的核心类 是JdbcTemplate

          使用这个类 无需关心 驱动加载  连接获取  执行环境获取  以及资源的释放 
          模板中的方法有: 
         queryForInt     过时的查询一个整数的方法
         queryForObject  替代上面的方法
         query     完成查询的方法
         update    完成增 删 改的方法
         execute   可以执行任何sql语句 但基本上不用 
         
# 6.如何使用 JdbcTemplate

         6.1 第一种是继承 JdbcDaoSupport  这个类中有对应的模板
         6.2 不继承JdbcDaoSupport  需要自己创建模板
 
# 7.继承 JdbcDaoSupport 的方式来完成一个表中数据量的查询 

          7.1 建立一张银行账户表   建表之前先删除表  并插入几条测试数据
              ano   varchar2(30)
              aname  varchar2(30)
              apassword varchar2(30)
              money    number
              
              drop  table  bank_account cascade constraints;
              create table bank_account (
                  ano   varchar2(30) constraint bank_account_ano_pk primary key,
                  aname  varchar2(30) constraint bank_account_aname_uk unique,
                  apassword varchar2(30),
                  money    number 
              );
              insert into  bank_account values('0001','xiaoma','123',1000);
              insert into  bank_account values('0002','mengge','123',8000);
              insert into  bank_account values('0003','liangge','123',5000);
              commit;  
          7.2 在项目中拷贝 Spring 容器对应的配置 和 jar 包 (ioc aop dao 
                 数据驱动包和连接池包) 
          7.3 开启组件扫描  
          7.4 写银行账户的dao 接口 定义查询数据量的方法  并 以继承 
           JdbcDaoSuppport的方式 来写实现类  使用父类的模板完成查询
               需要注入一个数据源对象
          7.5 从容器中获取dao实现类 并对查询进行测试 
          
# 8.根据 账户的名字 和 账户的密码 来查询一个账户信息

           8.1 建立一个银行账户的实体类 
           8.2 在dao接口中增加一个更加用户名 和 密码查询账户信息的方法
           8.3 在dao的实现类中 实现方法  使用模板和对应的查询方法获取账户
                     这里会使用的映射器  (封装结果集转换成对象的过程)
           8.4 测试dao 的方法
   
# 9.根据 小于某个钱数的信息  来查询账户列表信息

           9.1 在接口中 增加一个 更加钱数查询账户列表的方法
           9.2 在实现类实现账户列表信息的查询
   
# 10.使用Spring DAO  完成增删改

           完成对银行账户的增加 
             a.在接口中 增加一个 增加银行账户的方法 
             b.在实现类中 实现增加银行账户的方法
                      使用模板的 update方法     
             c.测试
          根据账户的账号 来删除账户信息 
             a.在接口中 增加一个 删除银行账户的方法 
             b.在实现类中 实现删除银行账户的方法
                      使用模板的 update方法     
             c.测试    
     
