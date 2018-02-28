# 1.什么是DI

>Dependence  Injection   依赖注入(DI是IOC的一种具体实现)解决的是组件之间的装配问题
          
# 2.Spring中依赖注入的实现方式

## 2.1 setter 注入   10

        基于set 方法的注入
        <bean id="cardb"  class="com.xdl.bean.Card">
    	     <property name="suits" value="红桃" ></property>
    	     <property name="point" value="K"></property>
    	</bean> 
    	
## 2.2 构造器注入  7
    
        基于构造方法的注入
        <bean  id="cardc" class="com.xdl.bean.Card">
    	     <constructor-arg  index="0" value="梅花"></constructor-arg>
    	     <constructor-arg  index="1" value="Q"> </constructor-arg>
    	</bean>
    	
## 2.3 自动化注入  4

       	在bean 标记中 使用 autowire 属性进行指定    取值有 
       	byName   按照Spring 容器中组件的id 进行自动查找  看是否和属性名相同  
    	byType   根据属性的类型 在容器进行查找  但是不要有多个符合条件的值 有则报错
    	constructor   类似于 byType  但是类型冲突时 会启用byName(看的是形参名)
    	autodetect    早期版本的 现在废弃了
	              
# 3.bean参数的注入

## 3.1 成员变量对应的简单值

          字符串   整数   浮点数 ... 
          <bean  id="card" class="com.xdl.bean.Card">
       	       <property name="suits"  >
       	            <value>方片</value>
       	       </property>
       	       <property name="point"  >
       	             <null></null>
       	       </property>
       	 </bean>
   	 
           练习:
           在Spring 容器中创建一个连接池对象   通过Spring 容器获取连接池对象 
           然后通过连接池对象 获取数据库连接

## 3.2 成员变量 对应的对象值

>ref="bean组件的id"
     
## 3.3 bean参数是一个集合类型

       注入一个List    
         <property  name="friends">
               <list>  
                    <value> 值1 </value>
                    <value> 值2</value>
               </list>
         </property>
      注入一个Set    
         <property  name="friends">
               <set>  
                    <value> 值1 </value>
                    <value> 值2</value>
               </set>
         </property>  
     注入一个Map 
           <property name="phones">
       	          <map>
       	               <entry key="15811999988" value="小丽"></entry>
       	               <entry key="15811009988" value="小张"></entry>
       	               <entry key="15811009999" value="小李"></entry>
       	               <entry key="15820182018" value="小泽"></entry>
       	               <entry key="15820182018" value="小小"></entry>
       	          </map>
       	   </property>
    注入一个Properties 
          <property name="phones2">
       	          <props>
       	               <prop key="15811999986"  >张飞</prop>
       	               <prop key="15811999987"  >韩信</prop>
       	               <prop key="15811999988"  >白起</prop>
       	               <prop key="15811999989"  >李靖</prop>
       	               <prop key="15811999980"  >粟裕</prop>              
       	          </props>
       	     </property>
       	     
# 4.集合参数的单独定义

        <util:list  id="">
            <value> </value>
        </util:list>  
        <util:set  id="">
            <value> </value>
        </util:set>
        <util:map  id="">
            <entry  key=""  value="" />
        </util:map>
        <util:properties id="" >
            <prop key="">值 </prop>
        </util:properties>
        .properties  可以和单独定义的属性集合关联 
        <util:properties id=""  location="classpath:相对于src的路径文件">
        </util:properties>
    
# 5.Spring 的EL表达式

>把原来EL表达式中的$变成#  取的是Spring容器中对象的值
  
# 6.组件扫描

## 6.1 什么是组件扫描

        Spring 提供了一套 可以把组件在容器中创建出来 以及组装组件的标注(注解)
        这种技术可以大大简化xml 的配置。
          
## 6.2 组件扫描的使用步骤

         1.建立一个工程 拷贝配置Spring容器对应的配置文件 和 导入jar包(IOC和AOP的)
         2.在Spring 容器对应的配置文件中开启组件扫描
         <context:component-scan   base-package="包"  />
         3.在建立java类时 需要在java类上打对应的标注 
         @Component   通用注解
         @Repository  持久化层组件注解
         @Service   业务层组件注解
         @Controller 控制层组件注解
         4.创建Spring 容器 从容器中获取对应的组件 
     
