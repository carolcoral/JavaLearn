<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"  src="jquery.min.js"></script>
<script type="text/javascript">
     $(function(){
    	 alert('gg');
     });
</script>
<script type="text/javascript">
   // 等页面加载完成 
   $(function(){
	    // 发送ajax 请求 
	    $.ajax({
	    	url:"bankAccountList.do",
	    	type:'post',
	    	success:function(datas){
	    		var $table = $("#accounts");
	    		for(var i=0;i<datas.length;i++){
	    			// 拼接出表格的一行
	    			var obj = datas[i];
	    			var trStr = "<tr id='"+obj.ano+"'> <td>"+obj.ano+"</td> <td>"+obj.aname+"</td><td>"+
	    			obj.apassword+"</td> <td>"+obj.money
	    			+"</td><td><a href='javascript:' onclick='removeAccount(this)'>删除</a></td></tr>";
	    		    $table.append($(trStr));
	    		}
	    	},
	    	dataType:"json"
	    });
   });
  // 根据账号来删除账户 
  function   removeAccount(href){
	  var  ano = $(href).parent().parent().attr("id");
	  $.ajax({
		  url:"http://localhost:9527/spring-rest-day08/account/"+ano,
		  type:"delete",
		  success:function(data){
			  if(data){
				  $(href).parent().parent().remove();
			  }
		  },
		  dataType:"json"
	  });
  }
  function  accountInfoByAno(){
	  // 获取查询的账号 
	  var  ano = $("#ano").val();
	  $("#aname").val("");
	  $("#apassword").val("");
	  $("#money").val("");
	  $.ajax({
		  url:"http://localhost:9527/spring-rest-day08/account/"+ano,
		  type:"get",
		  success:function(data){
			  if(data != null){
				  $("#ano").val(data.ano);
				  $("#aname").val(data.aname);
				  $("#apassword").val(data.apassword);
				  $("#money").val(data.money);
				  return;
			  }
			  alert('ggg');
		  },
		  dataType:"json",
		  error:function(){
			  alert('error');
		  }
	  });
	  
  }
  /** 开户的方法  */
  function  createAccount(){
	  var  ano = $("#ano").val();
	  var  aname = $("#aname").val();
	  var  apassword = $("#apassword").val();
	  var  money = $("#money").val();
	  // 使用post 方式发送ajax 请求 
	  $.ajax({
		  url:"http://localhost:9527/spring-rest-day08/account/"+ano,
		  type:"post",
		  success:function(data){
			  if(data){
				  //在表格的最后 增加这条数据 
				  var trStr = "<tr id='"+ano+"'> <td>"+ano+"</td> <td>"+aname+"</td><td>"+
	    		   apassword+"</td> <td>"+money
	    		   +"</td><td><a href='javascript:' onclick='removeAccount(this)'>删除</a></td></tr>";
	    		  $("#accounts").append($(trStr));
			  }
		  },
		  dataType:"json",
		  data:{"ano":ano,"aname":aname,"apassword":apassword,"money":money}
	  });
  }
  
  /** 更新的方法  */
  function  updateAccount(){
	  var  ano = $("#ano").val();
	  var  aname = $("#aname").val();
	  var  apassword = $("#apassword").val();
	  var  money = $("#money").val();
	  // 使用put 方式发送ajax 请求 
	  $.ajax({
		  url:"http://localhost:9527/spring-rest-day08/account/"+ano,
		  type:"post",
		  contentType:"application/json",
		  success:function(data){
			  if(data){
				  alert(data);
			  }
		  },
		  dataType:"json",
		  data:JSON.stringify({"ano":ano,"aname":aname,"apassword":apassword,"money":money})
	  });
  }
</script>

<style type="text/css">
    table {
        width:  600px;
        border: 1px solid purple;
        text-align: center;
        border-collapse: collapse;
    }
    td{
       border: 1px solid purple;  
    }
</style>
</head>
<body>
<h3>账户操作 </h3>
<input  type="button"  value="根据ano查询" onclick="accountInfoByAno()"> 
<input  type="button"  value="开户" onclick="createAccount()">
<input  type="button"  value="更新" onclick="updateAccount()"><br>
账号:<input  type="text"  id="ano" > <br>
名字:<input  type="text"  id="aname" > <br>
密码:<input  type="text"  id="apassword" > <br>
余额:<input  type="text"  id="money" > <br>
<h3>账户列表</h3>
<table id="accounts">
     <tr> <td>账号</td> <td>姓名</td><td>密码</td> <td>余额</td><td>删除</td></tr>
</table>
</body>
</html>



