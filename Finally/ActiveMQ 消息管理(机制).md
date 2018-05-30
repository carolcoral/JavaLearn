<h1>ActiveMQ 消息管理(机制)</h1>
<h2>ActiveMQ简介</h2>
<pre><code>ActiveMQ 是Apache出品，最流行的，能力强劲的开源消息总线。ActiveMQ 是一个完全支持JMS1.1和J2EE 1.4规范的 JMS Provider实现.
</code></pre>

<h2>JMS 简介</h2>
<ul>
<li>JMS（Java Message Service），即：java消息服务应用程序接口。</li>
<li>是Java平台面向消息中间件（MOM）的API/技术规范。</li>
<li>场景：应用与两个应用程序之间，或者分布式系统架构中分发消息，可进行异步/同步方式的通讯，和平台API无关，基本多数的MOM都提供对JMS的支持</li>
</ul>
<h2>JMS 体系架构</h2>
<ul>
<li>
<p>JMS提供者</p>
<p>连接面向消息中间件的，JMS接口的一个实现。提供者可以是Java平台的JMS实现，也可以是非Java平台的面向消息中间件的适配器。</p>
</li>
<li>
<p>JMS客户</p>
<p>生产或消费基于消息的Java的应用程序或对象。</p>
</li>
<li>
<p>JMS生产者</p>
<p>创建并发送消息的JMS客户。</p>
</li>
<li>
<p>JMS消费者</p>
<p>接收消息的JMS客户。</p>
</li>
<li>
<p>JMS消息</p>
<p>包括可以在JMS客户之间传递的数据的对象。</p>
</li>
<li>
<p>JMS队列</p>
<p>一个容纳那些被发送的等待阅读的消息的区域。与队列名字所暗示的意思不同，消息的接受顺序并不一定要与消息的发送顺序相同。一旦一个消息被阅读，该消息将被从队列中移走。</p>
</li>
<li>
<p>JMS主题</p>
<p>一种支持发送消息给多个订阅者的机制。</p>
</li>
</ul>
<h2>JMS 属性</h2>
<ul>
<li>Destination（接口/目标）</li>
<li>Product（生产者）</li>
<li>Consumer（消费者）</li>
<li>Broker（消息转发器）</li>
<li>P2P,Pub/Sub（模型）</li>
<li>
<p>P2P:消息队列(Queue)、发送者(Sender)、接收者(Receiver)</p>
<pre><code>Pub/Sub:主题（Topic）、发布者（Publisher）、订阅者（Subscriber）
</code></pre>

</li>
</ul>
<h2>ActiveMQ与JMS关系</h2>
<pre><code>JMS是一种规范
ActiveMQ是JMS规范的一种实现
</code></pre>

<h2>AvtiveMQ架构图</h2>
<p><img src="https://i.imgur.com/mzUhUiG.png" /></p>
<h2>ActiveMQ主要特性</h2>
<pre><code>(1)JMS1.1、J2EE1.4
(2)J2EE servers(Tomcat,JBoss4,GlassFish,WebLogic…)
(3)多语言客户端（Java,C,C++,C#,Ruby,PhP）
(4)多种协议(VM,TCP,SSL,UDP,multicast,JGroups…)
(5)Spring
(6)Ajax
(7)CXF,Axis（WebService的两个流行的框架）
(8)REST（状态传递）
(9)Message Groups,Virtual Destinations,Wildcards,Composite ， Destinations
(10)持久化(journal,JDBC)
(11)性能(client-server,cluster,peer…)
</code></pre>

<h2>ActiveMQ功能</h2>
<pre><code>- 多种协议
- 持久化
- 安全
- 集群
- 监控
- 其他
</code></pre>

<h2>AvtiveMQ多种协议</h2>
<p>URI: scheme:scheme-specific-part</p>
<p>eg:</p>
<pre><code>VM vm://brokername 
TCP tcp://host:port 
SSL ssl://host:port 
HTTP http://host:port 
UDP udp://host:port 
peer   peer://group/brokername 
multicast multicast://IPAddress
static static(list uris) 
failover failvoer(list uris)
discovery discovery://host:port
</code></pre>

<h2>ActiveMQ持久化</h2>
<p>日志：</p>
<pre><code>&lt;journaledJDBC journalLogFiles=&quot;5&quot;dataDirectory=&quot;../mq-data&quot; /&gt;
</code></pre>

<p>数据库：</p>
<pre><code>包括： Derby,HSQL,MySQL,SQLServer, Sybase,DB2,Oracle…
&lt;journaledJDBC  dataSource=&quot;#mysql-ds&quot;/&gt;
</code></pre>

<h2>ActiveMQ安全</h2>
<p>认证</p>
<pre><code>simpleAuthenticationPlugin
jaasAuthenticationPlugin
</code></pre>

