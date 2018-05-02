
	
<div id="post_detail">
	<div class="post">
		<h2>
			<a id="cb_post_title_url" href="http://www.cnblogs.com/wuxl360/p/5920330.html">Redis集群搭建与简单使用</a>
		</h2>
		<div class="postText"><div id="cnblogs_post_body" class="blogpost-body"><p class="second"><span style="background-color: #ff0000;">介绍安装环境与版本</span></p>
<p>用两台虚拟机模拟6个节点，一台机器3个节点，创建出3 master、3 salve 环境。</p>
<p>redis 采用 redis-3.2.4 版本。</p>
<p>两台虚拟机都是 CentOS ，一台 CentOS6.5 （IP:192.168.31.245），一台 CentOS7（IP:192.168.31.210） 。</p>
<p class="second">安装过程</p>
<p>1. 下载并解压</p>
<div class="cnblogs_code">
<pre>
<div class="line number1 index0 alt2"><code class="bash functions">cd</code> <code class="bash plain">/root/software</code></div>
<div class="line number2 index1 alt1"><code class="bash plain">wget http:</code><code class="bash plain">//download</code><code class="bash plain">.redis.io</code><code class="bash plain">/releases/redis-3</code><code class="bash plain">.2.4.</code><code class="bash functions">tar</code><code class="bash plain">.gz</code></div>
<div class="line number2 index1 alt1"><span style="color: #008000;"><code class="bash functions">tar</code> <code class="bash plain">-zxvf redis-3.2.4.</code><code class="bash functions">tar</code><code class="bash plain">.gz　</code><br /></span></div>
</div></pre>
<p>2. 编译安装</p>
<div class="cnblogs_code">
<pre>cd redis-<span style="color: #800080;">3.2</span>.<span style="color: #800080;">4</span><span style="color: #000000;">
make </span>&amp;&amp; make install</pre>
</div>
<p>3.&nbsp;将 redis-trib.rb 复制到 /usr/local/bin 目录下</p>
<div class="cnblogs_code">
<pre><span style="color: #000000;">cd src
cp redis</span>-trib.rb /usr/local/bin/　　</pre>
</div>
<p class="third">4. 创建 Redis 节点</p>
<p>首先在&nbsp;192.168.31.245 机器上 /root/software/redis-3.2.4 目录下创建&nbsp;redis_cluster 目录；</p>
<div class="cnblogs_code">
<pre>mkdir redis_cluster　　</pre>
</div>
<p>在&nbsp;redis_cluster 目录下，创建名为7000、7001、7002的目录，并将 redis.conf 拷贝到这三个目录中 </p>
<div class="cnblogs_code">
<pre>mkdir <span style="color: #800080;">7000</span> <span style="color: #800080;">7001</span> <span style="color: #800080;">7002</span>&lt;br&gt;cp redis.conf redis_cluster/<span style="color: #800080;">7000</span><span style="color: #000000;">
cp redis.conf redis_cluster</span>/<span style="color: #800080;">7001</span><span style="color: #000000;">
cp redis.conf redis_cluster</span>/<span style="color: #800080;">7002</span>　　</pre>
</div>
<p>分别修改这三个配置文件，修改如下内容</p>
<div class="cnblogs_code">
<pre>port  <span style="color: #800080;">7000</span>                                        <span style="color: #008000;">//</span><span style="color: #008000;">端口7000,7002,7003        </span>
bind 本机ip                                       <span style="color: #008000;">//</span><span style="color: #008000;">默认ip为127.0.0.1 需要改为其他节点机器可访问的ip 否则创建集群时无法访问对应的端口，无法创建集群</span>
daemonize    yes                               <span style="color: #008000;">//</span><span style="color: #008000;">redis后台运行</span>
pidfile  /<span style="color: #0000ff;">var</span>/run/redis_7000.pid          <span style="color: #008000;">//</span><span style="color: #008000;">pidfile文件对应7000,7001,7002</span>
cluster-enabled  yes                           <span style="color: #008000;">//</span><span style="color: #008000;">开启集群  把注释#去掉</span>
cluster-config-file  nodes_7000.conf   <span style="color: #008000;">//</span><span style="color: #008000;">集群的配置  配置文件首次启动自动生成 7000,7001,7002</span>
cluster-node-timeout  <span style="color: #800080;">15000</span>                <span style="color: #008000;">//</span><span style="color: #008000;">请求超时  默认15秒，可自行设置</span>
appendonly  yes                           <span style="color: #008000;">//</span><span style="color: #008000;">aof日志开启  有需要就开启，它会每次写操作都记录一条日志　</span></pre>
</div>
<ul>
<li>接着在另外一台机器上（192.168.31.210），的操作重复以上三步，只是把目录改为7003、7004、7005，对应的配置文件也按照这个规则修改即可</li>
</ul>
<p>5. 启动各个节点</p>
<div class="cnblogs_code">
<pre><span style="color: #000000;">第一台机器上执行
redis</span>-server redis_cluster/<span style="color: #800080;">7000</span>/<span style="color: #000000;">redis.conf
redis</span>-server redis_cluster/<span style="color: #800080;">7001</span>/<span style="color: #000000;">redis.conf
redis</span>-server redis_cluster/<span style="color: #800080;">7002</span>/<span style="color: #000000;">redis.conf
 
