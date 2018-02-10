## 1.如何使用 easyui

* 1.1 下载easyui  的源码包   解压  拷贝到项目的WebContent下

* 1.2 在页面中  导入3个js文件(jquery  easyui   语言)  和  2 个 css 文件(easyui 和 icon) 

* 1.3 在页面中 使用对应的样式 和 api

## 2.面板  panel

* 2.1  面板是其它元素的或者组件的容器 

* 2.2  组成 

        基础面板
            data-options="key:value,key:value"
        面板工具
            元素.panel('方法名');
                有些属性带有代码 功能 比如 minimizable  ...  
            面板嵌套            
                面板中可以加入 东西南北中布局  (上北下南 左西右东) 
                
                <div  title="面板嵌套"  class="easyui-panel"  data-options="width:500,height:200">
                    <div  class="easyui-layout"  data-options="fit:true">
                        <div  data-options="region:'west',split:true" style="width:100px">
                            左
                        </div>
                        <div  data-options="region:'center'" >
                            中                   
                        </div>
                    </div> 
                </div>            
    
* fit  让组件撑满父容器

* split  可以调整大小             
                
## 3.可拖动组件 和 可调整大小

>class="easyui-draggable"

>class="easyui-resizable"
   
## 4.组件的提示

    <a href="#"  title="我是超级玛利"  class="easyui-tooltip"
        style="text-decoration: none">hello a </a>
        
## 5.消息组件 

          function   fadeMsg(){
            	$.messager.show({
            		title:'2018年找份啥工作?',
            		msg:'做java的一个月8000起步',
            		timeout:3000,
            		showType:'fade'
            	});
            }
    
>showType 的取值 有  show   slide   fade      

>layer这个网站  这个提示更加的丰富
  
## 6.选项卡 

* class="easyui-tabs"    向这个组件添加 子选项卡   这叫普通选项卡

* class="easyui-accordion"  可折叠选项卡 

            <div  class="easyui-accordion"   
               data-options="width:700,height:300,selected:2">
                 <div  title="选项卡1">
                            力量型英雄
                 </div>
                 <div  title="选项卡2"  data-options="closable:true">
                            敏捷型英雄
                 </div>
                 <div  title="选项卡3">
                            智力型英雄
                 </div>
            </div>

## 7.window
    可以自由移动的组件  多了 最大化 最小化  折叠 和 关闭 
  class="easyui-window"  

## 8.Dialog  

>构建一个对话框.要求:标题是 对话框,高度300,宽度 400,对话框中的内容是:要求在左上角增加一个图标,保存的图标,好好上课,学好回家。  
  
          function  createDialog(){
        	$("#div1").html('湖南卫视--天天向上');
        	$("#div1").dialog({
        		title:'js对话框',
        		iconCls:'icon-save',
        		width:400,
        		height:300,
        		tools:[{iconCls:'icon-save',handler:function(){alert('gg')}},
        		       {iconCls:'icon-cut',handler:remove}],
        		modal:true
        	});
        }   
  
* tools  设置右上角图标 和   对应的事件处理

* modal   设置成true  代表 模态窗口  则必须优先处理这个窗口  否则不能进行下一步操作
 
## 9.右键菜单

* 9.1 使用 class="easyui-menu"  制作菜单

* 9.2 使用js 绑定 contextmenu  事件 

* 9.3 使用事件对象取消浏览器默认的菜单 event.preventDefault()

* 9.4 显示自定义菜单元素.menu('show',通过查文档获取参数类型赋值)  
 
## 10.分页控件

* class = "easyui-pagination" 

* data-options="total:总数量,pageSize:页面大小,onSelectPage:页面切换函数调用"
 
