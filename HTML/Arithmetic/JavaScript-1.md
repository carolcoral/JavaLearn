<h1>JavaScript</h1>
<hr />
<h3>简介 ***</h3>
<pre><code>JavaScript 是一种网页编程技术，用来向 HTML 页面添加交互行为
JavaScript 是一种基于对象和事件驱动的解释性脚本语言，直接嵌入 HTML 页面，由浏览器解释执行代码，不进行预编译。
</code></pre>

<h3>特点:</h3>
<pre><code>因为JavaScript是嵌入在HTML中的, 所以可以任何的文本编辑工具进行代码的编写, 

因为HTML是浏览器解析的, 那么JS 只要使用浏览器 就可以执行 !

JS不具备操作计算机本地资源的能力 !

不进行预编译, 代码逐行解析执行 !

JS中内置了大量的对象, 这些对象封装了大量的对于网页操作以及与用户交互的 API

我们一般使用JS 来完成客户端数据的计算, 表单的验证, 事件的触发, 动画效果的制作等..
</code></pre>

<h3>元素的事件属性</h3>
<pre><code>在网页开发中, 每一个元素 都存在一些onXXX的属性 , 这些属性表示当 元素遇到XXX的情况时, 自动触发的代码块 !

例如: 

        onClick属性

    表示元素遇到点击情况时, 自动触发的代码块 !
</code></pre>

<h3>浏览器弹出 提示框</h3>
<pre><code>alert(&quot;要弹出的文本&quot;);
</code></pre>

<h3>三种编写JS的方式 *****</h3>
<pre><code>1.  在元素的事件属性中, 直接编写代码

    案例: &lt;button onclick=&quot;alert('高飞哈哈哈')&quot;&gt;示例按钮&lt;/button&gt;


2.  在HTML文件的script标签中, 编写代码
    案例: 
        &lt;script type=&quot;text/javascript&quot;&gt;
            for(i=0;i&lt;1000;i++){
                alert(&quot;哈哈哈哈哈哈哈哈哈哈&quot;+i);
            }
        &lt;/script&gt;

3.  在外部的.js文件中编写代码 , 并将JS文件引入到HTML中

    在用来引入js文件的script标签中, 是不能编写JS代码的, 无效!
</code></pre>

<h3>注释</h3>
<pre><code>在JS中可以使用单行注释, 多行注释 ! 语法与Java一致!

//单行注释

/*多行注释*/
</code></pre>

<h4>如何定义变量</h4>
<pre><code>java:   强类型语言

    int x = 10;
    x=11;
    x=&quot;你好&quot;;

js  :   弱类型语言

    var x = 10;
    x=11;
    x=&quot;你好&quot;;
</code></pre>

<h4>JS常用数据类型 **</h4>
<pre><code>基本数据类型
    Number  :   数值类型
    string  :   字符串
    Boolean :   布尔

复杂数据类型
    Array   :   数组
    Object  :   对象

特殊数据类型
    Null    :   空类型数据
    undefined:  未定义
</code></pre>

<h3>问下述两个表达式的执行结果是否存在区别, 区别在哪儿?</h3>
<pre><code>text = &quot;哈哈哈&quot;+1+2+3+4+5

    //  哈哈哈12345

text= 1+2+3+4+5+&quot;哈哈哈&quot;;

    //15哈哈哈
</code></pre>

<h3>类型转换:</h3>
<pre><code>将字符串转换为数字

parseInt(字符串);

Number(字符串);

typeof(数据) :得到类型名称
</code></pre>

<h3>严格相等 ***</h3>
<pre><code>在JS中 

    ==  比较的仅仅是值, 不比较数据类型 !

    案例: 

    1==&quot;1&quot; 的结果为true


严格相等: 

    === 即比较值, 又比较数据类型 !

    案例: 
    1===&quot;1&quot; 的结果为false

严格不相等

    !== 值不同, 且类型不同!
</code></pre>

<h3>console对象 了解</h3>
<pre><code>普通日志输出: 

    console.log(&quot;输出的文本&quot;);

异常调试信息输出:
    console.debug(输出的文本);
    使用debug输出的日志, 会在日志文本的一边添加一个超链接, 可以快速的定位到打印的代码位置

信息提示输出:
    console.info(输出的文本); 在输出时会带有信息图标(一般为蓝色图标)


警告提示输出:
    console.warn(输出的文本);

错误提示输出;
    console.error(输出的文本);


上述的所有函数 , 都是扩展参数列表 , 都可以传递0-n个参数

字符串中的格式化占位符的使用: 

    格式化占位符:     可替换的值 

        %s           字符串
        %d           整数
        %f           浮点型数字
        %o           对象

替换的操作, 上述的所有函数, 参数1中出现的格式化占位符, 按照顺序, 自动使用参数2-n进行填充!


例如: 

    console.log(&quot;姓名:%s,年龄:%d&quot;,&quot;高飞&quot;,18);
</code></pre>