<p>授权</p>
<pre><code>authorizationPlugin
</code></pre>

<h2>ActiveMQ集群</h2>
<ul>
<li>
<p>Master/Slave</p>
</li>
<li>
<p>Network of Brokers</p>
</li>
</ul>
<p><img src="https://i.imgur.com/DGAokJv.png" /></p>
<h4>ActiveMQ监控</h4>
<ul>
<li>
<p>JMX(Java管理扩展框架)</p>
</li>
<li>
<p>Advisory  Message（通知消息）</p>
</li>
</ul>
<h4>Queue与Topic区别</h4>
<p><img src="https://i.imgur.com/Ms0Qc8e.png" /></p>
<h4>使用ActiveMQ作为实现JMS中间件优点</h4>
<pre><code>1.多种语言和协议编写客户端。语言: Java, C, C++, C#, Python, PHP。
2.完全支持JMS1.1和J2EE 1.4规范 (持久化,XA消息,事务)
3.对Spring的支持,ActiveMQ可以很容易内嵌到使用Spring的系统里面去,而且也支持Spring2.0的特性
4.完全支持JMS1.1和J2EE 1.4规范 (持久化,XA消息,事务)
5.通过了常见J2EE服务器(如 Geronimo,JBoss 4, GlassFish,WebLogic)的测试,其中通过JCA 1.5 resource adaptors的配置,可以让ActiveMQ可以自动的部署到任何兼容J2EE 1.4 商业服务器上
6.支持多种传送协议
7.从设计上保证了高性能的集群,客户端-服务器,点对点
8.支持Ajax
9.支持与Axis的整合
10.可以很容易得调用内嵌JMS provider,进行测试
</code></pre>

<h4>ActiveMQ关键词</h4>
<ul>
<li>
<p>ActiveMQConnectionFactory：</p>
<pre><code>实现了jms的ConnectionFactory，Connection的工厂类 
</code></pre>

</li>
<li>
<p>Connection ：</p>
<pre><code>JMS连接，和Java连接池的Connection差不多  Producer和Consumer用来和Broker通讯的 
</code></pre>

</li>
<li>
<p>Session ：</p>
<pre><code>会话 
</code></pre>

</li>
<li>
<p>Destination ：</p>
<pre><code>目的地，数据要发送到哪里或者从哪里取 
</code></pre>

</li>
<li>
<p>MessageProducer： </p>
<pre><code>生产者 
</code></pre>

</li>
<li>
<p>MessageConsumer ：</p>
<pre><code>消费者 
</code></pre>

</li>
<li>
<p>Message ：</p>
<pre><code>消息，add到队列的东西，也就是自己要处理的东西，Message有很多子接口，TextMessage或ByteMessage
</code></pre>

</li>
</ul>
<h4>ActiveMQ目录说明</h4>
<pre><code>bin:存放的是脚本文件
conf :存放的是基本配置文件     
data :存放的是日志文件
docs :存放的是说明文档
examples :存放的是简单的实例
lib :存放的是activemq所需jar包
webapps :用于存放项目的目录
</code></pre>

<h4>ActiveMQ应用场景</h4>
<p><img src="https://i.imgur.com/FhRDE22.png" />
<img src="https://i.imgur.com/Q9fMAjK.png" /></p>
<h4>ActiveMQ入门案例1</h4>
<ul>
<li>
<p>创建web project工程</p>
</li>
<li>
<p>引入MQ相关jar包</p>
<pre><code>activeio-core-3.1.4.jar

activemq-all-5.13.2.jar

activemq-pool-5.13.2.jar

commons-pool2-2.4.2.jar
</code></pre>

</li>
<li>
<p>创建生产者</p>
<pre><code>/**
 * 消息的生产者(提供者)，用于发送消息
 * @author likang
 * @date   2017-12-21 上午9:55:47
 */
public class Product {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;//使用默认的用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认的密码
    private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认的连接地址