另外一台机器上执行
redis</span>-server redis_cluster/<span style="color: #800080;">7003</span>/<span style="color: #000000;">redis.conf
redis</span>-server redis_cluster/<span style="color: #800080;">7004</span>/<span style="color: #000000;">redis.conf
redis</span>-server redis_cluster/<span style="color: #800080;">7005</span>/redis.conf </pre>
</div>
<p>6. 检查 redis 启动情况</p>
<div class="cnblogs_code">
<pre>##一台机器&lt;br&gt;ps -ef |<span style="color: #000000;"> grep redis
root      </span><span style="color: #800080;">61020</span>      <span style="color: #800080;">1</span>  <span style="color: #800080;">0</span> <span style="color: #800080;">02</span>:<span style="color: #800080;">14</span> ?        <span style="color: #800080;">00</span>:<span style="color: #800080;">00</span>:<span style="color: #800080;">01</span> redis-server <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">7000</span><span style="color: #000000;"> [cluster]    
root      </span><span style="color: #800080;">61024</span>      <span style="color: #800080;">1</span>  <span style="color: #800080;">0</span> <span style="color: #800080;">02</span>:<span style="color: #800080;">14</span> ?        <span style="color: #800080;">00</span>:<span style="color: #800080;">00</span>:<span style="color: #800080;">01</span> redis-server <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">7001</span><span style="color: #000000;"> [cluster]    
root      </span><span style="color: #800080;">61029</span>      <span style="color: #800080;">1</span>  <span style="color: #800080;">0</span> <span style="color: #800080;">02</span>:<span style="color: #800080;">14</span> ?        <span style="color: #800080;">00</span>:<span style="color: #800080;">00</span>:<span style="color: #800080;">01</span> redis-server <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">7002</span><span style="color: #000000;"> [cluster]    
 
netstat </span>-tnlp |<span style="color: #000000;"> grep redis
tcp        </span><span style="color: #800080;">0</span>      <span style="color: #800080;">0</span> <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">17000</span>             <span style="color: #800080;">0.0</span>.<span style="color: #800080;">0.0</span>:*                   LISTEN      <span style="color: #800080;">61020</span>/redis-<span style="color: #000000;">server 
tcp        </span><span style="color: #800080;">0</span>      <span style="color: #800080;">0</span> <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">17001</span>             <span style="color: #800080;">0.0</span>.<span style="color: #800080;">0.0</span>:*                   LISTEN      <span style="color: #800080;">61024</span>/redis-<span style="color: #000000;">server 
tcp        </span><span style="color: #800080;">0</span>      <span style="color: #800080;">0</span> <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">17002</span>             <span style="color: #800080;">0.0</span>.<span style="color: #800080;">0.0</span>:*                   LISTEN      <span style="color: #800080;">61029</span>/redis-<span style="color: #000000;">server 
tcp        </span><span style="color: #800080;">0</span>      <span style="color: #800080;">0</span> <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">7000</span>              <span style="color: #800080;">0.0</span>.<span style="color: #800080;">0.0</span>:*                   LISTEN      <span style="color: #800080;">61020</span>/redis-<span style="color: #000000;">server 
tcp        </span><span style="color: #800080;">0</span>      <span style="color: #800080;">0</span> <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">7001</span>              <span style="color: #800080;">0.0</span>.<span style="color: #800080;">0.0</span>:*                   LISTEN      <span style="color: #800080;">61024</span>/redis-<span style="color: #000000;">server 
tcp        </span><span style="color: #800080;">0</span>      <span style="color: #800080;">0</span> <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">7002</span>              <span style="color: #800080;">0.0</span>.<span style="color: #800080;">0.0</span>:*                   LISTEN      <span style="color: #800080;">61029</span>/redis-<span style="color: #000000;">server
</span><span style="color: #800080;">1</span>
<span style="color: #800080;">2</span>
<span style="color: #800080;">3</span>
<span style="color: #800080;">4</span>
<span style="color: #800080;">5</span>
<span style="color: #800080;">6</span>
<span style="color: #800080;">7</span>
<span style="color: #800080;">8</span>
<span style="color: #800080;">9</span>
<span style="color: #800080;">10</span>
<span style="color: #800080;">11</span>
<span style="color: #800080;">12</span>
<span style="color: #800080;">13</span><span style="color: #000000;">
    
