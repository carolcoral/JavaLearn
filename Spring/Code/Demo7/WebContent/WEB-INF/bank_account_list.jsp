<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"  src="jquery.min.js"></script>
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
	  //alert(ano);
	  $.ajax({
		  //url:"bankAccountRemove.do",
		  url:"http://localhost:9527/spring-mvc-day07-2/bankAccountRemove.do",
		  type:"post",
		  success:function(data){
			  if(data){
				  // 删除页面上对应的行 
				  //$(href).parent().parent().remove();
				  $("#accounts tr[id="+ano+"]").remove();
			  }
		  },
		  dataType:"json",
		  data:{"ano":ano}
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

<h3>账户列表</h3>
<table id="accounts">
     <tr> <td>账号</td> <td>姓名</td><td>密码</td> <td>余额</td><td>删除</td></tr>
</table>
</body>
</html>



