<h1>CentOS 7安装Mysql57数据库</h1>
<h2></h2>
<h2>软件要求</h2>
<p>虚拟机：VMware Workstation</p>
<p>系统版本：CentOS-7-x86_64(Linux)</p>
<p>Mysql版本：mysql57-community-release-el7-11.noarch.rpm</p>
<p>安装工具：SSH客户端</p>
<h3>安装步骤</h3>
<p>本教程，使用在线安装模式，请保持外网络畅通</p>
<ul>
<li>使用root用户登录系统，并切换到根目录</li>
<li>
<p>进入opt文件下，创建文件目录mysql57，并进入</p>
<p><img src="https://i.imgur.com/QU5UFmd.png" /></p>
</li>
<li>
<p>在/opt/mysql57/，目录下，输入命令,下载mysql的安装文件，使用rpm安装:</p>
<pre><code>wget http://repo.mysql.com/mysql57-community-release-el7-11.noarch.rpm
</code></pre>

<p><img src="https://i.imgur.com/HvfHdxN.png" /></p>
</li>
<li>
<p>如果提示wget命令未找到，则在保持外网网络畅通下执行命令：</p>
<pre><code>cd /
yum install wget -y
</code></pre>

<p><img src="https://i.imgur.com/s8CsVlR.png" /></p>
</li>
<li>
<p>再次切换到/opt/mysql57目录下，执行下载命令：</p>
<pre><code>wget http://repo.mysql.com/mysql57-community-release-el7-11.noarch.rpm
</code></pre>

<p><img src="https://i.imgur.com/o9r21mG.png" /></p>
</li>
<li>
<p>下载完毕之后，执行如下命令：</p>
<pre><code>sudo rpm -ivh mysql57-community-release-el7-11.noarch.rpm
</code></pre>

<p><img src="https://i.imgur.com/lQxSCVX.png" /></p>
</li>
<li>
<p>执行如下命令，安装mysql数据库</p>
<pre><code>sudo yum install mysql-server
</code></pre>

</li>
<li>
<p>安装过程中提示如下信息，输入y，然后回车即可</p>
<p><img src="https://i.imgur.com/ksVUtUm.png" />
<img src="https://i.imgur.com/PArCqHR.png" /></p>
</li>
<li>
<p>至此，mysql基本安装已经成功，接下来配置mysql一些相关信息</p>
<p><img src="https://i.imgur.com/cUzbBaD.png" /></p>
</li>
<li>
<p>输入如下命令，登录数据库客户端</p>
<pre><code>mysql -u root
</code></pre>

</li>
<li>
<p>提示如下信息：</p>
<p><img src="https://i.imgur.com/IRNEjaY.png" /></p>
</li>
<li>
<p>是因为此目录，没有对应的操作权限问题，执行如下命令修改目录权限</p>
<pre><code>sudo chown -R root:root /var/lib/mysql
</code></pre>

</li>
<li>
<p>重新启动数据库，执行如下命令：</p>
<pre><code>service mysqld restart
</code></pre>

</li>
<li>
<p>再次登录，执行如下命令：</p>
<pre><code>mysql -u root -p

初始化密码查看：

通过命令：more /var/log/mysqld.log   获取：1#;htwi(e&gt;Bw
</code></pre>

<p><img src="https://i.imgur.com/F9N9EkY.png" /></p>
</li>
<li>
<p>再次登录，执行如下命令：</p>
<pre><code>mysql -u root -p
</code></pre>

<p><img src="https://i.imgur.com/LOlyqVX.png" /></p>
</li>
<li>
<p>修改登录密码</p>
<p>alter user user() identified by 'Likang123qwe';</p>
</li>
<li>
<p>提示密码安全问题</p>
<p><img src="https://i.imgur.com/cHOUqCa.png" /></p>
</li>
<li>
<p>执行如下命令，修改密码安全策略后，再次修改密码</p>
<pre><code>set global validate_password_policy=0;
</code></pre>

<p><img src="https://i.imgur.com/1vArKJP.png" /></p>
</li>
<li>
<p>重启mysql数据库，测试密码登录</p>
<pre><code>service mysqld restart
</code></pre>

<p><img src="https://i.imgur.com/v5aUmxw.png" /></p>
</li>
<li>
<p>如果此时需要远程客户端访问数据库，则还需要进行如下配置</p>
<ul>
<li>
<p>开启3306默认端口，并保存</p>
<pre><code>/sbin/iptables -I INPUT -p tcp --dport 3306 -j ACCEPT
</code></pre>

</li>
<li>
<p>设置远程连接信息</p>
<pre><code>mysql -u root -p

use mysql;

update user set host='%' where user ='root' and host='localhost';

select host,user from user;

set global validate_password_policy=0;

grant all privileges on *.* to root@'%' identified by 'Likang123qwe' with grant option;
</code></pre>

</li>
<li>
<p>重启mysql服务</p>
<pre><code>service mysqld restart
</code></pre>

<p><img src="https://i.imgur.com/dxGAYO8.png" /></p>
</li>
</ul>
</li>
<li>
<p>取消mysql默认分区表、字段的大小写</p>
<pre><code>修改配置文件/etc/my.conf
lower_case_table_names=1  不区分大小写
lower_case_table_names=0  默认、区分大小写
</code></pre>

</li>
</ul>