##另外一台机器
ps </span>-ef |<span style="color: #000000;"> grep redis
root       </span><span style="color: #800080;">9957</span>      <span style="color: #800080;">1</span>  <span style="color: #800080;">0</span> <span style="color: #800080;">02</span>:<span style="color: #800080;">32</span> ?        <span style="color: #800080;">00</span>:<span style="color: #800080;">00</span>:<span style="color: #800080;">01</span> redis-server <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">7003</span><span style="color: #000000;"> [cluster]
root       </span><span style="color: #800080;">9964</span>      <span style="color: #800080;">1</span>  <span style="color: #800080;">0</span> <span style="color: #800080;">02</span>:<span style="color: #800080;">32</span> ?        <span style="color: #800080;">00</span>:<span style="color: #800080;">00</span>:<span style="color: #800080;">01</span> redis-server <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">7004</span><span style="color: #000000;"> [cluster]
root       </span><span style="color: #800080;">9971</span>      <span style="color: #800080;">1</span>  <span style="color: #800080;">0</span> <span style="color: #800080;">02</span>:<span style="color: #800080;">32</span> ?        <span style="color: #800080;">00</span>:<span style="color: #800080;">00</span>:<span style="color: #800080;">01</span> redis-server <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">7005</span><span style="color: #000000;"> [cluster]
root      </span><span style="color: #800080;">10065</span>   <span style="color: #800080;">4744</span>  <span style="color: #800080;">0</span> <span style="color: #800080;">02</span>:<span style="color: #800080;">38</span> pts/<span style="color: #800080;">0</span>    <span style="color: #800080;">00</span>:<span style="color: #800080;">00</span>:<span style="color: #800080;">00</span> grep --color=<span style="color: #000000;">auto redis
netstat </span>-tlnp |<span style="color: #000000;"> grep redis
tcp        </span><span style="color: #800080;">0</span>      <span style="color: #800080;">0</span> <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">17003</span>         <span style="color: #800080;">0.0</span>.<span style="color: #800080;">0.0</span>:*               LISTEN      <span style="color: #800080;">9957</span>/redis-server <span style="color: #800080;">1</span><span style="color: #000000;">
tcp        </span><span style="color: #800080;">0</span>      <span style="color: #800080;">0</span> <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">17004</span>         <span style="color: #800080;">0.0</span>.<span style="color: #800080;">0.0</span>:*               LISTEN      <span style="color: #800080;">9964</span>/redis-server <span style="color: #800080;">1</span><span style="color: #000000;">
tcp        </span><span style="color: #800080;">0</span>      <span style="color: #800080;">0</span> <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">17005</span>         <span style="color: #800080;">0.0</span>.<span style="color: #800080;">0.0</span>:*               LISTEN      <span style="color: #800080;">9971</span>/redis-server <span style="color: #800080;">1</span><span style="color: #000000;">
tcp        </span><span style="color: #800080;">0</span>      <span style="color: #800080;">0</span> <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">7003</span>          <span style="color: #800080;">0.0</span>.<span style="color: #800080;">0.0</span>:*               LISTEN      <span style="color: #800080;">9957</span>/redis-server <span style="color: #800080;">1</span><span style="color: #000000;">
tcp        </span><span style="color: #800080;">0</span>      <span style="color: #800080;">0</span> <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">7004</span>          <span style="color: #800080;">0.0</span>.<span style="color: #800080;">0.0</span>:*               LISTEN      <span style="color: #800080;">9964</span>/redis-server <span style="color: #800080;">1</span><span style="color: #000000;">
tcp        </span><span style="color: #800080;">0</span>      <span style="color: #800080;">0</span> <span style="color: #800080;">127.0</span>.<span style="color: #800080;">0.1</span>:<span style="color: #800080;">7005</span>          <span style="color: #800080;">0.0</span>.<span style="color: #800080;">0.0</span>:*               LISTEN      <span style="color: #800080;">9971</span>/redis-server <span style="color: #800080;">1</span> </pre>
</div>
<p class="third">7.创建集群</p>
<p>Redis 官方提供了 redis-trib.rb 这个工具，就在解压目录的 src 目录中，第三步中已将它复制到 /usr/local/bin 目录中，可以直接在命令行中使用了。使用下面这个命令即可完成安装。</p>
<div class="cnblogs_code">
<pre>redis-trib.rb  create  --replicas  <span style="color: #800080;">1</span>  <span style="color: #800080;">192.168</span>.<span style="color: #800080;">31.245</span>:<span style="color: #800080;">7000</span> <span style="color: #800080;">192.168</span>.<span style="color: #800080;">31.245</span>:<span style="color: #800080;">7001</span>  <span style="color: #800080;">192.168</span>.<span style="color: #800080;">31.245</span>:<span style="color: #800080;">7002</span> <span style="color: #800080;">192.168</span>.<span style="color: #800080;">31.210</span>:<span style="color: #800080;">7003</span>  <span style="color: #800080;">192.168</span>.<span style="color: #800080;">31.210</span>:<span style="color: #800080;">7004</span>  <span style="color: #800080;">192.168</span>.<span style="color: #800080;">31.210</span>:<span style="color: #800080;">7005</span></pre>
</div>
<p>其中，前三个 ip:port 为第一台机器的节点，剩下三个为第二台机器。</p>
<p>等等，出错了。这个工具是用 ruby 实现的，所以需要安装 ruby。安装命令如下：</p>
<div class="line number1 index0 alt2"><code class="bash plain">yum -y </code><code class="bash functions">install</code> <code class="bash plain">ruby ruby-devel rubygems rpm-build </code></div>
<p><code class="bash plain">gem </code><code class="bash functions">install</code> <code class="bash plain">redis </code></p>
<p>之后再运行 redis-trib.rb 命令，会出现如下提示：</p>
<p><img src="https://images2015.cnblogs.com/blog/273364/201609/273364-20160929150634344-1055901726.jpg" alt="" /></p>
<p>输入 yes 即可，然后出现如下内容，说明安装成功。</p>
<p><img src="https://images2015.cnblogs.com/blog/273364/201609/273364-20160929150720000-1999293873.jpg" alt="" />　　</p>
<p class="third">8. 集群验证</p>
<p>在第一台机器上连接集群的7002端口的节点，在另外一台连接7005节点，连接方式为&nbsp;<span class="cnblogs_code">redis-cli -h <span style="color: #800080;">192.168.<span style="color: #800080;">31.245 -c -p <span style="color: #800080;">7002&nbsp; ,加参数 -C 可连接到集群，因为上面 redis.conf 将 bind 改为了ip地址，所以 -h 参数不可以省略。</span></span></span></span></p>
<p>在7005节点执行命令 &nbsp;<span class="cnblogs_code">set hello world&nbsp;，执行结果如下：</span></p>
<p><img src="https://images2015.cnblogs.com/blog/273364/201609/273364-20160929152337688-1332730145.jpg" alt="" />&nbsp;</p>
<p>然后在另外一台7002端口，查看 key 为 hello 的内容，&nbsp;<span class="cnblogs_code">get hello&nbsp; ，执行结果如下：</span></p>
<p><img src="https://images2015.cnblogs.com/blog/273364/201609/273364-20160929152449688-978685655.jpg" alt="" /></p>
<p>说明集群运作正常。</p>
<p class="second">简单说一下原理</p>
<p data-anchor-id="j5sq">redis cluster在设计的时候，就考虑到了去中心化，去中间件，也就是说，集群中的每个节点都是平等的关系，都是对等的，每个节点都保存各自的数据和整个集群的状态。每个节点都和其他所有节点连接，而且这些连接保持活跃，这样就保证了我们只需要连接集群中的任意一个节点，就可以获取到其他节点的数据。</p>
<p data-anchor-id="14v6">Redis 集群没有并使用传统的一致性哈希来分配数据，而是采用另外一种叫做<code>哈希槽 (hash slot)</code>的方式来分配的。redis cluster 默认分配了 16384 个slot，当我们set一个key 时，会用<code>CRC16</code>算法来取模得到所属的<code>slot</code>，然后将这个key 分到哈希槽区间的节点上，具体算法就是：<code>CRC16(key) % 16384。所以我们在测试的时候看到set 和 get 的时候，直接跳转到了7000端口的节点。</code></p>
<p data-anchor-id="n789">Redis 集群会把数据存在一个 master 节点，然后在这个 master 和其对应的salve 之间进行数据同步。当读取数据时，也根据一致性哈希算法到对应的 master 节点获取数据。只有当一个master 挂掉之后，才会启动一个对应的 salve 节点，充当 master 。</p>
<p data-anchor-id="n789">需要注意的是：必须要<code>3个或以上</code>的主节点，否则在创建集群时会失败，并且当存活的主节点数小于总节点数的一半时，整个集群就无法提供服务了。</p>
<p data-anchor-id="6uac">&nbsp;</p>
