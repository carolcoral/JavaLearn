<h1>JS 01</h1>
<p>2018年01月11日18:29:38</p>
<hr />
<h3>Array对象 ***</h3>
<pre><code>表示是数组 

如何创建一个数组: 

    格式1.    var 数组名 = new Array(length);
    格式2.    var 数组名 = new Array();创建一个默认长度为0的数组
    格式3.    var 数组名 = new Array(元素1,元素2,元素3...元素n);
    格式4.    var 数组名 = [元素1,元素2,元素3... 元素n];

从数组中取出数据

    var x = 数组名[下标];

向数组中存储数据

    数组名[下标] = 值;


1.  JS与Java不同, 是弱类型语言 ,数组中的每一个下标 都可以存储任意类型的数据, JS中的数组, 就像Java中的Object[];

2.  JS中的数组, 定义的长度 其实并不影响数据的存储 , 在存储时, 更像Java中的Map集合, 下标就是存储数据的key !

    JS中的数组的长度, 理论上是无限制的 ! 
</code></pre>

<h3>多维数组</h3>
<pre><code>与Java中多维数组的概念一致 , 数组中的每一个元素 依然是一个数组 !

案例: 

    var arrs = new Array(5);
    for(var i=0;i&lt;arrs.length;i++){
        arrs[i] = new Array(5);
        for(var j=0;j&lt;arrs[i].length;j++){
            arrs[i][j] = new Array(1,2,3,4,5);
        }
    }
    console.info(arrs);
</code></pre>

<h3>正则表达式的使用 *</h3>
<pre><code>格式: 

    创建正则对象

        var reg = /正则表达式字符串/g;

    通过正则对象的test方法,验证一个字符串是否匹配

        var booleanFlag = reg.test(&quot;要验证的字符串&quot;);


案例: 
    当一个帐号输入框失去焦点时, 判断输入的帐号是否为手机号, 如果不是则提示用户, 输入存在问题, 请重新输入 !
</code></pre>

<h3>Number四舍五入截取</h3>
<pre><code>通过一个Number类型的数据, 可以调用toFixed方法, 进行小数点后位数的截取 

案例: 

    var num = 1.23456;
    num.toFixed(3);//结果为:1.235
</code></pre>

<h3>Date 日期对象</h3>
<pre><code>创建当前时间对象: 

    var date = new Date();

创建过去或未来时间对象:

    var date = new Date(&quot;年/月/日 时:分&quot;);
</code></pre>

<h3></h3>
<pre><code>Date常用方法: 

获取日期中的单位: 

    获取日期:  getDate  获取天: getDay()

    修改日期: setDate(日期) 
    修改月份 setMonth(月) 
    修改天 setDay(d) 
    修改小时 setHours(h)

使用最多的方法: 

    1.  将日期转换为字符串 toString
    2.  将日期转换为本地时间  字符串: toLocaleTimeString()
    3.  将日期转换为本地日期  字符串: toLocaleDateString();


案例: 

    打印输出当前时间: 

        var date = new Date();
        console.info(date.toLocaleDateString()+&quot; &quot;+date.toLocaleTimeString());  
</code></pre>

<h3>函数</h3>
<pre><code>格式:  
    function 函数名(参数列表){
        函数体;
        [return 返回值;]
    }

案例: 

    定义一个函数, 用来计算两个数字的和, 并尝试调用

    function sum(x,y){
        return x+y;
    }
    var num = sum(1,2);
    console.info(num);

练习: 
    定义一个函数, 用来计算两个数字的大小, 将较大的数字返回出去 !


    function max(x,y){
        return x&gt;y?x:y;
    }       
    var num = max(100,200);
    console.info(num);
</code></pre>

<h3>Function 对象</h3>
<pre><code>Function 是一种函数类型,可以创建对象, 并且每一个已经声明的函数, 都是一个函数对象!

通过new创建对象格式: 

    var 函数名 = new Function(参数1,参数2...参数n,&quot;函数体&quot;);

案例: 

    var max = new Function(&quot;x&quot;,&quot;y&quot;,&quot;return x&gt;y?x:y;&quot;);

    与下述代码效果一致 !

    function max(x,y){
        return x&gt;y?x:y;
    }   
</code></pre>

<h3>匿名函数</h3>
<pre><code>function(参数列表){
    函数体
}

一般我们使用匿名函数, 是用来进行参数的传递的 !
</code></pre>

<h3>特殊的匿名函数格式</h3>
<pre><code>~(function(){
})();

void function(){
    //经权威机构测试,效率最高! 
}();

~function(){
}();
+function(){
}();
-function(){
}();
!function(){
}();
</code></pre>

<h3>常见的全局函数</h3>
<pre><code>isNan(字符串)  : 判断不是数字, 非数字返回true , 数字返回false

