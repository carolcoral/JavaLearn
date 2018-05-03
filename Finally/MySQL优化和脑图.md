# MYSQL
### 集群搭建、主从配置、读写分离
### 参考文档

[《02_CentOS安装mysql数据库文档》](https://github.com/carolcoral/JavaLearn/blob/master/Finally/CentOS%20%E5%AE%89%E8%A3%85%20mysql5.7.md)

[《03_Mysql主从配置文档》](https://github.com/carolcoral/JavaLearn/blob/master/Finally/MySQL%E4%B8%BB%E4%BB%8E%E9%85%8D%E7%BD%AE%E8%AF%B4%E6%98%8E.md)

[《04_mysql主从知识点》](https://github.com/carolcoral/JavaLearn/blob/master/Finally/MySQL%E4%B8%BB%E4%BB%8E%E9%85%8D%E7%BD%AE%E7%9F%A5%E8%AF%86%E7%82%B9.md)

### 分库分表

* 分库：

        分布式项目用的比较多
        设计到第三方系统

    * 跨库查询：
    
            配置多数据源

* 分表：

        1：涉及海量数据存储
        2：涉及到业务数据(分模块)存储

    * 分表方式：

            1：根据容量来分200M----不推荐使用
                tablename1---200M
                tablename2---200M
                tablename3---200M
                需要配置数据库mysql的监听、触发器
                tablename1---199.9M---1M---0.1
                tablename2---0.9M
                容易造成一些脏数据
        
            2：根据时间来划分---推荐使用
        
                tablename201801
                tablenmae201802
                tablename201803
                tablename201804
                tablename201805
                tablename201806
        
                需要写定时器--22号就会生成一张新表---1.23
        
                什么时候去划分？每个月20-25号之间
        
                tablename201801
                tablename201802
        
        
            eg:查询用户所有的日志信息
        
                需要关联N*12张表，但是在业务处理的时候，我们不建议关联这么多张表，代码逻辑处理不了，只能通过业务处理（增加限制条件）
        
        
            3：根据用户ID来划分---不推荐使用--存在安全漏洞
        
                userid==自增、UUID，---算法----数字---取得是余数最后一位1-6
                table1
                table2
                table3....

### [临时表、视图、存储过程](https://mp.weixin.qq.com/s?__biz=MzIxMjg4NDU1NA==&mid=2247484060&idx=1&sn=3216af458cef0cae1a82f189a538b3f7&chksm=97be0fb9a0c986af6a28a066341031a46f6161a1cf27e6b8a7a6f7cf49af5faeb55775d8eb9a&scene=21#wechat_redirect)

### [数据库引擎](https://mp.weixin.qq.com/s?__biz=MzIxMjg4NDU1NA==&mid=2247483911&idx=1&sn=5970dbd7af397c564c4e76a6f156dbee&chksm=97be0f22a0c986349b0fa7094585da4bd2be22a39a38f82eb7e44b60f5d29a3315972be27657&scene=21#wechat_redirect)


### 四大特性、事务隔离

* ACID:

        原子性、一致性、隔离性、持久性

* 事务隔离四大级别：

    * 参考课程大纲脑图
![](https://raw.githubusercontent.com/carolcoral/SaveImg/master/WechatIMG11.png)

### 如何对数据库做优化？

* 1：数据库设计

        数据库表：字段类型、字段长度、注释、字段命名规范
        数据库索引：外键、关联字段、查询频率比较高的字段、
                如果数据表字段&gt;20，则最多支持16个索引
                如果数据表字段&lt;20，则根据查询频率字段来定
        数据库视图：相当于一张临时表，业务中，尽量少使用
        数据库引擎：根据业务，选择对应的表引擎技术
        数据库存储过程：尽量少用
        数据库字符：UTF-8、或者和页面字符保持一致
        数据库监听器/触发器：一般用于调度任务或者备份还原

* 2：业务调用的sql语句优化

        xml：
        尽量少关联表，效率最高关联4张表，如果多于4张表，则需要开启两个链接事务，但是这两个事务，必须在一个service当中。
        如果是查询语句，则不建议使用*
        如果是查询语句，where条件后面，最好使用索引字段进行关联

* 3：数据库服务器的搭建（集群）

        主从配置：
        读写分离：
        自动化（容器）：

## [脑图](https://raw.githubusercontent.com/carolcoral/SaveImg/master/WechatIMG11.png)
