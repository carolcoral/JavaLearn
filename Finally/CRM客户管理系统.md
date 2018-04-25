# 【CRM客户管理系统】
## 调研
## 产品
## 需求
    参考《01_CRM需求概要文档V1.0》
## UI

## 开发
* 技术选型：

        SSM、MYSQL57、tomcat7、jdk1.7、boostrap、anglur.js、quartz、ehcache、富文本编辑器(百度编辑器)

* 框架搭建：
    * 数据库设计：
    
            数据库名称=工程名称CRM_16
            表设计：
                表字符：utf-8、utf8
                表字段：
                    主键、bigint(20) 自增、（32） UUID、不能为空
                索引：
                    外键、关联字段、查询比较频繁的字段
                单表：500M、索引个数16个
                临时表、存储过程、视图、触发器、监听器


    * 数据库优化原则：

* CRM数据库表设计说明：
    
        参考脚本文件《crm.sql》

            hj_user 用户表
                userid 用户主键
                roleid  角色主键
                deptid 部门主键
            
            hj_role 角色表
                roleid 角色ID
                deptid 部门ID
            
            hj_dept 部门表
                deptid 部门ID
                deptparaid 上一级部门ID
            
            hj_menu 菜单表
                menuid 菜单主键ID
                menuparaid 上一级菜单ID
            
            hj_role_menu  角色-菜单关系表
                roleid 角色ID
                menuid 菜单ID

* SQL需求:
    * 需求1：查询用户ID=2的信息： 用户ID，用户名，角色ID，角色名称，部门ID，部门名称

            select
                u.userid,u.username,u.roleid,r.rolename,u.deptid,d.deptname
            from hj_user u
            left join hj_role r on r.roleid = u.roleid
            left join hj_dept d on d.deptid = u.deptid
            where u.userid = 2;

    * 需求2：查询角色ID=2所属的菜单信息：角色ID，角色名称，菜单ID，菜单名称

            select 
                rm.roleid,r.rolename,rm.menuid,m.menuname
            from hj_role_menu rm
            left join hj_role r on r.roleid = rm.roleid
            left join hj_menu m on m.menuid = rm.menuid
            where rm.roleid = 2;
        
            select 
                rm.roleid,r.rolename,rm.menuid, 
                -- group_concat()
                group_concat(m.menuname separator ',') menuname
            from hj_role_menu rm
            left join hj_role r on r.roleid = rm.roleid
            left join hj_menu m on m.menuid = rm.menuid
            group by r.rolename;


    * 需求3：查询系统管理（菜单ID=1）所有下级菜单

            select * 
            from  hj_menu m
            where m.menuparaid = 1;

    * 需求4：查询所有的上级菜单信息 
    
            select * 
            from  hj_menu m
            where m.menuparaid is null;

