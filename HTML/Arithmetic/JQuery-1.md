
<h1>JS、Jquery-1</h1>
<p>2018年01月15日18:07:33</p>
<hr />
<h3>事件冒泡机制</h3>
<pre><code>当HTML元素的事件触发时,  执行完毕 会自动激活父元素的同类事件 !

顺序:  从子元素, 传递到父元素 !
</code></pre>

<h3>取消事件冒泡机制</h3>
<pre><code>两种方式: 

1.  设置取消标记为true , 在当前事件执行完毕后, 不会在进行事件冒泡 !
    event.cancelBubble = true; 

2.  直接停止冒泡
    event.stopPropagation();
</code></pre>

<h3>通过事件对象,  获取事件源 了解</h3>
<pre><code>可以在事件的代码中, 快速的找到触发当前事件的组件 !

如何获取事件源: 

    IE浏览器: event.srcElement;

    其他浏览器:event.target;


建议写法: 

    var element = event.target;

    var element = event.srcElement||event.target;
</code></pre>

<h3>面向对象</h3>
<pre><code>定义对象的三种方式: 

1.  创建对象 , 直接设置属性与方法

    格式:  

        var 对象名 = new Object();
        对象名.属性= 值;
        对象名.函数名= function(){

        }

    案例: 

        var person = new Object();
        person.name = &quot;高飞&quot;;
        person.age = 18;
        person.say = function(){
            console.info(&quot;我是:&quot;+this.name+&quot;,我今年&quot;+this.age+&quot;岁了&quot;);
        }


2.  创建对象模版 , 通过new 使用

    格式: 

    function 模版名(参数列表){
        this.属性= 值;
        this.函数名= function(){

        }
    }


    案例1. 

    function Person(name,age){
        this.name = name;
        this.age = age;
        this.say = function(){
            console.info(&quot;我是:&quot;+this.name+&quot;,我今年&quot;+this.age+&quot;岁了&quot;);
        }
    }
    var p = new Person(&quot;高飞&quot;,19);


    案例2.

    function Person(name,age,say){
        this.name = name;
        this.age = age;
        this.say = say;
    }

    var p = new Person(&quot;大红&quot;,38,function(){
        console.info(&quot;大红哈哈哈哈哈哈哈哈哈&quot;);
    });


3.  使用JSON格式对象
</code></pre>

<h3>JSON *****</h3>
<pre><code>轻量级的数据交换格式 !

一般情况下, 用于网络接口的数据返回 ! 

JSON中 包含两种格式: 

    存储的数据 , key 通过引号引住 ! 
    value: 数字和boolean值 可以不使用引号 ,字符串必须使用引号引住 !

    1.  JSON对象
        JSON对象, 使用{}封装数据 ,每一个数据分为键和值, 键值之间使用:(冒号)连接 , 多个键值之间使用,(逗号)分割! 

        案例: 

        {'name':'高飞','age':20}




    2.  JSON数组

        JSON数组 ,使用[]封装数据 ,分为下标和值, 值与值之间使用,(逗号)分割

        案例:

            描述一组成绩: 

            [100,20,10,100]


------------------------------------------------------

    JSON对象 和 JSON数组 是可以互相嵌套的!



例如: 描述高飞与他的基友们 

    {
        'name':'高飞',
        'age':18,
        'jiyoumen':[
            {'name':'高天','age':38},
            {'name':'大红','age':16},
            {'name':'安杰','age':8}
        ],
        'paoyou':{
            'name':'春龙',
            'age':88
        }
    }


练习: 

    通过json描述一个学生 , 包含学生姓名, 学号, 性别, 年龄.

    {
        'name':'xx',
        'id':10001,
        'sex':'妖',
        'age':18
    }
</code></pre>

<h5>JS中解析JSON</h5>
<pre><code>想要解析JSON中的数据, 首先要将JSON格式的数据, 转换为JOSN格式的对象 ! 然后再操作它的属性.

-   如何在JS中得到一个JSON格式的对象 !

    格式:  var obj = JSON格式数据;/*数据不要给引号*/

    案例: 

        var obj={
            'name':'xx',
            'id':10001,
            'sex':'妖',
            'age':18
        };


-   如何将一个string类型的字符串 , 转换为JSON格式的对象 .

    格式1.    var obj = eval('('+JSON格式字符串+')'); 

    格式2.  var obj = JSON.parse(JSON格式字符串);
</code></pre>

<h3></h3>
<pre><code>如何从JSON格式的对象中, 取出数据: 

    -   根据JSON对象格式中的key ,  取出value

        var value = 对象.key;

    -   根据JSON数组中的下标, 取出value

        var value = 数组[下标];