eval(&quot;字符串&quot;) : 将参数中的字符串, 转换为JS代码, 并执行!
</code></pre>

<h5>URI编码</h5>
<pre><code>将文字转换为 %16进制数字的形式!

    var 转码后 = encodeURI(转码前的文字)
</code></pre>

<h5>URI解码</h5>
<pre><code>将%16进制 的数据, 按照uri解码 !

    var 解码后 = decodeURI(解码前的文字);
</code></pre>

<h3>DOM对象</h3>
<pre><code>Html Document Object Model : 文档对象模型
</code></pre>

<h5>通过文档对象 获取元素对象 *****</h5>
<pre><code>1.  通过元素的id属性, 获取一个元素对象

    var element = document.getElementById(&quot;id值&quot;);

2.  通过元素的标签名称 , 获取元素的对象数组
    var eleArray = document.getElementsByTagName(&quot;标签名&quot;);

3.  通过元素的name属性 , 获取元素的对象数组
    var eleArray = document.getElementsByName(&quot;name值&quot;);

4.  通过元素的class属性值, 获取元素的对象数组
    var eleArray = document.getElementsByClassName(&quot;class值&quot;);

在一个元素事件所触发的代码块 或 函数中, 可以通过this 寻找当前触发事件的元素对象 !
</code></pre>

<h5>JS中通过元素对象 对属性进行操作的方式 *****</h5>
<pre><code>属性值的获取: 

    var 属性值 = 元素对象.属性名;

属性值的设置:

    元素对象.属性名 = 属性值;


特殊的不能通过上述套路, 完成获取与设置的值: 

1.  class属性: 

    获取class属性: 
        var class = 对象.className;
    设置class属性:
        对象.className = &quot;值&quot;;

2.  设置与获取元素的文本节点

    获取文本节点:
        var text = 元素对象.innerHTML;
    设置文本节点:
        元素对象.innerHTML= &quot;文本&quot;;
</code></pre>

<h3>案例:</h3>
<pre><code>用户注册的页面, 当用户输入帐号后, 
如果帐号不匹配规则,  则在用户账户输入框后面 显示红色文本 提示
如果匹配规则,  则在帐号后显示绿色文本 提示

HTML部分:
    &lt;div id=&quot;content&quot;&gt;
        &lt;h1&gt;用户注册&lt;/h1&gt;
        &lt;p&gt;&lt;span&gt;帐号:&lt;/span&gt;&lt;input placeholder=&quot;请输入帐号&quot; onblur=&quot;test(this.value)&quot;/&gt;&amp;nbsp;&amp;nbsp;&lt;span id=&quot;uname_ph&quot;&gt;&lt;/span&gt;&lt;/p&gt;    
        &lt;p&gt;&lt;span&gt;密码:&lt;/span&gt;&lt;input placeholder=&quot;请输入密码&quot;/&gt;&lt;span id=&quot;upass_ph&quot;&gt;&lt;/span&gt;&lt;/p&gt;  
    &lt;/div&gt;

CSS部分:
    #content{
        text-align:left;
        width:500px;
        margin: 0 auto;
    }

JS部分:

    function test(uname){
        var reg = /^(13[0-9]|15[012356789]|17[01235678]|18[0-9]|199)[0-9]{8}$/g;
        var uname_ph = document.getElementById(&quot;uname_ph&quot;);
        if(reg.test(uname)){
            //用户输入的帐号符合我们的注册规则
            uname_ph.innerHTML = &quot;恭喜你! 帐号可用!&quot;;
            uname_ph.style=&quot;color:#239923;font-size:12px;&quot;;
        }else{
            //用户输入的帐号不符合我们的注册规则
            uname_ph.innerHTML = &quot;恭喜你! 帐号不符合规则 !&quot;;
            uname_ph.style=&quot;color:#f00;font-size:12px;&quot;;
        }
    }
</code></pre>

<h3>案例</h3>
<pre><code>图片点击切换

JS部分: 

    &lt;script type=&quot;text/javascript&quot;&gt;
        var arr = new Array(&quot;images/img_1.jpg&quot;,&quot;images/img_2.jpg&quot;,&quot;images/img_3.jpg&quot;);
        var index = 0;
        function test(img){
            if(index==3){
                index = 0;
            }
            img.src=arr[index++];
        }
    &lt;/script&gt;


HTML部分:

    &lt;img src=&quot;images/img_3.jpg&quot; onclick=&quot;test(this)&quot;&gt;
</code></pre>

<h3>根据节点层次 查找节点 了解</h3>
<pre><code>-   一次查询单个节点
    -   元素对象.parentNode : 获取当前元素父元素对象
    -   元素对象.firstChild : 获取当前元素第一个子节点
    -   元素对象.lastChild  : 获取当前元素最后一个子节点


