## 1.JQuery  对 ajax 的支持

>对 异步请求对象的创建  请求的发送   和 响应  以及 浏览器兼容  都做了封装 

## 2.JQuery  框架中核心的函数 
           $.ajax({
              url:"请求路径",
              type:"请求方式",
              success:成功之后的回调函数,
              dataType:"返回的数据格式",
              cache:是否使用缓存       
           });
          url 请求路径   一般来说对应的是一个服务路径 
          type  请求方式   get   post   put   delete
          success:成功之后的回调函数  相当于 readState==4&&status==200
          dataType  默认是text  如果返回的是json 则需要通过  json 说明 
          data: 是用来传递参数的 
          cache:  是否使用缓存   默认是true 
          error   请求错误时可以对应一个回调函数 
          async   是否使用异步请求  默认是 true 
          
          
### 3.定义一个User类   有如下成员变量  id   name  age  salary 
    然后写一个 Servlet  可以 把如下数据组织成对象  1001  weijie  17  50000
    以JSON 形式 返回给客户端  然后 客户把名字 和 年龄 取出来显示到页面上。
    
* 3.1  写一个 User 类  定义成员变量   并提供get set  无参 和 带参构造   toString  3

* 3.2  写一个Servelt  在服务方法中  构建User类型的对象(以后可以换成访问数据库 )
   把User 对象 转换成JSON字符串  并写给客户端。 5

* 3.3  写一个 jsp 页面  有一个按钮 和 两个span  6 
    
### 4.写一个登录功能    登录时需要对 用户名进行验证是否可用 

* 4.1 写一个连接数据库的工具类  (可以采用连接池) 

* 4.2 建立一张用户表 有  id  name  password city 

               id   的值使用序列产生   pk
               name   uk
               drop    table xdl_user cascade constraints;
               create table  xdl_user(
                   id   number   constraint xdl_user_id_pk  primary key,
                   name  varchar(30)  constraint xdl_user_name_uk unique,
                   password varchar(30),
                   city  varchar(30)
               );
               drop    sequence  xdl_user_id_seq;
               create  sequence  xdl_user_id_seq;
       
* 4.3 针对这张表 建立一个实体类   
* 4.4 写一个 dao 接口   定义一个方法 可以验证用户名是否可用
* 4.5 写一个dao 的实现类  完成验证功能  测试 --------  M
* 4.6 写一个 login.html  当光标离开时 发出ajax 请求   ---- V
* 4.7 写一个 Servlet  完成用户名的验证    ----- C
   
   
   
   
   
   
        
       
   
   
   
   
 
 
 
 
 
 
   
  
  
  
    
     
   
   