案例: 

    取出如下JSON格式数据中的 jiyoumen的第一个对象中的name

    var data = {
        'name':'高飞',
        'age':18,
        'jiyoumen':[
            {'name':'高天','age':38},
            {'name':'大红','age':16},
            {'name':'安杰','age':8}
        ],
        'paoyou':{
            'name':'春龙',
            'age':88
        }
    };

    console.info(data.jiyoumen[0].name);
</code></pre>

<h1>JS框架 Jquery</h1>
<p>1-15,星期一 14:08:04 </p>
<hr />
<h3>什么是框架</h3>
<pre><code>别人编写的代码 ! 
</code></pre>

<h3>使用步骤:</h3>
<pre><code>其实就是将框架的代码引入的过程 .

1.  寻找jquery.js文件, 复制到项目中

2.  在HTML中, 引入这个JS文件

    &lt;script type=&quot;text/javascript&quot; src=&quot;js/jquery.js&quot;&gt;&lt;/script&gt;

3.  通过Jquery的Api 就可以进行开发了
    $(function(){
        var text = document.getElementById(&quot;p1&quot;).innerHTML;
        console.info(&quot;:&quot;+text);
    });
</code></pre>

<h3>onload *****</h3>
<pre><code>JS:  

    在body的onload事件中, 调用某函数 实现当网页加载完毕后 调用的效果!

Jquery: 

$(function(){
    //这里代码会在网页加载完毕后, 自动执行!
});
</code></pre>

<h3>Jquery对象</h3>
<pre><code>Jquery对象 , 是一个DOM对象的集合 !

原生的DOM对象, 无法调用Jquery的api

Jquery对象,也无法调用原生DOM对象的api
</code></pre>

<h3>DOM对象 转换为 Jquery对象 ***</h3>
<pre><code>格式:

    var $obj = $(dom);

案例: 

var dom = document.getElementById(&quot;p1&quot;);
var $obj = $(dom);
$obj.css(&quot;color&quot;,&quot;red&quot;);
</code></pre>

<h3>Jquery对象 转换为dom对象 ***</h3>
<pre><code>格式: 

    var dom = $obj.get(下标);

案例: 

    var dom2 = $obj.get(0);
    dom2.innerHTML = &quot;十九八七六 上山打老虎&quot;;
</code></pre>

<h3>Jquery选择器</h3>
<pre><code>Jquery中通过选择器, 查找一个Jquery对象, Jquery对象中包含一个或多个DOM对象 !
</code></pre>