-   一次查询一组节点
    -   元素对象.childNodes : 获取一个元素数组, 表示所有直接子节点对象


    跟过节点可以获取节点名称, 节点文本值, 属性值,节点类型;

        1.  对象.nodeName: 节点名称
        2.  对象.nodeValue: 文本节点返回文本, 属性节点返回属性值 ,元素节点返回null


-   获取元素的所有属性 数组
    元素对象.attributes;
</code></pre>

<h3>创建新节点</h3>
<pre><code>格式:

var element = document.createElement(&quot;元素名称&quot;);
</code></pre>

<h3>通过父元素 添加子元素</h3>
<pre><code>向父元素追加子元素: 
    父元素对象.appendChild(子元素对象);


插入到父元素的参考元素之前: 
    父元素对象.insertBefore(新元素,参考的元素);
</code></pre>

<h3>通过父元素 删除子元素</h3>
<pre><code>父元素.removeChild(&quot;子元素对象&quot;);
</code></pre>

<h3>添加删除元素案例 (选项卡)</h3>
<pre><code>HTML部分

    &lt;p&gt;
        &lt;button onclick=&quot;update(1)&quot;&gt;添加一个选项卡&lt;/button&gt;
        &lt;button onclick=&quot;update(2)&quot;&gt;删除一个选项卡&lt;/button&gt;
    &lt;/p&gt;

    &lt;div id=&quot;page&quot;&gt;
        &lt;div&gt;
            &lt;img src=&quot;images/img_2.jpg&quot; /&gt;
            &lt;p&gt;示例文字&lt;/p&gt;
        &lt;/div&gt;&lt;/div&gt;



CSS部分

    #page div {
        width: 200px;
        height: 180px;
        border: 1px solid #999;
        box-shadow: 5px 5px 5px #999;
        display: inline-block;
        margin: 40px;
    }

    #page div img {
        width: 200px;
    }

    #page div p {
        text-align: center;
        margin: 0px;
        padding: 0px;
        line-height: 60px;
    }


JS部分

    function update(type) {
        switch (type) {
        case 1: {
            var page = document.getElementById(&quot;page&quot;);
            var div = document.createElement(&quot;div&quot;);
            var img = document.createElement(&quot;img&quot;);
            img.src=&quot;images/img_2.jpg&quot;;
            var p = document.createElement(&quot;p&quot;);
            p.innerHTML=&quot;示例文字&quot;;
            div.appendChild(img);
            div.appendChild(p);
            page.appendChild(div);

            break;
        }
        case 2: {
            var page = document.getElementById(&quot;page&quot;);
            page.removeChild(page.lastChild);
            break;
        }
        }
    }
</code></pre>

<h3>JS中三种弹出窗</h3>
<pre><code>1.  弹出一个信息提示框, 用户点击确定

    alert(&quot;弹出的文本&quot;);


2.  弹出一个信息提示框, 用户可以点击确定和取消
    confirm(&quot;弹出的文本&quot;);
    返回值为boolean类型 , 用户点击确定时返回true ,取消返回false


3.  弹出一个带有输入框的提示窗体, 用户输入完毕后, 可以点击确定/取消.
        var text = prompt(&quot;弹出的文本&quot;);

    用户点击确定返回输入的内容, 点击取消返回null
</code></pre>

<h3>方便操作的元素对象 了解</h3>
<h5>select 对象</h5>
<pre><code>属性: 
    -   options: 获取选框列表, option数组
    -   selectedIndex: 获取当前选中的元素下标

函数: 
    -   add(option对象), 追加一个下拉选项
    -   remove(下标), 根据下标移除一个下拉选项

事件:
    onchange: 当选中的元素发生改变
</code></pre>

<h5>option 对象</h5>
<pre><code>创建对象: 

var option = new Option(&quot;展示的文本&quot;,&quot;提交给服务器的值&quot;);

常用属性: 

    -   index   : 获取当前option 在select中的下标
    -   text    : 获取option展示的文本
    -   value   : 获取option提交给服务器的值,也就是value属性
    -   selected: 获取当前是否被选中
</code></pre>

<h3>作业:</h3>
<pre><code>1.  编写注册页面 
    包含 
        -   帐号 : 验证符合邮件规则
        -   密码 : 字母开头 由字母+数字 组成的8-32位字符
        -   重复密码 : 与密码相同!
        -   性别 单选框
        -   爱好 复选框


2.  编写一个购物车页面

    网页中包含一个表格 ,

    拥有 商品的id  名称 图片 价格 数量 

    重点需要添加js代码操作的位置为:  操作(-+删除)

    当点击+ 时, 增加数量, 计算新的价格 (注意数量不能高于99)
    当点击- 时, 减少数量, 计算新的价格 (注意数量不能少于1)

    当点击删除时, 删除当前tr中的内容
</code></pre>


</body>
</html>

