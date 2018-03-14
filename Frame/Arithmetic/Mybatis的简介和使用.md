# 1.Mybatis

          支持普通的SQL(增 删 改 查 )   和  存储过程   以及  ORM(Object Relation Mapping)
          对象关系映射。
          封装了JDBC操作   以及参数的设置  以及 结果集的检索。
  
# 2.Mybatis 的核心构成

             实体类     封装数据信息的  以及封装业务逻辑的
          SQL 定义文件    定义sql语句 
            主配置文件       加载数据库连接信息的  以及加载sql定义文件的
             框架API    完成对数据库的增删改查 等操作
     
# 3.统计某张表的数据量 
## 3.1 建立一个项目   拷贝Mybatis的主配置文件 到src下并导入jar包(数据库驱动 以及Mybatis jar)     
## 3.2 定义一个 sql 定义文件   并在主配置文件下导入
## 3.3 使用框架的API  执行 获取数据
  
            SqlSession
       
# 4.会使用SqlSession  完成增删改查

        具体参考 BankAccountMapper.xml
   
# 5.定义一个dao 接口  其中有 查询表中数据量的方法

          根据账户编号查询账户信息的方法 
          根据账户信息 添加账户的方法 
  
# 6.Mapper 映射器接口的规则
## 6.1 接口中方法名 和 sql定义文件中的 sql id 保持一致 
## 6.2 接口中的方法的返回值   和  sql 语句对应的 resultType 保持一致

          增 删 改 操作 可以返回 void  最好是 int
          查询语句 返回单个对象  则和resultType 保持一致
          查询语句返回多个对象 则加 List<resultType> 
      
## 6.3 接口中方法的参数  和 sql 语句对应的 parameterType 保持一致
## 6.4 sql 定义文件的 namespace  需要指定成  包名+接口名
# 7.根据Mapper 映射器规则 实现 查询银行账户列表 和  根据账号删除账户
  
# 8.当resultType类型中的属性 和  数据库中字段名不一致时如何解决?
## 8.1 使用sql语句的别名

            <select id="bankAccount2ByAno" parameterType="string" 
                resultType="com.xdl.bean.BankAccount2">
                select  ano "uid",aname,apassword,money from bank_account where ano = #{n} 
            </select>
    
## 8.2 使用resultMap 解决

            <select id="bankAccount2ByAno" parameterType="string" 
                resultMap="accountMap">
                select  * from bank_account where ano = #{n} 
            </select>
            
            <resultMap type="com.xdl.bean.BankAccount2" id="accountMap">
                <!-- 把对象中的属性 和  数据库中的字段 做对应  -->
                <result  property="uid"  column="ano"/>
            </resultMap>
    
# 9.分页的实现

           sql 语句
           
              按照money 排序 显示 bank_account 的一页显示pageSize条数据  显示第pageNumber页数据
              
               select * from  (select rownum r,t.* from 
                        (select * from bank_account  order by money) t
                                  where  rownum < (pageSize*pageNumber)+1) 
                                        where r > (pageNumber-1)*pageSize
               
              按照money 排序 显示 bank_account 的一页显示3条数据  显示第2页数据 
              
               select * from  (select rownum r,t.* from 
                       (select * from bank_account  order by money) t
                              where  rownum < (3*2)+1) 
                                        where r > (2-1)*3
