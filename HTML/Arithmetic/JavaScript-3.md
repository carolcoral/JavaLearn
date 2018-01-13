<body>
<h1>JS 02</h1>
<p>二〇一八年一月十三日 15:16:29 </p>
<hr />
<h3>table  表对象</h3>
<pre><code>常用属性: 

    rows    :获取表格中所有的行

常用函数: 

    insertRow(index) : 向表格中指定index位置, 插入一行(tableRow) , 并返回这个tableRow对象  

    deleteRow(index) : 从表格中指定位置, 删除一行! 
</code></pre>

<h3>tableRow 行对象</h3>
<pre><code>常用属性: 
    cells   : 获取行中所有的列
    innerHTML: tr的文本内容设置与获取
    rowIndex: 获取当前行, 在表格中的索引值 !


常用方法: 
    insertCell(index):向行中指定index位置, 插入一列(tableCell) , 并返回这个tableCell对象  
    deleteCell(index) : 从表格中指定位置, 删除一行! 
</code></pre>

<h3>TableCell 列对象</h3>
<pre><code>常用属性: 

    cellIndex   : 获取当前列在行中的索引
    innerHTML   : 获取与设置当前td的文本
    colSpan     : 设置td 垂直占用几个单元格
    rowSpan     : 设置td 横向占用几个单元格
</code></pre>

<h1>浏览器对象</h1>
<p>1-12,星期五 11:09:07 </p>
<hr />
<h3>打开新窗口</h3>
<pre><code>格式: 
var window = window.open(url,[name],[config],[specs]);

url : 打开新的窗口加载的地址
name: 窗口的名称, 不是网页标题, 是新window对象的唯一标识, 不能重复 !
config: 窗口的参数配置
specs: boolean类型参数, 是否加载历史文件, true表示加载 !

config: 

    是一个字符串, 窗口中所有的参数, 采用key=value的方式编写 , 多个参数之间使用逗号分割!
    可配置的参数如下: 

        常用: 
            -   height: 高度px;
            -   width : 宽度px;
            -   left  : 窗口的位置, 距离屏幕左边界的距离px
            -   top   : 窗口的位置, 距离屏幕上边界的距离px

        不常用(很多浏览器不支持):(都是boolean类型参数, 但是传递的不是true和false  而是[yes/no 1/0])
            location: 新的打开的窗口是否显示地址栏
            menubar : 新窗口是否显示菜单栏
            resizable: 是否可调整大小
            scrollbars: 是否显示滚动条
            titlebar : 是否显示标题栏
            tollbar : 是否显示工具栏


案例: 