    public static void main(String[] args) {

        ConnectionFactory connectionFactory ;//连接工厂
        Connection connection;//连接
        Session session;//会话
        Destination destination;//消息目标
        MessageProducer messageProducer;//消息的生产者

        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, URL);//初始化连接工厂
        try {
            connection = connectionFactory.createConnection();//创建连接
            connection.start();//启动连接信息

            /**
             * boolean参数1：如果是true，则代表开启事务。参数2则可以取以下前3种
             *                         如果是false，则代表不开启事务。参数2则可以取以下4种
             * 
             * int 参数2：AUTO_ACKNOWLEDGE---客户端无需做任何副本操作，就可以获取消息信息(自动装配模式)
             *          CLIENT_ACKNOWLEDGE---客户端需要做操作确认，才可以获取消息
             *          DUPS_OK_ACKNOWLEDGE---是无需任何副本操作
             *          SESSION_TRANSACTED----只有在第一个参数使用false的时候，才可以使用
             * 
             */
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(&quot;java12&quot;);//选择协议主题，并且初始化主题名称
            messageProducer = session.createProducer(destination);//创建生产者
            sendMessage(messageProducer,session);//发送消息
            session.commit();//提交消息到MQ容器中
        } catch (Exception e) {
        }

    }

    /**
     * 发送消息内容
     * @param messageProducer
     * @param session
     * @throws JMSException 
     */
    private static void sendMessage(MessageProducer messageProducer,Session session) throws JMSException {

        for (int i = 0; i &lt; 10; i++) {
            TextMessage tx = session.createTextMessage(&quot;ActiveMQ 发送消息&quot; + i);
            System.out.println(&quot;生产者发送消息内容为：&quot; + tx.getText());
            messageProducer.send(tx);
        }

    }
}
</code></pre>

</li>
<li>
<p>创建消费者</p>
<pre><code>/**
 * 消息的接受者(消费者)
 * @author likang
 * @date   2017-12-21 上午10:12:37
 */
public class Columer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;//使用默认的用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认的密码
    private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认的连接地址

    public static void main(String[] args) {
        ConnectionFactory connectionFactory ;//连接工厂
        Connection connection;//连接
        Session session;//会话
        Destination destination;//消息目标
        MessageConsumer messageConsumer;//消息的消费者

        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, URL);//初始化连接工厂
        try {
            connection = connectionFactory.createConnection();//创建连接
            connection.start();//启动连接信息
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(&quot;java12&quot;);//选择协议主题，并且初始化主题名称
            messageConsumer = session.createConsumer(destination);//创建消费者

            while(true){
//              TextMessage tx = session.createTextMessage();//接收消息
                TextMessage tx = (TextMessage) messageConsumer.receive(1000000);//100S
                if (tx != null) {
                    System.out.println(&quot;消费者接收消息内容为：&quot;+tx.getText());
                }else{
                    break;
                }
            }

        } catch (Exception e) {
        }
    }
}
</code></pre>

</li>
<li>
<p>启动ActiveMQ服务</p>
<p>双击启动服务</p>
</li>
<li>
<p>运行生产者</p>
<pre><code>执行main方法
</code></pre>

</li>
<li>
<p>运行消费者</p>
<pre><code>执行main方法
</code></pre>

</li>
<li>
<p>进入ActiveMQ后台监控系统</p>
<p>地址：http://localhost:8161/admin/queues.jsp</p>
</li>
</ul>
<p><img src="https://i.imgur.com/ikclalR.png" /></p>
<ul>
<li>观察运行结果</li>
</ul>
<h4>ActiveMQ入门案例2（集成spring）</h4>
<ul>
<li>
<p>创建一个web project工程</p>
</li>
<li>
<p>导入所需jar包</p>
</li>
<li>
<p>增加配置文件信息</p>
<pre><code>web.xml、spring-mvc.xml、applicationContext.xml、ActiveMQ.xml
</code></pre>

</li>
<li>
<p>增加ActiveMQ配置文件信息</p>
<pre><code>配置ActiveMQ的连接工厂
配置Spring 的Cache工厂
定义JmsTemplate的Queue类型 
定义JmsTemplate的Topic类型
定义Queue监听
定义Topic监听
</code></pre>

</li>
<li>
<p>测试地址</p>
<pre><code>URL：http://localhost:8161/admin/
前端测试页面地址：http://localhost/ActiveMQSpringDemo/index.jsp
</code></pre>

</li>
</ul>
<h4>常见协议汇总</h4>
<ul>
<li>
<p>物理层：</p>
<p>以太网·调制解调器·电力线通信(PLC)·SONET/SDH · 光导纤维等</p>
</li>
<li>
<p>数据链路层：</p>
<p>Wi-Fi(IEEE 802.11) · ATM · DTM · 令牌环·以太网· GPRS · HDLC · PPP · L2TP ·PPTP ·STP 等</p>
</li>
<li>
<p>网络层协议：</p>
<p>IP (IPv4 · IPv6) · ICMP· ICMPv6·IGMP ·IS-IS · ARP · RARP等</p>
</li>
<li>
<p>传输层协议：</p>
<p>TCP · UDP · TLS · DCCP · SCTP · RSVP 等</p>
</li>
<li>
<p>应用层协议：</p>
<p>HTTP · POP3 · RPC · DHCP · DNS · FTP · IMAP4 · IRC · XMPP · SMTP · SNMP · SSH · RTP · SOAP等</p>
</li>
</ul>
