<h1>Linux下如何安装Nginx</h1>
<h2></h2>
<h2>软件环境</h2>
<pre><code>虚拟机：VMware Workstation

系统：Linux：CentOS-7-x86_64
</code></pre>

<h2>工具</h2>
<pre><code>安装工具：SSH客户端
</code></pre>

<h2>安装步骤</h2>
<h3>安装前环境准备</h3>
<p>1：安装wget,用来下载nginx安装包</p>
<pre><code>cd /
yum install wget -y
</code></pre>

<p><img src="https://i.imgur.com/ZsQSHBh.png" /></p>
<p>2：因为Nginx以来与gcc的编译环境，所以，在mini centos中需要安装编译环境来使Nginx能够编译起来</p>
<pre><code>yum install gcc-c++
</code></pre>

<p><img src="https://i.imgur.com/6baQ1I5.png" />
<img src="https://i.imgur.com/cyWfDAX.png" />
<img src="https://i.imgur.com/4XgSmX6.png" /></p>
<p>3：Nginx的http模块需要使用pcre来解析正则表达式</p>
<pre><code>yum -y install pcre pcre-devel
</code></pre>

<p><img src="https://i.imgur.com/LJNUonv.png" /></p>
<p>4：依赖的解压包</p>
<pre><code>yum -y install zlib zlib-devel
</code></pre>

<p><img src="https://i.imgur.com/X32CHAm.png" /></p>
<p>5：openssl安装</p>
<pre><code>yum install -y openssl openssl-devel
</code></pre>

<p><img src="https://i.imgur.com/gOLTugJ.png" />
<img src="https://i.imgur.com/z04nCiJ.png" /></p>
<p>6：官网下载 http://nginx.org/en/download.html  找到自己需要的版本下载(以下为最新版本)</p>
<pre><code>切换到opt目录下，新建文件夹nginx，然后进入nginx文件夹
</code></pre>

<p><img src="https://i.imgur.com/ol61CN1.png" /></p>
<pre><code>执行如下命令：

wget  http://nginx.org/download/nginx-1.13.11.tar.gz
</code></pre>

<p><img src="https://i.imgur.com/gyOSqOy.png" /></p>
<h2>安装nginx</h2>
<p>1：解决nginx文件</p>
<pre><code>tar zxvf nginx-1.13.11.tar.gz
</code></pre>

<p><img src="https://i.imgur.com/9VuZ2PU.png" /></p>
<p>2：编译，安装</p>
<pre><code>先切换到opt目录下，新建文件夹nginx-1-13
</code></pre>

<p><img src="https://i.imgur.com/gucW8oC.png" /></p>
<pre><code>cd nginx-1.13.11
./configure  --prefix=/opt/nginx-1-13      #指定安装目录
</code></pre>

<p><img src="https://i.imgur.com/DDQjIL0.png" />
<img src="https://i.imgur.com/k3rngpT.png" /></p>
<p>3：在/opt/nginx/nginx-1.13.11目录下执行编译命令</p>
<pre><code>make
</code></pre>

<p><img src="https://i.imgur.com/fGWWcl5.png" /></p>
<p><img src="https://i.imgur.com/R88h3sR.png" /></p>
<p>4:执行安装命令</p>
<pre><code>make install
</code></pre>

<p><img src="https://i.imgur.com/ol76fNv.png" /></p>
<p>5:切换到安装目录</p>
<pre><code>cd /opt/nginx-1-13
</code></pre>

<p><img src="https://i.imgur.com/Ah2DG38.png" /></p>
<p>6:启动</p>
<pre><code>cd sbin/

./nginx 
./nginx -s stop
./nginx -s quit
./nginx -s reload
./nginx -s quit:此方式停止步骤是待nginx进程处理任务完毕进行停止。
./nginx -s stop:此方式相当于先查出nginx进程id再使用kill命令强制杀掉进程。
</code></pre>

<p><img src="https://i.imgur.com/F8raCIt.png" /></p>
<p>7：开放nginx默认端口号80</p>
<pre><code>/sbin/iptables -I INPUT -p tcp --dport 80 -j ACCEPT
</code></pre>

<p>8：远程访问测试</p>
<p><img src="https://i.imgur.com/vMCyHIa.png" /></p>
<h3>至此，linux下安装nginx成功，并可以远程访问</h3>
