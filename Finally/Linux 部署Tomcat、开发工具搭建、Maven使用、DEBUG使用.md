## linux系统下部署tomcat
### 前提

    必须首先配置JAVA环境
    查看是否配置java环境的命令：
        java -version
    如果显示java的版本信息，则代表配置java环境成功，如何没有任何显示或者错误显示，则需要参照第一天的《linux系统下配置java环境》文件，进行配置

### 部署

* 1：通过SCP将tomcat拖拽到服务器中
<p><img src="https://i.imgur.com/i3RYXMY.png" /></p>
* 2：进入到tomcat的bin目录，ctrl+A，全选授权
<p><img src="https://i.imgur.com/qdB5A3G.png" /></p>
* 3：暂时可以清除webapps目录下和logs目录下的所有文件

### 启动

* 进入到tomcat的bin目录，执行如下命令

            ./startup.sh
    
* 查看是否启动成功有两种方式：

            - 查看启动日志，没有报错并且出现耗时多长时间，即可
                cd ..
                cd logs
                tail -n -200 -f catalina.out
            - 查看tomcat进程信息
                ps -ef|grep tomcat
                
<p><img src="https://i.imgur.com/CbjPrzE.png" /></p>

### 停止

* 停止tomcat有两种方式：

    1：使用命令停止，如下
    
        首先切换到bin目录，执行：
        ./shutdown.sh
<p><img src="https://i.imgur.com/uAhF8jM.png" /></p>
    
    2：杀死进程停止tomcat
        kill -9 进程号
        
    验证是否停止成功，可以使用查看tomcat进程命令，如果显示如下，则代表停止成功。
<p><img src="https://i.imgur.com/pt6dHEs.png" /></p>

## 开发工具搭建

### 配置JDK

* 参考下图
<p><img src="https://i.imgur.com/rpoWPvN.gif" /></p>

### 配置Tomcat

        tomcat是一款开源的项目应用服务器，目前已经更新到tomcat9版本，从tomcat7以后，新增支持基于协议的长连接websocket功能(比较耗费服务器资源)



* 目录说明

<p><img src="https://i.imgur.com/s64PvIj.png" /></p>

* myeclipse中配置tomcat步骤，参考下图：

<p><img src="https://i.imgur.com/00bAIoi.gif" /></p>

### 配置Maven

* 1：命令行

        mvn test 测试命令
        
        mvn bulid 构建命令----不会生成war、jar包到中央仓库
        
        mvn clear 清除命令
        
        mvn install 初始化构建命令---会生成war、jar包到中央仓库

* 2：将maven配置到开发工具中

    eg：eclipse\myeclipse\IDEA等



* myeclipse中配置maven步骤，参考下图：

<p><img src="https://i.imgur.com/VEUekfJ.gif" /></p>

### 开发工具快捷键

        ctrl+N：新建
        
        ctrl+1：提示错误信息
        
        ctrl+D：删除
        
        ctrl+/：行注释
        
        ctrl+\：取消行注释
        
        ctrl+shift+/：代码段注释
        
        ctrl+shift+\：取消代码段注释
        
        ctrl+H：快速查找任何文件信息、字符信息
        
        ctrl+shift+O：导包
        
        ctrl+T：查找类(支持模糊查找)
        
        ctrl+R：查找文件（支持模糊查找、支持资源文件查找）
        
        ctrl+shift+I：debug模式下，查看当前执行代码信息
        
        ctrl+G：定位文件(不常用)



### DEBUG模式快捷键

        F5：进入到方法内
        
        F6：执行下一步
        
        F7：跳出方法外
        
        F8：执行到下一个断点

