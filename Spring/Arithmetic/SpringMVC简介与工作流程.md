# 1.什么MVC

    Model  View  Controller  模型视图控制器     便于分层和解耦
    Model   封装数据 和 业务逻辑的 
    View    用来显示数据 或者 收集数据 
    Controller   用来处理流程的  流程控制的作用 
    
# 2.Spring Web  MVC 五大组件

    DispatcherServlet   控制器 请求入口   
    HandlerMapping     控制器  请求派发
    Controller         控制器 处理请求控制流程
    ModelAndView       封装了数据和视图的信息
    ViewResolver       处理视图信息的类
    
# 3.发一个servlet 请求 hello.do  然后跳转到 hello.jsp
## 3.1 建立一个项目 拷贝Spring 容器对应的配置文件  和 
      导入对应的jar 包(ioc  mvc) 
   8.2 在web.xml 中 配置 DispatcherServlet   关联Spring的配置文件
   8.3 在Spring 配置文件中 配置 HandlerMapping 
             配置请求和控制器的对应的关系 
   8.4 建立一个Controller 类 实现 Controller 接口 
            完成控制逻辑    返回ModelAndView    
   8.5 在Spring 配置文件中 配置 控制器 
   8.6 最后配置 ViewResolver  处理视图信息 
   8.7 部署程序到 web服务器  浏览器发出hello.do 请求测试
