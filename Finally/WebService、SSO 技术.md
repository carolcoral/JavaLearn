<h2>WebService、SSO</h2>
<p>WS：一种比较常用的接口方式，目的，只是为了传输数据或者接口API(接口地址、接口名称、接口参数、接口返回值)</p>
<pre><code>传输的数据格式，多数是XML，但是ws中解析xml的方式比较特殊，而且是固定的，使用的技术使WSDL（XML解析语言）


WSDL 是基于 XML 的用于描述 Web Services 以及如何访问 Web Services 的语言。
WSDL 指网络服务描述语言
WSDL 使用 XML 编写
WSDL 是一种 XML 文档
WSDL 用于描述网络服务
WSDL 也可用于定位网络服务
WSDL 还不是 W3C 标准
</code></pre>

<p>普通的接口格式：</p>
<pre><code>http://localhost:8080/queryAllUser.do
</code></pre>

<p>webservice接口格式：</p>
<pre><code>http://localhost:8080/queryAllUser.do?WSDL


返回值：

    数据格式：

    <list>
        <userinfo1>
            <username>sfasdf</username>
        </userinfo1>
        <userinfo2>
            <username>sfasdadsfasdff</username>
        </userinfo2>
    </list>


    接口API方式：

        <list>
            <interface1>
                <methodname>sfasdf</methodname>
                <param>name</param>
            </interface1>
            <interface2>
                <methodname>sfasdadsfasdff</methodname>
                <param>phone</param>
            </interface2>
        </list>
</code></pre>

<p>应用场景：</p>
<pre><code>1：调用第三方平台接口
2：分布式项目部署
</code></pre>

<p>测试工具：</p>
<pre><code>soapUI用来测试WS接口的通用、负载、功能性
</code></pre>

<p>WS参考地址：</p>
<p><a href="https://mp.weixin.qq.com/s?__biz=MzIxMjg4NDU1NA==&amp;mid=2247483975&amp;idx=1&amp;sn=95fa1b5007cb6f7b271919994b216538&amp;chksm=97be0f62a0c98674cae9b2db0aab2b267f719691d30fa6e328e1025e956ad9f23077434720e7&amp;scene=21#wechat_redirect">https://mp.weixin.qq.com/s?_<em>biz=MzIxMjg4NDU1NA==&amp;mid=2247483975&amp;idx=1&amp;sn=95fa1b5007cb6f7b271919994b216538&amp;chksm=97be0f62a0c98674cae9b2db0aab2b267f719691d30fa6e328e1025e956ad9f23077434720e7&amp;scene=21#wechat</em>redirect</a></p>
<p>SSO原理：</p>
<pre><code>SSO：全称单点登陆

目的：解决用户多次，频繁登陆的问题

前提：这些登陆的系统之间，都是相互信任的

应用场景：

        1：门户网站、系统：portal
        2：分布式dubbo

        3：集群(数据库)
</code></pre>

<p><img src="https://i.imgur.com/H46qkRz.png" /></p>
<p>SSO参考地址：</p>
<p><a href="https://mp.weixin.qq.com/s?__biz=MzIxMjg4NDU1NA==&amp;mid=2247484038&amp;idx=1&amp;sn=32cca5c6cff33372cba0a6829a6be530&amp;chksm=97be0fa3a0c986b594fe69776f56fd86afd72859e6b2797e2583df4cb482b73ab767551d2590&amp;scene=21#wechat_redirect">https://mp.weixin.qq.com/s?_<em>biz=MzIxMjg4NDU1NA==&amp;mid=2247484038&amp;idx=1&amp;sn=32cca5c6cff33372cba0a6829a6be530&amp;chksm=97be0fa3a0c986b594fe69776f56fd86afd72859e6b2797e2583df4cb482b73ab767551d2590&amp;scene=21#wechat</em>redirect</a></p>
