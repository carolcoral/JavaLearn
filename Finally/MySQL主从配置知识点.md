<h1>mysql主从知识点</h1>
<h2></h2>
<h2>主从形式</h2>
<p>mysql主从复制：</p>
<pre><code>一主一从
主主复制
一主多从---扩展系统读取的性能，因为读是在从库读取的；
多主一从---5.7开始支持
联级复制---
</code></pre>

<p><img src="https://i.imgur.com/IwW57O8.png" /></p>
<h2>用途及条件</h2>
<ul>
<li>
<p>mysql主从复制用途</p>
<pre><code>实时灾备，用于故障切换
读写分离，提供查询服务
备份，避免影响业务（备可用性和容错行）
负载平衡
</code></pre>

</li>
<li>
<p>主从部署必要条件：</p>
<pre><code>主库开启binlog日志（设置log-bin参数）
主从server-id不同
从库服务器能连通主库
</code></pre>

</li>
</ul>
<h2>主从原理</h2>
<p><img src="https://i.imgur.com/XsM4GXR.jpg" /></p>
<ul>
<li>从库生成两个线程，一个I/O线程，一个SQL线程；</li>
<li>I/O线程去请求主库 的binlog，并将得到的binlog日志写到relay log（中继日志） 文件中；</li>
<li>主库会生成一个 log dump 线程，用来给从库 i/o线程传binlog；</li>
<li>SQL 线程，会读取relay log文件中的日志，并解析成具体操作，来实现主从的操作一致,最终数据一致；</li>
</ul>