* 项目工程搭建步骤：
    * 1：新建一个web project工程CRM_16
    * 2：解压FTP中CRM压缩包到本地文件夹
    * 3：工程名右键，选择build path，选中最后一个选项，将tomcat的jar包导入工程
    * 4：复制压缩文件中的webroot文件夹“内”的文件，到工程的WebROOT文件夹下
    * 5：复制lib文件夹下的jar包复制到工程中
    * 6：取消前端文件验证表达式错误，操作步骤，参考下图
    ![](https://i.imgur.com/7rGu5JI.png)

* 框架代码：
    * web.xml:
    
            通用性设置如下：

            <!-- spring配置文件信息 -->
            <!-- springMVC配置文件信息 -->
        
            <!-- 编码格式 -->
            <!-- 日志信息 -->
            <!-- session有效期 -->
            <!-- 404、500 -->
            <!-- 请求后缀拦截.do(后台管理系统)，.htm(前端网站) -->

            <?xml version="1.0" encoding="UTF-8"?>
            <web-app version="2.5" 
                xmlns="http://java.sun.com/xml/ns/javaee" 
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
                xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
                http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
              <display-name>CRM_16</display-name>   
            
              <!-- spring配置文件信息 -->
                <context-param>
                    <param-name>contextConfigLocation</param-name>
                    <param-value>classpath:applicationContext.xml</param-value>
                </context-param>
                <listener>
                    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
                </listener>
              <!-- springMVC配置文件信息 -->
                <servlet>
                    <servlet-name>crm_16</servlet-name>
                    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
                    <init-param>
                        <param-name>contextConfigLocation</param-name>
                        <param-value>classpath:context-dispatcher.xml</param-value>
                    </init-param>
                    <!-- 启用即加载 -->
                    <load-on-startup>1</load-on-startup>
                </servlet>
            
                <!-- 请求后缀拦截.do(后台管理系统)，.htm(前端网站) -->
              <servlet-mapping>
                    <servlet-name>crm_16</servlet-name>
                    <url-pattern>*.do</url-pattern>
              </servlet-mapping>
            
              <!-- 编码格式UTF-8 -->
                <filter>
                    <filter-name>encodingFilter</filter-name >
                    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
                    <init-param>
                        <param-name>encoding</param-name>
                        <param-value>UTF-8</param-value>
                    </init-param>
                    <init-param>
                        <param-name>forceEncoding</param-name>
                        <param-value>true</param-value>
                    </init-param>
                </filter>
                <filter-mapping>
                    <filter-name>encodingFilter</filter-name>
                    <url-pattern>*</url-pattern>
                </filter-mapping>
            
              <!-- 日志信息 -->
                <context-param>
                    <param-name>log4jConfigLocation</param-name>
                    <param-value>classpath:/log4j.xml</param-value>
                </context-param>
                <!-- 加载log4j配置文件 -->
                <listener>
                    <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
                </listener>
            
            
              <!-- session有效期 -->
              <session-config>
                <session-timeout>120</session-timeout><!-- 默认的是分钟 -->
              </session-config>
              <!-- 404、500 -->
              <error-page>
                <error-code>404</error-code>
                <location>/404.do</location>
              </error-page>
              <error-page>
                <error-code>500</error-code>
                <location>/500.do</location>
              </error-page>
            
                <!-- 首页信息(可选) -->
                <welcome-file-list>
                    <welcome-file>/index.do</welcome-file>
                </welcome-file-list>
            </web-app>


* 连接池：
    * c3p0:
    * 阿里:

        问题：
            1：游标越界
            2：事务连接次数过多  too  many  connect
        
        解决方式：
        
            参考代码

### 登录页面跳转
* 开发步骤：

        1：获取跳转页面的接口地址(前端获取)
        2：增加controller类进行页面跳转

* 代码示例：
    * UserLoginController.java:
    
            /**
             * 登录首页
             * @author likang
             * @date   2018-4-19 下午5:33:34
             */
            @Controller
            public class UserLoginController {
                /**
                * 跳转登录页面
                * @param model
                * @return
                */
                @RequestMapping(value = "/login.do",method = RequestMethod.GET)
                public String index(Model model){
                    return JumpViewConstants.SYSTEM_LOGIN;
                }
            }

* 页面展示：
![](https://i.imgur.com/nS0sDEd.png)

### 登录
* 开发步骤:
    * 1：通过点击【登录】按钮，获取登录的接口地址
    * 2：在UserLoginController类中，增加登录接口
    * 3：首先判断用户名是否存在，其次判断匹配是否匹配
    * 4：处理session问题

* 代码如下：
    * UserLoginController.java:
    
            /**
             * 登录首页
             * @author likang
             * @date   2018-4-19 下午5:33:34
             */
            @Controller
            public class UserLoginController {
                @Autowired
                private IUserService userService;
            
                /**
                 * 跳转登录页面
                 * @param model
                 * @return
                 */
                @RequestMapping(value = "/login.do",method = RequestMethod.GET)
                public String index(Model model){
                    return JumpViewConstants.SYSTEM_LOGIN;
                }
            
                /**
                 * 登录功能
                 * @param request
                 * @param email  用户名
                 * @param password 密码
                 * @param sign
                 * @return
                 */
                @RequestMapping(value = "/login.do",method = RequestMethod.POST)
                public String login(HttpServletRequest request,String email,String password,String sign,Model model){
            //      if (email != null &amp;&amp; !"".equals(email)) {
            //          
            //      }
                    //isnotblank:判断参数是否为空和“”
                    //isNotEmpty：只会判断参数是否为null
                    if (StringUtils.isNotBlank(email) &amp;&amp; StringUtils.isNotBlank(password)) {
                        //利用spring容器获取map中的属性值
                        email = email + ContextUtil.getInitConfig("email_suffix");
            
                        //验证用户名是否存在
                        User user = userService.queryUserByEmail(email);
                        if (user == null) {//用户不存在
            //              model.addAttribute(ReturnConstants.USER_NOT_EXIST);
                            model.addAttribute("msg", ReturnConstants.USER_NOT_EXIST);
                            return JumpViewConstants.SYSTEM_LOGIN;
                        }
                        //验证密码是否匹配
                        boolean isExis = userService.isExisPassword(String.valueOf(user.getUserid()), password);
                        if (!isExis) {
            //              model.addAttribute(ReturnConstants.PASSWORD_ERROR);
                            model.addAttribute("msg", ReturnConstants.PASSWORD_ERROR);
                            return JumpViewConstants.SYSTEM_LOGIN;
                        }
                        //cookie
                        //TODO......
            
                        //处理session
                        UserContext.setLoginUser(user);
                        request.getSession(true).setAttribute("loginName", user.getUsername());
                        request.getSession(true).setAttribute("ischange", user.getIschange());
                        //跳转成功首页
                        return JumpViewConstants.SYSTEM_INDEX;
                    }
                    return ReturnConstants.PARAM_NULL;//接收参数为空
                }
            
            }

    * IUserService.java:
    
            /**
             * 用户信息接口
             * @author likang
             * @date   2018-4-23 上午9:36:12
             */
            public interface IUserService {
            
                /**
                 * 根据邮箱查询用户信息
                 * @param email 邮箱
                 * @return
                 */
                public User queryUserByEmail(String email);
            
                /**
                 * 验证密码是否匹配
                 * @param userid 用户主键ID
                 * @param password  密码
                 * @return
                 */
                public boolean isExisPassword(String userid,String password);
            }

    * UserServiceImpl.java:

            @Service
            @Transactional(rollbackFor=Exception.class)
            public class UserServiceImpl implements IUserService{
            
            //  @Resource//首先按照名称匹配，其次按照类型匹配
                @Autowired//只会按照类型匹配(推荐使用)
                IDataAccess<User> userDao;
            
                public User queryUserByEmail(String email) {
            
                    Map<String, Object> param = new HashMap<String, Object>();
                    param.put("email", email);
                    List<User> list = userDao.queryByStatment("queryUserByEmail", param, null);
                    if (list != null &amp;&amp; list.size() > 0) {
                        return list.get(0);
                    }
                    return null;
                }
            
                public boolean isExisPassword(String userid, String password) {
                    Map<String, Object> param = new HashMap<String, Object>();
                    param.put("userid", userid);
                    param.put("password", MD5Tools.encode(password));
                    List<User> list = userDao.queryByStatment("isExisPassword", param, null);
                    if (list != null &amp;&amp; list.size() > 0) {
                        return true;
                    }
            
                    return false;
                }
            }

    * UserMapper.xml:

            <!-- 查询用户是否存在 -->
            <select id="queryUserByEmail" parameterType="java.util.Map" resultType="com.hjcrm.system.entity.User">
                 select
                    u.userid,u.username,u.email,u.roleid,u.deptid,u.ischange
                from hj_user u
                where u.email = #{email}
            </select>
            
            <!-- 查询用户密码是否匹配-->
            <select id="isExisPassword" parameterType="java.util.Map" resultType="com.hjcrm.system.entity.User">
                 select
                    u.userid,u.username,u.email,u.roleid,u.deptid
                from hj_user u
                where u.userid = #{userid} and u.password = #{password}
            </select>
            </code></pre>
            
            <p>mybatis-config.xml:</p>
            <pre><code><mappers>
                <mapper resource="commonsqlmappings/CommonMapper.xml" />
                <mapper resource="mybatis/UserMapper.xml"/>
            </mappers>

### 登录功能-首页访问--完善功能
* 代码如下：
    * UserLoginController.java:

            /**
             * 登录首页
             * @author likang
             * @date   2018-4-19 下午5:33:34
             */
            @Controller
            public class UserLoginController {
            
            
                @Autowired
                private IUserService userService;
            
                /**
                 * 跳转登录页面
                 * @param model
                 * @return
                 */
                @RequestMapping(value = "/login.do",method = RequestMethod.GET)
                public String index(Model model){
                    if (UserContext.getLoginUser() != null) {
                        return "redirect:/main.do";
                    }
                    return JumpViewConstants.SYSTEM_LOGIN;
                }
            
                /**
                 * 主页面
                 * @param model
                 * @return
                 */
                @RequestMapping(value = "/main.do",method = RequestMethod.GET)
                public String main(Model model){
                    if (UserContext.getLoginUser() != null) {
                        return JumpViewConstants.SYSTEM_INDEX;
                    }
                    return JumpViewConstants.SYSTEM_LOGIN;
                }
            
                /**
                 * 登录功能
                 * @param request
                 * @param email  用户名
                 * @param password 密码
                 * @param sign
                 * @return
                 */
                @RequestMapping(value = "/login.do",method = RequestMethod.POST)
                public String login(HttpServletRequest request,String email,String password,String sign,Model model){
            //      if (email != null &amp;&amp; !"".equals(email)) {
            //          
            //      }
                    //isnotblank:判断参数是否为空和“”
                    //isNotEmpty：只会判断参数是否为null
                    if (StringUtils.isNotBlank(email) &amp;&amp; StringUtils.isNotBlank(password)) {
                        //利用spring容器获取map中的属性值
                        email = email + ContextUtil.getInitConfig("email_suffix");
            
                        //验证用户名是否存在
                        User user = userService.queryUserByEmail(email);
                        if (user == null) {//用户不存在
            //              model.addAttribute(ReturnConstants.USER_NOT_EXIST);
                            model.addAttribute("msg", ReturnConstants.USER_NOT_EXIST);
                            return JumpViewConstants.SYSTEM_LOGIN;
                        }
                        //验证密码是否匹配
                        boolean isExis = userService.isExisPassword(String.valueOf(user.getUserid()), password);
                        if (!isExis) {
            //              model.addAttribute(ReturnConstants.PASSWORD_ERROR);
                            model.addAttribute("msg", ReturnConstants.PASSWORD_ERROR);
                            return JumpViewConstants.SYSTEM_LOGIN;
                        }
                        //cookie
                        //TODO......
            
                        //处理session
                        UserContext.setLoginUser(user);
                        request.getSession(true).setAttribute("loginName", user.getUsername());
                        request.getSession(true).setAttribute("ischange", user.getIschange());
                        //跳转成功首页
            //          return JumpViewConstants.SYSTEM_INDEX;
                        return "redirect:/main.do";
                    }
                    return ReturnConstants.PARAM_NULL;//接收参数为空
                }
            }

### 登录功能-cookie问题
* 开发步骤：
    * 1：为了解决用户端禁用浏览器cookie第三方数据的问题
    * 2：只需要在服务器中保存一份cookie即可，同步到浏览器客户端

* 示例代码：
    * UserLoginController.java:

            private static final String COOKIE_KEY = "_auth_";
            private static final String COOKIE_SPI = "_#_";
            
                /**
                 * 登录功能
                 * @param request
                 * @param email  用户名
                 * @param password 密码
                 * @param sign
                 * @return
                 */
                @RequestMapping(value = "/login.do",method = RequestMethod.POST)
                public String login(HttpServletRequest request,HttpServletResponse response,String email,String password,String sign,Model model){
            //      if (email != null &amp;&amp; !"".equals(email)) {
            //          
            //      }
                    //isnotblank:判断参数是否为空和“”
                    //isNotEmpty：只会判断参数是否为null
                    if (StringUtils.isNotBlank(email) &amp;&amp; StringUtils.isNotBlank(password)) {
                        //利用spring容器获取map中的属性值
                        email = email + ContextUtil.getInitConfig("email_suffix");
            
                        //验证用户名是否存在
                        User user = userService.queryUserByEmail(email);
                        if (user == null) {//用户不存在
            //              model.addAttribute(ReturnConstants.USER_NOT_EXIST);
                            model.addAttribute("msg", ReturnConstants.USER_NOT_EXIST);
                            return JumpViewConstants.SYSTEM_LOGIN;
                        }
                        //验证密码是否匹配
                        boolean isExis = userService.isExisPassword(String.valueOf(user.getUserid()), password);
                        if (!isExis) {
            //              model.addAttribute(ReturnConstants.PASSWORD_ERROR);
                            model.addAttribute("msg", ReturnConstants.PASSWORD_ERROR);
                            return JumpViewConstants.SYSTEM_LOGIN;
                        }
                        //cookie
                        Cookie cok = new Cookie(COOKIE_KEY, URLEncoder.encode(user.getUsername())+COOKIE_SPI+MD5Tools.encode(user.getEmail()));
                        cok.setPath("/");
                        cok.setMaxAge(-1);//-1：立即创建，并且在登录成功之后，就生效
                                           //0：在客户端关闭浏览器之后，即失效
                        response.addCookie(cok);
                        //处理session
                        UserContext.setLoginUser(user);
                        request.getSession(true).setAttribute("loginName", user.getUsername());
                        request.getSession(true).setAttribute("ischange", user.getIschange());
                        //跳转成功首页
            //          return JumpViewConstants.SYSTEM_INDEX;
                        return "redirect:/main.do";
                    }
                    return ReturnConstants.PARAM_NULL;//接收参数为空
                }

## 退出功能
* 开发步骤：
    * 1：清除session信息
    * 2：清除存放于服务器中的cookie数据
    * 3：清除客户端中的cookie数据
    * 4：跳转登录页面即可

* 示例代码：
    * UserLoginController.java:
    
            /**
            * 退出
            * @param request
            * @return
            */
            @RequestMapping(value = "/logout.do",method = RequestMethod.GET)
            public String logout(HttpServletRequest request,HttpServletResponse response){
                //清除session
                UserContext.clearLoginUser();
                //清除服务器中的cookie数据
                Cookie cok = new Cookie(COOKIE_KEY,null);
                cok.setMaxAge(0);
                cok.setPath("/");
                response.addCookie(cok);
                //清除客户端中的cookie数据
                Cookie coksessionID = new Cookie("JSESSIONID",null);
                coksessionID.setMaxAge(0);
                coksessionID.setPath(request.getContextPath());
                response.addCookie(coksessionID);
        
                //跳转登录页面
                return "redirect:/main.do";
            }

## 登录成功-权限管理-左侧菜单展示功能
* 开发步骤：
    * 1：根据登录成功用户的角色ID，查询对应的菜单信息，参考第一天的sql语句
    * 2：首先查询一级菜单信息
    * 3：循环遍历一级菜单信息，查询当前一级菜单对应的二级菜单信息

* 示例代码：
    * UserLoginController.java:
    
            /**
            * 主页面
            * @param model
            * @return
            */
            @RequestMapping(value = "/main.do",method = RequestMethod.GET)
            public String main(Model model){
                if (UserContext.getLoginUser() != null) {
                    //根据当前登录用户的角色，查询当前角色对应的菜单信息
                    List<Menu> list = userService.queryMenusByRoleId(UserContext.getLoginUser().getRoleid().toString());
                    model.addAttribute("menus", list);
                    return JumpViewConstants.SYSTEM_INDEX;
                }
                return JumpViewConstants.SYSTEM_LOGIN;
            }


    * IUserService.java:
    
            /**
            * 根据角色主键ID，查询当前角色对应的菜单信息
            * @param roleId 角色主键ID
            * @return
            */
            public List<Menu> queryMenusByRoleId(String roleId);

    * UserServiceImpl.java:

            @Autowired
            IDataAccess<Menu> menuDao;
            public List<Menu> queryMenusByRoleId(String roleId) {
            
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("roleId", roleId);
                param.put("isparid", "true");//判断sql语句的标识，不封装到sql执行语句当中
                //只查询一级菜单信息
                List<Menu> list = menuDao.queryByStatment("queryMenusByRoleId", param, null);
                if (list != null &amp;&amp; list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        Long menuid = list.get(i).getMenuid();//一级菜单主键ID
                        param.clear();
                        param.put("roleId", roleId);
                        param.put("menuparaid", menuid);//将一级菜单ID，当做二级菜单的父ID
                        param.put("isparid", null);
                        List<Menu> listch = menuDao.queryByStatment("queryMenusByRoleId", param, null);
                        list.get(i).setChildren(listch);
                    }
                }
                return list;
            }

    * UserMapper.xml:

            <!-- 查询用户角色ID，查询菜单信息-->
            <select id="queryMenusByRoleId" parameterType="java.util.Map" resultType="com.hjcrm.system.entity.Menu">
                select 
                    rm.roleid,r.rolename,rm.menuid,m.menuname
                from hj_role_menu rm
                left join hj_role r on r.roleid = rm.roleid
                left join hj_menu m on m.menuid = rm.menuid
                <if test=" isparid != null and isparid !=''">
                    where rm.roleid = #{roleId} and m.menuparaid is null
                </if>
                 <if test=" isparid == null">
                    where rm.roleid = #{roleId} and m.menuparaid = #{menuparaid}
                </if>
            </select>


#### 页面展示：
![](https://i.imgur.com/tIbdpL5.png)
## 用户管理
### 页面跳转
* 开发步骤：
    * 1：通过前端找到接口地址
    * 2：为菜单的查询添加url的字段

* 示例代码：
    * UserController.java:

            /**
            * 跳转用户管理页面
            * @param model
            * @return
            */
            @RequestMapping(value = "/system/userMang.do",method = RequestMethod.GET)
            public String userManger(Model model){
                if (UserContext.getLoginUser() != null) {
                    return JumpViewConstants.SYSTEM_USER_MANAGE;
                }
                return JumpViewConstants.SYSTEM_LOGIN;
            }

### 列表查询
* 开发步骤：
    * 1：通过浏览器debug，获取接口地址（红色的404接口）
    * 2：支持分页查询

* 示例代码：
    * UserController.java:

            /**
            * 用户管理模块
            * @author likang
            * @date   2018-4-23 下午4:55:12
            */
            @Controller
            public class UserController extends BaseController{
            
            
                @Autowired
                private IUserService userService;
            
                /**
                 * 跳转用户管理页面
                 * @param model
                 * @return
                 */
                @RequestMapping(value = "/system/userMang.do",method = RequestMethod.GET)
                public String userManger(Model model){
                    if (UserContext.getLoginUser() != null) {
                        return JumpViewConstants.SYSTEM_USER_MANAGE;
                    }
                    return JumpViewConstants.SYSTEM_LOGIN;
                }
            
                /**
                 * 查询用户信息列表
                 * @param request
                 * @param currentPage
                 * @param pageSize
                 * @return
                 */
                @RequestMapping(value = "/system/userlist.do",method = RequestMethod.GET)
                public @ResponseBody String queryUserList(HttpServletRequest request,Integer currentPage,Integer pageSize){
                    List<User> list = userService.queryAllUser(processPageBean(pageSize, currentPage));
                    return jsonToPage(list);
                }
            }

    * IUserService.java:

            /**
            * 查询用户信息列表
            * @param pageBean
            * @return
            */
            public List<User> queryAllUser(PageBean pageBean);

    * UserServiceImpl.java:

            public List<User> queryAllUser(PageBean pageBean) {
                List<User> list = userDao.queryByStatment("queryAllUser", null, pageBean);
                return list;
            }

    * UserMapper.xml:

            <!-- 查询用户信息列表-->
            <select id="queryAllUser" parameterType="java.util.Map" resultType="com.hjcrm.system.entity.User">
                select
                    u.userid,u.username,u.email,u.roleid,u.deptid,u.ischange
                from hj_user u
            </select>

### 增加、修改
* 开发步骤：
    * 1：通过前端获取增加、修改的接口地址
    * 2：添加查询所有部门信息接口
    * 3：添加根据部门ID查询当前部门下所有角色信息的接口
    * 4：添加保存、修改的方法controller
    * 5：根据是否存在用户主键ID，来区分到底是修改还是增加
    * 6：增加和修改无需写sql语句

* 示例代码：
    * DeptController.java:

            /**
            * 部门管理模块
            * @author likang
            * @date   2018-4-24 上午9:06:29
            */
            @Controller
            public class DeptController extends BaseController{
            
                @Autowired
                private IDeptService deptService;
            
                /**
                 * 查询所有部门信息
                 * @param request
                 * @return
                 */
                @RequestMapping(value = "/dept/queryDept.do",method = RequestMethod.GET)
                public @ResponseBody String queryAllDepts(HttpServletRequest request){
                    List<Dept> list = deptService.queryAllDepts();
                    return jsonToPage(list);
                }
            
                /**
                 * 根据部门ID，查询当前部门下的角色信息列表
                 * @param request
                 * @param deptid 部门ID
                 * @return
                 */
                @RequestMapping(value = "/role/queryRoleByDeptid.do",method =RequestMethod.GET)
                public @ResponseBody String queryRolesByDeptId(HttpServletRequest request,String deptid){
                    List<Role> list = deptService.queryRolesByDeptId(deptid);
                    return jsonToPage(list);
                }
            }

    * IDeptService.java:

            /**
            * 部门信息接口
            * @author likang
            * @date   2018-4-24 上午9:08:04
            */
            public interface IDeptService {
            
                /**
                 * 查询所有的部门信息
                 * @return
                 */
                public List<Dept> queryAllDepts();
            
                /**
                 * 根据部门ID，查询角色信息
                 * @param deptid 部门ID
                 * @return
                 */
                public List<Role> queryRolesByDeptId(String deptid);
            }

    * DeptServiceImpl.java:

            @Service
            @Transactional(rollbackFor = Exception.class)
            public class DeptServiceImpl implements IDeptService{
            
                @Autowired
                IDataAccess<Dept> deptDao;
                @Autowired
                IDataAccess<Role> roleDao;
            
                public List<Dept> queryAllDepts() {
                    List<Dept> list = deptDao.queryByStatment("queryAllDepts", null, null);
                    return list;
                }
            
                public List<Role> queryRolesByDeptId(String deptid) {
                    Map<String, Object> param = new HashMap<String, Object>();
                    param.put("deptid", deptid);
                    List<Role> list = roleDao.queryByStatment("queryRolesByDeptId", param, null);
                    return list;
                }
            }

    * DeptMapper.xml:

            <mapper namespace="com.hjcrm.entity">
            
                <!-- 查询所有部门 -->
                <select id="queryAllDepts" parameterType="java.util.Map" resultType="com.hjcrm.system.entity.Dept">
                      select
                        d.deptid,d.deptname,d.deptparaid
                     from hj_dept d
                </select>
            
                <!-- 根据部门ID，查询角色信息 -->
                <select id="queryRolesByDeptId" parameterType="java.util.Map" resultType="com.hjcrm.system.entity.Role">
                       select
                        r.roleid,r.rolename,r.deptid
                     from hj_role r where r.deptid = #{deptid}
                </select>
            </mapper>

    * mybatis-config.xml:

            <mappers>
                <mapper resource="commonsqlmappings/CommonMapper.xml" />
                <mapper resource="mybatis/UserMapper.xml"/>
                <mapper resource="mybatis/DeptMapper.xml"/>
            </mappers>

    * UserController.java:

            /**
            * 增加\修改用户信息
            * @param request
            * @param user
            * @return
            */
            @RequestMapping(value = "/system/saveOrUpdate.do",method = RequestMethod.POST)
            public @ResponseBody String saveOrUpdateUser(HttpServletRequest request,User user){
                if (user != null) {
                    userService.saveOrUpdateUser(user);
                    return ReturnConstants.SUCCESS;
                }
                return ReturnConstants.PARAM_NULL;
            }

    * IUserService.java:

            /**
            * 增加、修改用户信息
            * @param user
            */
            public void saveOrUpdateUser(User user);
            </code></pre>
            
            <p>UserServiceImpl.java:</p>
            <pre><code>public void saveOrUpdateUser(User user) {
                if (user != null) {
                    if (user.getUserid() != null) {//修改
                        user.setUpdate_id(UserContext.getLoginUser().getUserid());
                        user.setUpdate_time(new Timestamp(System.currentTimeMillis()));
                        userDao.update(user);
                    }else{//增加
                        user.setCreate_id(UserContext.getLoginUser().getUserid());
                        user.setCreate_time(new Timestamp(System.currentTimeMillis()));
                        userDao.insert(user);
                    }
                }
            }

### 删除
* 开发步骤：
    * 1：通过前端找到删除的接口地址(支持批量删除，真正企业做的时候，接口是后台来定义)
    * 2：增加删除的接口和方法

* 示例代码：
    * UserController.java:

            /**
            * 删除用户信息，支持批量删除
            * @param request
            * @param ids 用户主键ID，多个用逗号隔开
            * @return
            */
            @RequestMapping(value = "/system/deleteUser.do",method = RequestMethod.POST)
            public @ResponseBody String deleteUsers(HttpServletRequest request,String ids){
                if (StringUtils.isNotBlank(ids)) {
                    userService.deleteUserByIds(ids);
                    return ReturnConstants.SUCCESS;
                }
                return ReturnConstants.PARAM_NULL;
            }

    * IUserService.java:

            /**
            * 删除用户信息，批量删除
            * @param ids 用户主键ID，多个用逗号隔开
            */
            public void deleteUserByIds(String ids);


    * UserServiceImpl.java:
    
            public void deleteUserByIds(String ids) {
                if (StringUtils.isNotBlank(ids)) {
                    userDao.deleteByIds(User.class, ids);
                }
            }

* 提示：
    * 1：回顾mysql的删除别名问题
    * 2：练习mybatis中的for标签

### 页面展示
![](https://i.imgur.com/rUyy9qq.png)

## 测试环境项目部署过程
* 系统环境：
    * linux-CentOS7

* 使用工具：
    * CRT\SCP

* 部署步骤：
    * 1：首先确认本地访问运行没有任何问题
    * 2：导出本地的数据库脚本，将脚本文件在虚拟机服务器的数据库中执行
    * 3：使用scp工具连接服务器，将本地tomcat的webapps目录下的项目，拖到虚拟机服务器tomcat的webapps目录下(可选：修改项目访问名称，ROOT在访问时，不需要输入)
    * 4：修改虚拟机服务器中项目的jdbc配置文件，修改为虚拟机数据库的连接信息
    * 5：使用crt工具，启动tomcat
    * 6：本地访问服务器项目信息

* 注意事项：
    * 1：本地连接服务器的数据库，需要开启3306端口号(防火墙允许3306端口允许)
    
            命令：/sbin/iptables -I INPUT -p tcp --dport 3306 -j ACCEPT

    * 2：需要开启tomcat访问的端口号，命令如下：
    
            /sbin/iptables -I INPUT -p tcp --dport 8080 -j ACCEPT

    * 3：如果新增增量补丁，如下地方是需要重启tomcat服务的
    
            - 接口代码
            - 配置文件、属性文件
            - xml对应的sql语句
            
    * 4：查看服务器mysql是否开启的命令
    
                ps -ef|grep mysql

<h2>菜单管理</h2>
<h3>跳转页面</h3>
<h3>查询</h3>
<h3>增加、修改</h3>
<h3>删除</h3>
<h2>角色管理</h2>
<h3>跳转页面</h3>
<h3>查询</h3>
<h3>增加、修改</h3>
<h3>删除</h3>
<h3>权限分配</h3>


