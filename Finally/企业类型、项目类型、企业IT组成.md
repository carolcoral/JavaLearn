<h2>企业类型、项目类型、企业IT组成</h2>
<p><img src="https://i.imgur.com/euKNxIE.png" /></p>
<p><img src="https://i.imgur.com/yxMYwP6.png" /></p>
<h2>项目研发流程、人员搭配</h2>
<p><img src="https://i.imgur.com/nKwv5Br.png" /></p>
<p><img src="https://i.imgur.com/GdFNnE6.png" /></p>
<h2>发展路线</h2>
<p><img src="https://i.imgur.com/X92T38V.png" /></p>
<h2>常使用软件汇总</h2>
<p><img src="https://i.imgur.com/AWqWcB4.png" /></p>
<h2>BUG、需求变更如何处理（分析日志、定位问题）</h2>
<p>代码版本控制器：</p>
<pre><code>SVN、GIT：

    注意事项：
        1：修改代码之前，需要从SVN更新代码
        2：提交之前，需要增加提交注释
        3：在添加完注释之后，需要再次更新SVN代码，才能提交

    注释规范：
            //start likang  2018年4月18日11:27:36 ==TODO ......
                //if(true){
                //  sysou(&quot;123&quot;)
                //}
                if(true){sysout(&quot;3434&quot;)}
            //end
</code></pre>

<p>bug：</p>
<pre><code>淡定、淡定、淡定

本地环境：

    前端：不需要处理
    后台：
        需要看控制台
            1：清除控制台信息
            2：重现问题
            3：从下网上看，找第一个case by......

    网络：找运维


测试环境：

    前端：不需要处理
    后台：
        日志文件：
            1：获取日志文件
            2：从上往下看，找第一个case by.....


    网络：找运维
    数据：不需要管




正式环境(生产环境、线上环境)：


    前端：不需要处理
    后台：
        日志文件：
            1：找运维获取日志文件
            2：从上往下看，找第一个case by.....

    网络：找运维
    数据：找运维，将当期的有问题的数据库，备份导出、将数据库备份文件还原到测试环境


        oracle：exp、expdb（建议使用：数据泵）
                imp、impdb
</code></pre>

<p>需求变更：</p>
<pre><code>1：原需求的变更

    - 分析需求变更的工作量(评估)
    - 分析需求的优先级、紧急度
        - 发邮件回复（肯定会处理、开发计划、申请技术支持、风险）



2：新增需求的变更

    - 评估工作量
    - 分析需求的优先级、紧急度
</code></pre>

<p>待遇：</p>
<pre><code>基本工资+年终奖、双薪+其它补助（饭补）

基本工资+1月奖金

季度奖、项目奖金：

KPI:

    员工每个月都会评价一次结果
    自评：97
    项目经理：95
    部门经理：93

        最终：93

    90+：1200
    70-90:800:
    60-70:500
    60-：考虑
</code></pre>

<p>BUG管理系统：</p>
<pre><code>禅道跟踪管理系统：

报表：
    BUG处理排行榜：
    BUG处理情况：
</code></pre>

<h2>如何部署补丁文件、如何上线</h2>
<p>代码补丁：</p>
<pre><code>出具步骤：
</code></pre>

<p><img src="https://i.imgur.com/Foq0i0K.gif" /></p>
<pre><code>出具规范：

    必须要有补丁说明：

        解决人：
        解决问题：
        解决时间：
        联系方式：



        部署说明：


            1：解压....文件到...，覆盖、复制、删除
            2：执行...&gt;sql脚本
            3：停止服务器、重新部署、清除缓存
</code></pre>

<p>脚本补丁：</p>
<p><img src="https://i.imgur.com/Olv6xtA.gif" /></p>
<p>文档补丁：</p>
<pre><code>文档最上面，《修改记录》，提交SVN
</code></pre>

<h2>数据库、数据库服务器、框架、架构</h2>
<p>数据库：</p>
<pre><code>databasename
</code></pre>

<p>数据库服务器：</p>
<pre><code>mysql、oracle、SqlServer、db2、derby
</code></pre>

<p>框架：</p>
<pre><code>spring\springMVC\mybatis\hibernater\spring boot\struts2

SSM\SSH\SM:整合框架
</code></pre>

<p>架构：</p>
<pre><code>C/S：
B/S：

微服务、SOP区别：
</code></pre>

<h2>分布式、集群、高并发、负载、缓存、云端</h2>
<p>分布式：</p>
<pre><code>不同的业务，不同的模块，不同的功能，分别部署到不同的服务器
</code></pre>

<p>集群：</p>
<pre><code>相同的业务，相同的模块，相同的功能，分别部署到不同的服务器
</code></pre>

<p>高并发：</p>
<pre><code>同一时刻，N多人，同时访问同一个功能
</code></pre>

<p>负载（均衡）：</p>
<pre><code>某一个时间段内，服务器所支持的最大访问人数（求平均值）
</code></pre>

<p>缓存：</p>
<pre><code>提高服务器性能，和用户体验的，提高服务器访问的事务安全性
</code></pre>

<p>云：</p>
<pre><code>腾讯云、阿里云、七牛云等
</code></pre>

<h2>小明的故事</h2>
<p><img src="https://i.imgur.com/PgTUw19.png" /></p>
<h2>层次架构（技术选型）</h2>
<p><img src="https://i.imgur.com/zRmUkNF.png" /></p>
<h2>技术架构</h2>
<h2>负载架构</h2>
<h2>二维码工具类</h2>

