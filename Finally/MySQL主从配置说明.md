<h1>Mysql主从配置</h1>
<h2></h2>
<h2>配置信息</h2>
<p>Mysql主服务器：</p>
<pre><code>版本：mysql  Ver 14.14 Distrib 5.7.20
IP:192.168.168.226
PORT:3306
</code></pre>

<p>Mysql从服务器</p>
<pre><code>版本：mysql  Ver 14.14 Distrib 5.7.20
IP:192.168.168.227
PORT:3306
</code></pre>

<p>服务器：</p>
<pre><code>CentOS 7
</code></pre>

<h2>搭建步骤</h2>
<ul>
<li>
<p>登录主服务器，执行如下命令：</p>
<pre><code>mysql -u root -p

提示密码安全策略问题：
set global validate_password_policy=0;

grant replication slave on *.* TO 'backup'@'192.168.168.227' identified by 'Likang123qwe';
flush privileges
</code></pre>

<p><img src="https://i.imgur.com/LzUgxNQ.png" /></p>
</li>
<li>
<p>编辑主服务器的数据库配置文件信息my.cnf</p>
<pre><code>vi /etc/my.cnf

添加如下信息：
    server-id=226
    log_bin=/var/log/mysql/mysql-bin.log
    read-only=0
    binlog-do-db=test
    binlog-ignore-db=mysql
</code></pre>

<p><img src="https://i.imgur.com/eKY0oGa.png" /></p>
</li>
<li>
<p>登录从服务器，执行如下命令：</p>
<pre><code>编辑从服务器的数据库配置文件信息：my.cnf

vi /etc/my.cnf

server-id=227
log_bin=/var/log/mysql/mysql-bin.log
</code></pre>

<p><img src="https://i.imgur.com/7UeDeiR.png" /></p>
</li>
<li>
<p>重启主服务器</p>
<pre><code>service mysqld restart

提示如下信息：
</code></pre>

<p><img src="https://i.imgur.com/az2ivQJ.png" /></p>
<pre><code>修改：

进入/var/log/文件夹下，新建文件mysql，进入mysql目录，新建文件mysql-bin.log文件，并赋予读写权限(mysql和mysql-bin.log)
</code></pre>

</li>
<li>
<p>登录主服务器，查看master状态</p>
<pre><code>show master status\G;
</code></pre>

<p><img src="https://i.imgur.com/AwcRuJm.png" /></p>
</li>
<li>
<p>登录从服务器，设置主从关系</p>
<pre><code>change master to master_host='192.168.168.226',master_user='backup',master_password='Likang123qwe',master_log_file='mysql-bin.000001',master_log_pos=154;
</code></pre>

<p><img src="https://i.imgur.com/AjUPg8I.png" /></p>
</li>
<li>
<p>查看从服务器的主从关系状态</p>
<pre><code>show slave status\G;
</code></pre>

</li>
<li>
<p>主服务器下执行</p>
<pre><code>/sbin/iptables -I INPUT -p tcp --dport 3306 -j ACCEPT
</code></pre>

</li>
<li>
<p>从服务器下执行</p>
<pre><code>/sbin/iptables -I INPUT -p tcp --dport 3306 -j ACCEPT
</code></pre>

</li>
<li>
<p>如果主从库中不存在test库，则需要重新建库，然后重启，重新构建主从关系</p>
</li>
<li>
<p>从服务器下</p>
<pre><code> Slave_IO_Running: Yes
 Slave_SQL_Running: Yes
</code></pre>

<p>如果都为yes，则主从搭建成功</p>
</li>
</ul>
<h3>至此，mysql主从配置成功</h3>
<hr />