<h3>三个基本选择器 *****</h3>
<pre><code>-   id选择器
    格式: 
        var $obj = $(&quot;#id&quot;);

-   类选择器
    格式:
        var $obj = $(&quot;.class&quot;);


-   标签名称选择器
    格式:
        var $obj = $(&quot;tagName&quot;);
</code></pre>

<h3></h3>
<pre><code>案例: 

    HTML部分: 

        &lt;ul&gt;
            &lt;li&gt;&lt;p class=&quot;p1&quot;&gt;一二三四五&lt;/p&gt;&lt;/li&gt;
            &lt;li&gt;&lt;p id=&quot;ppp&quot;&gt;上山打老虎&lt;/p&gt;&lt;/li&gt;
            &lt;li&gt;&lt;p class=&quot;p1&quot;&gt;老虎不在家&lt;/p&gt;&lt;/li&gt;
            &lt;li&gt;&lt;p&gt;打屁就是他&lt;/p&gt;&lt;/li&gt;
        &lt;/ul&gt;

    JS部分: 
        $(function(){
            $(&quot;p&quot;).css(&quot;color&quot;,&quot;#333399&quot;);
            $(&quot;#ppp&quot;).css(&quot;font-size&quot;,&quot;30px&quot;);
            $(&quot;.p1&quot;).css(&quot;color&quot;,&quot;#336633&quot;);
        });
</code></pre>

<h3>层级选择器</h3>
<pre><code>-   子选择器    *
    格式: 
        $(&quot;父选择器&gt;子选择器&quot;);

    案例:
        HTML部分: 
        &lt;ul&gt;
            &lt;li&gt;&lt;p class=&quot;p1&quot;&gt;一二三四五&lt;/p&gt;&lt;/li&gt;
            &lt;li&gt;&lt;p id=&quot;ppp&quot;&gt;上山打老虎&lt;/p&gt;&lt;/li&gt;
            &lt;li&gt;老虎不在家&lt;/li&gt;
            &lt;li&gt;打屁就是他&lt;/li&gt;
        &lt;/ul&gt;


        JS部分:

            $(&quot;li&gt;p&quot;).css(&quot;color&quot;,&quot;red&quot;);


-   后代选择器   *
    格式: 
        $(&quot;父选择器 后代选择器&quot;);

    案例: 
        HTML部分:
            &lt;ul&gt;
                &lt;li&gt;&lt;p&gt;一二三四五&lt;/p&gt;&lt;/li&gt;
                &lt;li&gt;&lt;p&gt;上山打老虎&lt;/p&gt;&lt;/li&gt;
                &lt;li&gt;老虎不在家&lt;/li&gt;
                &lt;li&gt;打屁就是他&lt;/li&gt;
            &lt;/ul&gt;

        JS部分:
            $(&quot;body li&quot;).css(&quot;color&quot;,&quot;red&quot;);

-   后一个兄弟选择器
    格式:
        $(&quot;参考元素选择器+兄弟选择器&quot;);

    案例: 
        HTML部分:
            &lt;ul&gt;
                &lt;li id=&quot;li_1&quot;&gt;&lt;p&gt;一二三四五&lt;/p&gt;&lt;/li&gt;
                &lt;li&gt;&lt;p&gt;上山打老虎&lt;/p&gt;&lt;/li&gt;
                &lt;li&gt;老虎不在家&lt;/li&gt;
                &lt;li&gt;打屁就是他&lt;/li&gt;
            &lt;/ul&gt;
        JS部分:
            $(&quot;#li_1+li&quot;).css(&quot;color&quot;,&quot;red&quot;);

-   后所有兄弟选择器
    格式: 
        $(&quot;参考元素选择器~兄弟选择器&quot;);

    案例: 
        HTML部分:
            &lt;ul&gt;
                &lt;li&gt;&lt;p&gt;一二三四五&lt;/p&gt;&lt;/li&gt;
                &lt;li id=&quot;li_2&quot;&gt;&lt;p&gt;上山打老虎&lt;/p&gt;&lt;/li&gt;
                &lt;li&gt;老虎不在家&lt;/li&gt;
                &lt;li&gt;打屁就是他&lt;/li&gt;
            &lt;/ul&gt;
        JS部分:
            $(&quot;#li_2~li&quot;).css(&quot;color&quot;,&quot;red&quot;);
</code></pre>

<h3>筛选选择器 了解</h3>
<pre><code>在一个选择器的结果中, 筛选出需要的元素 !
</code></pre>

<h5>基本筛选选择器:</h5>
<pre><code>: first:匹配第一个元素 
: last:匹配最后一个元素
: not:过滤not条件:$(“div:not(.class)”);
: even:匹配下标偶数       
: odd:匹配下标奇数        
: eq:选择指定索引值 :$(“div:eq(1)”)    
: gt:匹配索引值大于x的:$(“div:gt(5)”)   
:lt:匹配索引值小于x的:$(“div:lt(5)”)



案例:  

    HTML部分:
        &lt;p&gt;床前明月光&lt;/p&gt;
        &lt;p&gt;疑是地上霜&lt;/p&gt;
        &lt;p&gt;举头望明月&lt;/p&gt;
        &lt;p&gt;回家没有票&lt;/p&gt;

    JS部分: 
        $(&quot;p:odd&quot;).css(&quot;font-size&quot;,&quot;64px&quot;);
</code></pre>

<h3>内容筛选选择器</h3>
<pre><code>-   筛选内容是否包含 某文本
        格式: 
            $(&quot;选择器:contains('包含的文本')&quot;);

        案例:  
            HTML部分: 

            &lt;p&gt;从前有座山&lt;/p&gt;
            &lt;p&gt;山上有个尼姑庵&lt;/p&gt;
            &lt;p&gt;是一个不错的洗脚店&lt;/p&gt;
            &lt;p&gt;店里有个老板娘&lt;/p&gt;
            &lt;p&gt;对高飞说:哈哈哈哈哈哈哈哈&lt;/p&gt;

            JS部分: 

            $(&quot;p:contains('有个')&quot;).css(&quot;color&quot;,&quot;red&quot;);



-   筛选内容是否为空
        格式:
            $(&quot;选择器:empty&quot;);
        案例:

        html部分: 
            &lt;div&gt;111111122222233333&lt;/div&gt;
            &lt;div&gt;&lt;/div&gt;

        JS部分: 

            $(&quot;div:empty&quot;).css({
                'width':'500px',
                'height':'500px',
                'border':'1px solid red'
            });
</code></pre>

<h3>筛选选择器 ,可见性</h3>
<pre><code>:hidden   选取隐藏的对象

:visible  选取显示的对象

哪些元素是隐藏的: 

    1.  display:none;
    2.  input元素的type属性设置为hidden
    3.  宽度和高度为0的

案例:
</code></pre>

<h3>jquery 的 CSS函数</h3>
<pre><code>用来修改元素的显示样式 . 

使用方式: 

方式一:  

    css(&quot;样式key&quot;,&quot;样式值&quot;);
    传入一个样式键值对, 来完成元素的单个样式的指定 !

方式二:

    css(JSON对象);
    传入一个描述样式的JSON数据 !

    例如: 

    css({
        'color':'red',
        'font-size':'18px'
    }); 
</code></pre>


</body>
</html>

