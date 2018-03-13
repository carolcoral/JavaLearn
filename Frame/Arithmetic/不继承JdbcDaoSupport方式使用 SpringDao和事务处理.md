
# 1.不继承JdbcDaoSupport的方式来使用SpringDAO

        需要我们自己注入模板
        完成一个银行账户列表的显示
     
# 2.不继承JdbcDaoSupport的方式来使用SpringDAO  来完成一个转账逻辑 
        2.1 现在 dao 接口中定义进钱 和 出钱的方法 
        2.2 在dao的实现类中  增加 进钱和 出钱的实现方法 
        2.3 增加一个service层 封装 出钱和进钱的逻辑 为 转账 
        2.4 获取service 对象 测试转账逻辑
  
# 3.Spring 的声明式事务

          可以通过配置的方式 将操作纳入到事务管理中
          事务控制代码 和 业务逻辑代码 耦合度低
          不需要事务管理时 可以从配置中进行移除
      
# 4.Spring  声明式事务的实现步骤 

## 4.1 开启标注形式的声明式事务  和 组件扫描
          <!-- 开启事务注解扫描 -->
           <tx:annotation-driven
               transaction-manager="txManager" proxy-target-class="true"/>
          transaction-manager 这个属性对应一个事务管理器 
          proxy-target-class  这个属性 如果取值为 "true"  则优先使用CGLIB 生成代理
                 如果为"false" 就优先使用 JDK的代理机制(代理类和被代理类必须实现共同的接口)。
         
## 4.2 配置事务管理器

           <bean id= "txManager"
            class= "org.springframework.jdbc.datasource.DataSourceTransactionManager">
            <property name= "dataSource" ref="ds"/>
           </bean>
   
## 4.3 在需要事务管理的地方 加事务控制的标注 

        @Transactional
   
## 4.4.@Transactional 这个标注的属性 

          rollBackFor   用来指定相应的检查异常进行事务回滚 因为 Spring 默认只针对运行时异常回滚事务。
          noRollbackFor  针对哪些运行时异常不回滚 
          readOnly    事务中有修改数据的代码 则 readyOnly 为false    默认就是false
          isolation   事务隔离级别    读未提交  读提交  可重复读   序列化
          用来解决三大读问题
          脏读       一个事务读取到了另外一个事务没有提交的数据   
          不可重复读   一个事务在开始时 读取到一份数据  在这个事务执行的过程中 另外一个事务 修改了这份数据  并进行了提交  哪第一个事务再次读取这份数据时 发现数据发生了改变。
          幻读    一个事务对表中的所有数据都进行统计,这时候另外一个事务对表进行数据的增加并提交再次统计时数据发生了改变 。   
          propagation  事务传播特性 一共有七个 
  
