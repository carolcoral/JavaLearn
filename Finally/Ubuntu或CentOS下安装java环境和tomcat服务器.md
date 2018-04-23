# Tomcat在 CentOS 和 Ubuntu 中的安装配置

1.首先检查并安装 java 环境
>java -version
* 如果有 java 环境但是并不是我们需要的，例如 openjdk，可以使用下面的命令移除
>sudo apt-get remove openjdk*

2.安装 wget 工具
> *Ubuntu
>sudo apt-get install wget
> *CentOS
>yum install wget

3.使用 wget 安装 java 环境（这里安装的是 jdk1.8 版本，根据个人需要可以去官网复制不同的下载链接）
> wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u171-b11/512cd62ec5174c3487ac17c61aaa89e8/jdk-8u171-linux-x64.rpm"

> rpm 文件请使用 rpm -ivh ...rpm 来操作

4.解压 java 压缩包并移动文件到新创建的文件夹中
>mkdir /home/java/
>tar -zxvf jdk1.8.0_161.tar.gz /home/java

5.安装完成后使用，出现下面的内容即是安装成功
>ubuntu@VM-0-15-ubuntu:~$ java -version
```java version "1.8.0_161"
Java(TM) SE Runtime Environment (build 1.8.0_161-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.161-b12, mixed mode)```

6.配置 java 的环境变量

打开 /etc/environment文件
>vim /etc/environment
添加下面的句子
```PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:$JAVA_HOME/bin"
export CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/jre/lib
export JAVA_HOME=/home/java/jdk1.8.0_161```
其中 java_home 的路径就是你安装 jdk 的路径

打开 /etc/profile 文件，在最末尾加上这段话并保存
```#set Java enviroment
export JAVA_HOME=/home/java/jdk1.8.0_161
export JRE_HOME=$JAVA_HOME/jre
export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib:$CLASSPATH
export PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$PATH```

重启服务
>source /etc/environment
>source /etc/profile

7.在官网下好需要的 tomcat 安装包，我这里下载的是 tomcat8.5，然后解压到新建的文件夹中
>tar -zxvf apache-tomcat-8.5.30.tar.gz /usr/local/

8.因为我们是要做分布式集群的服务，所以就不配置环境变量了

9.启动和关闭 tomcat 服务器
>/usr/local/apache-tomcat-8.5.30/bin/startup.sh
>/usr/local/apache-tomcat-8.5.30/bin/shutdown.sh

10.修改 tomcat 默认端口，把里面的端口都修改下就行了，如果仅有一个 tomcat 服务器就只需要修改 connection 的8080端口就行了
>vim /usr/local/apache-tomcat-8.5.30/conf/service.xml


