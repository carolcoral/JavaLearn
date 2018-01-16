
<h1>Jquery</h1>
<p>1-16,星期二 8:59:13 </p>
<hr />
<h3>筛选选择器 - 表单筛选选择器  熟悉</h3>
<pre><code>筛选的是表单组件 input 标签的type属性: 

:input
:text
:password
:radio
:checkbox
:number
:submit
:reset
:button
:hidden
:file
:image
...

案例: 

    HTML部分:

        &lt;input type=&quot;text&quot; placeholder=&quot;请输入帐号&quot;/&gt;
        &lt;input type=&quot;password&quot; placeholder=&quot;请输入密码&quot;/&gt;
        &lt;input type=&quot;submit&quot; value=&quot;登录&quot;/&gt;
    JS部分:

        $(function(){
            $(&quot;:submit&quot;).css(&quot;color&quot;,&quot;#060&quot;);
            $(&quot;:password&quot;).css(&quot;border&quot;,&quot;1px solid #333&quot;);
            $(&quot;:text&quot;).css(&quot;font-size&quot;,&quot;18px&quot;);
        });
</code></pre>

<h3>筛选选择器 - 属性筛选选择器 了解</h3>
<pre><code>格式: 

    -   筛选元素是否存在某属性
        $(&quot;选择器[属性名称]&quot;);

    -   筛选元素的属性值 是否等于某值
        $(&quot;选择器[属性名='值']&quot;);

    -   筛选元素的属性值 是否不等于某值
        $(&quot;选择器[属性名!='值']&quot;);




案例: 

    HTML部分
        &lt;img src=&quot;images/xdl1.jpg&quot; &gt;
        &lt;img src=&quot;images/xdl2.jpg&quot; &gt;
        &lt;img src=&quot;images/xdl3.jpg&quot; &gt;
        &lt;img src=&quot;images/xdl4.jpg&quot; &gt;
    JS部分:
        $(function(){
            $(&quot;img[src='images/xdl2.jpg']&quot;).css(&quot;border&quot;,&quot;1px solid red&quot;);
            $(&quot;img[src!='images/xdl2.jpg']&quot;).css(&quot;width&quot;,&quot;400px&quot;);
        });
</code></pre>

<h3>Jquery常用函数</h3>
<h5>CSS函数	*****</h5>
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

<h5>修获取文本内容</h5>
<pre><code>我们在JS中 通过innerHTML属性, 修改和获取元素的文本内容

在Jquery中通过两个方法, 来进行内容的获取与修改 


1.  html函数  - 与JS中innerHTML效果基本一致 !
    $obj.html() : 获取元素内容
    $obj.html(text) : 设置元素内容

2.  text函数
    $obj.text() : 获取元素文本内容


使用html函数 与text函数 获取如下div的内容 ,结果为: 

    &lt;div&gt;一二三四五&lt;p&gt;六七八九十&lt;/p&gt;&lt;/div&gt;

结果: 

    html(): 一二三四五&lt;p&gt;六七八九十&lt;/p&gt; 
    text(): 一二三四五六七八九十


案例: 

    手机号验证的案例: 

    HTML部分: 

        &lt;input type=&quot;text&quot; placeholder=&quot;请输入注册的帐号&quot;  onblur=&quot;unametest(this)&quot;/&gt;&lt;span id=&quot;uname_ph&quot;&gt;&lt;/span&gt;

    JS部分: 

        function unametest(input){
            var text = $(input).val();      
            var reg = /^(13[0-9]|15[012356789]|17[01235678]|18[0-9]|199)[0-9]{8}$/g;
            if(reg.test(text)){
                $(&quot;#uname_ph&quot;).css({'font-size':'12px','color':'#393'});
                $(&quot;#uname_ph&quot;).html(&quot;恭喜你 , 帐号可用 !&quot;);
            }else{
                $(&quot;#uname_ph&quot;).css({'font-size':'12px','color':'#933'});
                $(&quot;#uname_ph&quot;).html(&quot;很遗憾, 帐号不可用 ~ &quot;);
            }
        }
</code></pre>

<h5>修改和获取所有属性的值 (attr函数) *****</h5>
<pre><code>在JS中 可以通过
    对象.属性名 =  值; 给一个属性赋值, 
    var value = 对象.属性名; 获取一个属性的值

在Jquery中, 我们可以通过attr函数, 获取与设置所有属性的值 !

获取属性格式: 
    var value = $obj.attr(&quot;属性名&quot;);

    注意: Jquery存在一个BUG, 使用attr函数获取value属性值, 不能获取用户输入的内容 ! 只能获取到初始值!

    获取与设置value属性 应通过val()函数

设置属性格式:

    $obj.attr(&quot;属性名&quot;,&quot;属性值&quot;);

删除属性: 

    $obj.removeAttr(&quot;属性名&quot;);


案例: 

    HTML部分
        &lt;img&gt;
        &lt;p&gt;
            &lt;button onclick=&quot;test(1)&quot;&gt;添加src属性&lt;/button&gt;
            &lt;button onclick=&quot;test(2)&quot;&gt;获取src属性&lt;/button&gt;
            &lt;button onclick=&quot;test(3)&quot;&gt;移除src属性&lt;/button&gt;
        &lt;/p&gt;

    JS部分
        function test(type){
            var img = $(&quot;img&quot;);
            switch (type) {
            case 1:{
                img.attr(&quot;src&quot;,&quot;images/xdl3.jpg&quot;);
            }
                break;
            case 2:{
                var src = img.attr(&quot;src&quot;);
                console.info(src);
            }
                break;
            case 3:{
                img.removeAttr(&quot;src&quot;);
            }
                break;
            }
        }   
</code></pre>

<h2>class属性 ***</h2>
<pre><code>class属性的值,  不能通过attr函数进行操作

添加class属性

    格式: $obj.addClass(&quot;值&quot;);


删除class属性:

    格式: $obj.removeClass(&quot;值&quot;);

替换class值: 
        在原来存在class属性值的情况下 进行替换

    格式: $obj.toggleClass(&quot;值&quot;);
</code></pre>

<h5>设置与获取元素的宽高 **</h5>
<pre><code>设置/获取宽度
    设置: $obj.width(宽度); 
    获取: $obj.width();

设置/获取高度     
    设置: $obj.height(高度); 
    获取: $obj.height();


案例: 

    HTML部分:
    &lt;img src=&quot;images/xdl2.jpg&quot;&gt;

    JS部分:
    $(&quot;img&quot;).width(300px);
</code></pre>

<h5>获取元素的宽高 (盒模型)</h5>
<pre><code>-   获取元素自身宽度  ***
    $obj.width();

-   获取元素自身高度  ***
    $obj.height();

-   获取元素自身宽度+内边距
    $obj.innerWidth();

-   获取元素自身高度+内边距
    $obj.innerHeight();

-   获取元素自身宽度+内边距+边框
    $obj.outerWidth();

-   获取元素自身高度+内边距+边框
    $obj.outerHeight();

-   获取元素自身宽度+内边距+边框+外边距
    $obj.outerWidth(true);

-   获取元素自身高度+内边距+边框+外边距
    $obj.outerHeight(true);
</code></pre>

<h3>显示与隐藏函数 ***</h3>
<pre><code>当元素使用隐藏函数后, 元素不再占用任何的空间, 盒模型为0x 0y


-   基本效果 ***
        显示: $obj.show();
        隐藏: $obj.hide();
        切换: $obj.toggle();

-   向左上折叠效果
        显示: $obj.show(毫秒);
        隐藏: $obj.hide(毫秒);
        切换: $obj.toggle(毫秒);

-   上下折叠效果
        显示: $obj.slideDown(毫秒);
        隐藏: $obj.slideUp(毫秒);
        切换: $obj.slideToggle(毫秒);

        元素必须指定确定的宽度 才可以呈现上下折叠的效果 !

-   淡入淡出效果

    淡入: $obj.fadeIn(毫秒); 

    淡出: $obj.fadeOut(毫秒);
</code></pre>

<h3>自定义动画</h3>
<pre><code>格式: 

    $obj.animate(参数1,参数2,[参数3]);

    参数1: JSON对象, 描述动画执行结果的样式
    参数2: 从当前样式, 过渡到参数1的 毫秒!
    参数3: 不是必须传递的参数, 传递一个函数, 动画执行完毕后 会自动调用 !


案例: 

HTML部分: 
    &lt;p&gt;高飞飞飞飞: 我有一只小小小小鸟&lt;/p&gt;
JS部分:

    $(function(){
    test1();
        });

        var test1 = function(){
            $(&quot;p&quot;).animate({&quot;left&quot;:&quot;600px&quot;,&quot;font-size&quot;:&quot;14px&quot;},500,test2);;
        }

        var test2 = function (){
            //当右移动画执行完毕, 设置文字大小发生变化
            $(&quot;p&quot;).animate({&quot;left&quot;:&quot;100px&quot;,&quot;font-size&quot;:&quot;80px&quot;},500,test1);;
        }

CSS部分:
    p{
        position: fixed;
        left:-250px;
        top:50%;
    }
</code></pre>

<h3>元素旋转</h3>
<pre><code>transform:rotate(xxdeg);

参数中传入180deg 表示旋转180度
</code></pre>


</body>
</html>

