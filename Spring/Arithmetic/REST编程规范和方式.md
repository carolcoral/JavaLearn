# 1.什么是Rest

         REST即表述性状态传递（英文：Representational State Transfer，简称REST 
         基于JSON或者XML  一个对请求的URL 和 请求方式 做了限制的一套规范 
# 2.REST 的主要规范

            基于资源做URL的设计(之前的技术都是基于操作做设计)
            通过HTTP的请求方式来区分具体的操作
             (GET  POST  PUT  DELETE) 
          http://itxdl.cn/orders/{id}    id=1234 这个URL 如果发get 可以表达获取 1234 的订单
          如果是 post  可以是增加订单   put  可以是修改订单  delete 是删除订单
        
# 3.对银行账户 根据ano  进行删除

          http://localhost:9527/spring-rest-day08/account/{ano}     
          /** 控制器方法的设计 */
          @RequestMapping(value="/account/{ano}",method=RequestMethod.DELETE)
          @ResponseBody
          public  boolean  removeAccount(@PathVariable("ano") String  ano){
          
          }
          
          rest 中没有以 .do 结尾 则 DispatcherServlet 中 需要把 url-parttern 修改为 /
            则需要对静态资源做额外处理程序 才能正常运转
    
# 4.使用ajax  结合rest  实现对 银行账户的添加

## 4.1  在 BankAccountDAO 接口中添加一个方法  可以完成对账户的添加 
## 4.2  在实现类中实现这个方法 
## 4.3  在BankAccountService服务类中 添加服务方法 并测试 ----- M
## 4.4  写一个控制器

          @RequestMapping(value="/account/{ano}",method=RequestMethod.DELETE)
          @ResponseBody
          public  boolean  addAccount(@PathVariable("ano") String  ano,
              Account account){
              // 调用对应的服务方法 
          }
  
## 4.5 页面发出对应的ajax 请求使用data:json格式的数据

            接收请求对应的返回值  如果是真  则使用jquery的api 给页面添加账户数据
      
# 5.Rest 中的put 请求

           ajax 中 type 改成 put  contentType:"application/json"
           data 必须以json字符串格式传递  JSON.stringify(json格式)  把json变成json字符串的  
              控制器中  method=RequestMethod.PUT
           @RequestBody  控制器的对象参数上  把请求体中的json 字符串变成对象
              把put 改成 post 也是可以的  就是 post 本来可以简单的传值但是可以用最复杂的方式使用