打开笔记地址: 

        window.open(&quot;https://itdage.cn&quot;);


弹窗小程序: 

    width: 226   
    height:153
    for(i=0;i&lt;5;i++){
        for(j=0;j&lt;6;j++){
            window.open(&quot;https://itdage.cn&quot;,i+j+&quot;&quot;,&quot;width=226px,height=153px,left=&quot;+(j*226)+&quot;,top=&quot;+(i*153));
        }
    }
</code></pre>

<h3>关闭窗口</h3>
<pre><code>window对象.close();
</code></pre>

<h3>定时器 ***</h3>
<pre><code>一次性定时器 ***

格式: 

    setTimeout(&quot;执行的语句&quot;,延迟毫秒数)


案例: 

    定时关闭新窗口 

    for(i=0;i&lt;5;i++){
        for(j=0;j&lt;6;j++){
            var win = window.open(&quot;https://itdage.cn&quot;,i+j+&quot;&quot;,&quot;width=226px,height=153px,left=&quot;+(j*226)+&quot;,top=&quot;+(i*153));
            setTimeout(timeOut(win),1000);
        }
    }

    function timeOut(win){
        win.close();
    }
</code></pre>

<h3></h3>
<pre><code>周期性定时器  ***

    1.  开启周期性定时器

        var obj = setInterval(要执行的语句,周期时间毫秒);


    2.  关闭周期性定时器

        clearInterval(周期性定时器对象);


案例: 

    时钟案例: 

    HTML部分: 
        &lt;h1&gt;00:00&lt;/h1&gt;
        &lt;p&gt;&lt;button onclick=&quot;startShow()&quot;&gt;开始显示&lt;/button&gt;&lt;/p&gt;
        &lt;p&gt;&lt;button onclick=&quot;stopShow()&quot;&gt;停止显示&lt;/button&gt;&lt;/p&gt;


    JS部分:

        var interval = null;
        function startShow(){
            //开启周期性定时器, 周期性的调用showTimee
            if(interval !=null){
                alert(&quot;已经开始了&quot;); 
            }else{
            interval = setInterval(&quot;showTime()&quot;,1000);
            }
        }
        function stopShow(){
            if(interval != null){
                clearInterval(interval);            
            }
        }
        function showTime(){
            var date = new Date();
            var arr = document.getElementsByTagName(&quot;h1&quot;);
            arr[0].innerHTML = date.toLocaleTimeString();
        }
</code></pre>

<h3>屏幕信息的获取 了解</h3>
<pre><code>screen : 用于获取屏幕的分辨率 以及 可用宽高的对象

常用属性: 

    1.  width:  获取屏幕宽度
    2.  height: 获取屏幕高度

    3.  availWidth: 获取屏幕可用宽度
    4.  avaiHeight: 获取屏幕可用高度


正常情况下, win7|win10 任务栏占用40px的高度 , winxp 占用30px
</code></pre>

<h3>浏览器信息的获取 了解</h3>
<pre><code>navigator

for(var xname in navigator){
    console.info(xname+&quot; : &quot;+navigator[xname]);
}
</code></pre>

<h3>浏览器历史对象 了解</h3>
<pre><code>history

常用方法: 

    back(): 浏览器后退一页
    forward(): 浏览器前进一页
    go(number): 指定前进的页数, 2表示前进2页, -1表示后退一页


案例: 

&lt;button onclick=&quot;history.forward()&quot;&gt;前进&lt;/button&gt;

&lt;button onclick=&quot;history.back()&quot;&gt;后退&lt;/button&gt;
</code></pre>

<h3>浏览器地址对象 *</h3>
<pre><code>location

    属性:
    href: 表示浏览器加载的网址对象, 修改这个属性的值可以实现网页的跳转!

    常用函数: 

    replace(url)  替换当前页面 (替换不等于跳转!);
    reload() 刷新网页
    assign(url) : 跳转网页

    推荐使用的跳转网页方式: 

        1.  href属性
        2.  assign函数
</code></pre>

<h3>事件 *****</h3>
<pre><code>指的是HTML对象, 在状态改变, 操作鼠标, 操作键盘时 触发的动作

    鼠标事件  onclick

    键盘事件  onkeydown  onkeyup

    状态事件  onload
</code></pre>

<h5>键盘事件</h5>
<pre><code>可以通过JS 获取到用户对于键盘的 按下和弹起 !

键盘可以连续触发多次的按下事件,  而不弹起 !


1.  键盘按下 (按下不松 , 会连续触发)
    onkeydown

2.  键盘的弹起
    onkeyup

上述的两个事件属性, 可以任何的元素添加, 但是一般我们监听键盘都是监听网页的全局操作. 

所以一般是给window的onkeydown|onkeyup添加处理: 

案例: 

    监听网页的按键  按下与弹起

    window.onkeydown = function(){

        console.info(&quot;键盘按下了&quot;);  
    }

    window.onkeyup = function(){
        console.info(&quot;键盘弹起了&quot;);  
    }


案例: 

    通过event对象, 获取键盘事件的详细信息 : 

    window.onkeydown = function(){
        var code = window.event.keyCode;
        console.info(&quot;键盘按下了&quot;+code); 
    }

    window.onkeyup = function(){
        var code = window.event.keyCode;
        console.info(&quot;键盘弹起了&quot;+code); 
    }
</code></pre>


</body>
