# 1.基于标注的Spring  MVC的实现步骤
## 1.1 创建一个工程  拷贝Spring 容器对应的配置文件  和 导入jar包(ioc  aop  mvc )

        并在WEB-INF 建立一个页面 login.jsp

## 1.2在web.xml 中 配置 DispatcherServlet
## 1.3 开启组件扫描 和 mvc 的标注

        <context:component-scan  base-package=""   />
        <mvc:annotation-driven   />
     
## 1.4写一个控制器(不需要实现Controller 接口) 返回值可以String 或者 ModelAndView

          以后可以是对象 或者 集合 
          在控制器对应的方法上 写 @RequestMapping("/请求路径")
          
## 1.5配置ViewResolver 
  
# 2.如何在控制器中获取请求的参数数据 
## 2.1 使用HttpServletRequest 的 API
## 2.2 通过Spring 容器直接注入参数

        页面参数名和控制器参数名保持一致即可

##  2.3 通过Spring 容器直接注入参数

        如果页面参数名和控制器参数名不一致 则 @RequestParam("页面参数名")
      
## 2.4 直接定义控制器中的参数为 对象类型 (要求成员变量和页面中的参数中保持一致)   
# 3.如何把控制器的数据 传递给jsp 页面 
## 3.1 借助HttpServletRequest  或者 HttpSession 
## 3.2 借助 ModelAndView 对象 传递数据信息和 页面信息

        mav.getModel().put("key","信息"); 
      
## 3.3 借助 ModelMap 传递数据

          mm.addAttribute("key","value");
          mm.put("key","value");
      
## 3.4 使用 Model 传递数据

        model.addAttribute("key","value");
      
# 4.如何获取session 对象

           使用HttpServletRequest 对象来获取HttpSession 类型对象
           使用HttpSession 参数直接获取
        
# 5.在Spring 的控制器中 如何实现重定向 
## 5.1 控制器返回字符串时

            return  "redirect:重定向的路径"
     
## 5.2 控制返回 ModelAndView 时

     RedirectView  rv = new  RedirectView("重定向的地址");
     mav.setView(rv);
     
# 6.写一个登录功能  登录成功之后把账户对象放入 session 然后重定向到主页面  显示 账号的名字。
## 6.1 建立一张表  xdl_account   字段 

            ano    varchar2(30)  pk
            aname  varchar2(30)  uk
            password  varchar2(30)
            
            create  table  xdl_account(
                ano  varchar2(30) constraint xdl_account_ano_pk  primary key,
                aname varchar2(30) constraint xdl_account_aname_uk unique,
                password  varchar2(30)
            );
            insert into  xdl_account values('0001','abc','123');
            commit;
        
## 6.2 建立一个项目  拷贝 Spring的配置文件  和 jar包

         (ioc  aop  dao  mvc 连接池 jdbc驱动)   在WEB-INF下增加 login.jsp main.jsp
         
## 6.3 根据表设计一个实体类 
## 6.4 设计一个 dao 接口  定义可以根据用户名和密码进行登录的方法    
## 6.5 写dao 的实现类

        打@Repository  注入jdbcTemplate (依赖于dataSource) 
        
## 6.6 开启组件扫描 和  开启 mvc  测试dao 的功能
## 6.7 封装一个service 类 注入dao 对象  -------- M
## 6.8 配置mvc 的 DispatcherServlet
## 6.9 编写 控制器  返回对应页面信息   
## 6.10 配置ViewResolver   测试功能 
