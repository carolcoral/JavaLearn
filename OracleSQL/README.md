     <table align="right" style="margin-right:0;">
       <tr style="margin:0 auto;">
         <th colspan="2">
           <a href="https://github.com/carolcoral/JavaLearn/tree/master/OracleSQL/StudentManger" style="text-decoration:none">
             学生管理系统(使用数据库操作)
           </a>
         </th>
       </tr>
       <tr>
         <th>文件名</th>
         <th>简要描述</th>
       </tr>
       <tr>
         <th>DBView.java</th>
         <th>系统的展示层，用于展示系统功能以及提供操作选项</th>
       </tr>
       <tr>
         <th>DBModel.java</th>
         <th>系统的逻辑层，提供系统的操作方法</th>
       </tr>
       <tr>
         <th>DBConnection.java</th>
         <th>连接数据库的文件</th>
       </tr>
       <tr>
         <th>DB.Properties</th>
         <th>数据库配置文件</th>
       </tr>
     </table>


<table border=0 cellpadding=0 cellspacing=0 width=803 style='border-collapse:
 collapse;table-layout:fixed;width:803pt'>
 <col class=xl65 width=60 style='mso-width-source:userset;mso-width-alt:2560;
 width:60pt'>
 <col class=xl65 width=118 style='mso-width-source:userset;mso-width-alt:5034;
 width:118pt'>
 <col class=xl65 width=219 style='mso-width-source:userset;mso-width-alt:9344;
 width:219pt'>
 <col class=xl65 width=293 style='mso-width-source:userset;mso-width-alt:12501;
 width:293pt'>
 <col class=xl65 width=113 style='width:113pt'>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td colspan=4 height=34 class=xl68 width=690 style='height:34.0pt;width:690pt'>
       <a href="https://github.com/carolcoral/OnlineExamSystem">在线考试答题系统
  OnlineExamSystem</a></td>
 </tr>
 <tr>
  <td colspan=4>功能包括：1.判断用户和管理员的登录；2.修改当前用户的密码；3.用户自定义考试（选择试卷的难度和题目数量）；4.用户查询成绩；5.用户导出所有已考试的成绩（后期可能修改为条件导出）；6.导出题库（根据用户自己的选择导出想要的某一场考试中的所有试题）；7.管理员对普通用户的增删改查操作；8.管理员对试题的增删改查操作；9.管理员批量导入试题；</td>
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td rowspan=4 height=136 class=xl65 width=60 style='height:136.0pt;
  width:60pt'>ClientOnlineExamSystem客户端</td>
  <td class=xl65 width=118 style='width:118pt'>Main入口</td>
  <td class=xl65 width=219 style='width:219pt'>ClientMain.java</td>
  <td class=xl66 width=293 style='width:293pt'>客户端入口文件</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td rowspan=2 height=68 class=xl65 width=118 style='height:68.0pt;width:118pt'>Model模型层</td>
  <td class=xl65 width=219 style='width:219pt'>Test.java</td>
  <td class=xl66 width=293 style='width:293pt'>试题实体类，定义试题的内容和属性</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td height=34 class=xl65 width=219 style='height:34.0pt;width:219pt'>User.java</td>
  <td class=xl66 width=293 style='width:293pt'>用户实体类，定义用户的内容和属性</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td height=34 class=xl65 width=118 style='height:34.0pt;width:118pt'>View视图层</td>
  <td class=xl65 width=219 style='width:219pt'>ViewUtils.java</td>
  <td class=xl66 width=293 style='width:293pt'>客户端视图文件，存储客户端所有的界面内容</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td rowspan=12 height=408 class=xl65 width=60 style='height:408.0pt;
  width:60pt'>ServerOnlineExamSystem服务端</td>
  <td rowspan=2 class=xl65 width=118 style='width:118pt'>Main 入口</td>
  <td class=xl65 width=219 style='width:219pt'>ServerMain.java</td>
  <td class=xl66 width=293 style='width:293pt'>连接客户端，创建线程</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td height=34 class=xl65 width=219 style='height:34.0pt;width:219pt'>ServerThread.java</td>
  <td class=xl66 width=293 style='width:293pt'>服务端的线程内容，调用返回值</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td rowspan=4 height=136 class=xl65 width=118 style='height:136.0pt;
  width:118pt'>DAO 数据层</td>
  <td class=xl65 width=219 style='width:219pt'>UserDao.java</td>
  <td class=xl66 width=293 style='width:293pt'>处理客户端发送的数据，包含各种需要的 sql 语句</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td height=34 class=xl65 width=219 style='height:34.0pt;width:219pt'>UserDaoFactory.java</td>
  <td class=xl66 width=293 style='width:293pt'>工厂接口</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td height=34 class=xl65 width=219 style='height:34.0pt;width:219pt'>UserDaoImp.java</td>
  <td class=xl66 width=293 style='width:293pt'>接口类型，具体处理内容的部分</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td height=34 class=xl65 width=219 style='height:34.0pt;width:219pt'>UserDaoService.java</td>
  <td class=xl66 width=293 style='width:293pt'>调用处理结果并发送给服务器进而返回给客户端调用对应的结果</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td rowspan=4 height=136 class=xl65 width=118 style='height:136.0pt;
  width:118pt'>Model 模型层</td>
  <td class=xl65 width=219 style='width:219pt'>Exam.java</td>
  <td class=xl66 width=293 style='width:293pt'>试卷实体类，定义试卷包含的内容和属性</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td height=34 class=xl65 width=219 style='height:34.0pt;width:219pt'>Grade.java</td>
  <td class=xl66 width=293 style='width:293pt'>成绩实体类，包含用户成绩的内容和属性</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td height=34 class=xl65 width=219 style='height:34.0pt;width:219pt'>User.java</td>
  <td class=xl66 width=293 style='width:293pt'>用户实体类，定义用户的内容和属性</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td height=34 class=xl65 width=219 style='height:34.0pt;width:219pt'>Test.java</td>
  <td class=xl66 width=293 style='width:293pt'>实体实体类，定义试题的属性和内容</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td rowspan=2 height=68 class=xl65 width=118 style='height:68.0pt;width:118pt'>Util
  工具层</td>
  <td class=xl65 width=219 style='width:219pt'>DBUtils.java</td>
  <td class=xl66 width=293 style='width:293pt'>数据库链接文件，链接数据库</td>
        
 </tr>
 <tr height=34 style='mso-height-source:userset;height:34.0pt'>
  <td height=34 class=xl65 width=219 style='height:34.0pt;width:219pt'>db_config.properties</td>
  <td class=xl66 width=293 style='width:293pt'>数据库配置文件，包含链接数据信息</td>
        
 </tr>
</table>
