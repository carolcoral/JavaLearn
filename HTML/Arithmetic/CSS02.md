
<h1>CSS 02</h1>
<p>1-8,星期一 8:58:57 </p>
<hr />
<h3>选择器</h3>
<pre><code>元素名称, 类, id选择器
</code></pre>

<h4>组选择器</h4>
<pre><code>通过多个选择器, 在条件都满足时, 锁定一个或多个元素!

语法: 

    选择器1选择器2...选择器n{
    样式;
    }

案例: 

    更改元素名称为div ,且 class属性值为abc元素的文本颜色:

    HTML部分:
        &lt;body&gt;
            &lt;p class=&quot;abc&quot;&gt;高飞&lt;/p&gt;
            &lt;div class=&quot;abc&quot;&gt;高天&lt;/div&gt;
            &lt;span class=&quot;abc&quot;&gt;哈哈哈&lt;/span&gt;
            &lt;div&gt;一二三四五&lt;/div&gt;
        &lt;/body&gt;

    CSS部分:
        div.abc{
            color:red;
        }
</code></pre>

<h4>选择器组</h4>
<pre><code>将一个样式, 应用到多个选择器上, 

格式: 

    选择器1,选择器2,...选择器n{
        样式;
    }

案例: 
    更改元素名称为div 或者 class属性值为abc的元素 文本颜色

    HTML部分:
        &lt;body&gt;
            &lt;p class=&quot;abc&quot;&gt;高飞&lt;/p&gt;
            &lt;div class=&quot;abc&quot;&gt;高天&lt;/div&gt;
            &lt;span class=&quot;abc&quot;&gt;哈哈哈&lt;/span&gt;
            &lt;div&gt;一二三四五&lt;/div&gt;
        &lt;/body&gt;

    CSS部分:
        div,.abc{
            color:red;
        }
</code></pre>

<h3>派生选择器	熟练掌握</h3>
<h4>子选择器</h4>
<pre><code>通过父元素选择器  结合 子元素选择器 , 寻找父元素的直接子元素 !

格式:

    父元素选择器&gt;子元素选择器{
        样式;
    }

案例: 更改div中的直接子元素p文本颜色为红色;

    HTML部分:
        &lt;p&gt;一二三四五&lt;/p&gt;
        &lt;div&gt;
            &lt;p&gt;六七八九十&lt;/p&gt;
        &lt;/div&gt;

    CSS部分:

        div&gt;p{
            color:red;
        }
</code></pre>

<h4>后代选择器</h4>
<pre><code>与子元素选择器基本一致, 不过后代选择器 可以选中间接子元素 !

格式: 

    父元素选择器 后代选择器{
        样式;
    }

案例:

    更改id为menu元素中的所有li , 文本颜色为白色;

    HTML部分:
        &lt;div id=&quot;menu&quot;&gt;
            &lt;ul&gt;
                &lt;li&gt;一二三四五&lt;/li&gt;
                &lt;li&gt;六七八九十&lt;/li&gt;
            &lt;/ul&gt;
        &lt;/div&gt;
            &lt;ul&gt;
                &lt;li&gt;山上有座庙&lt;/li&gt;
                &lt;li&gt;从前有座山&lt;/li&gt;
            &lt;/ul&gt;
    CSS部分:

        #menu li{
            color:#fff;
        }
</code></pre>

<h3>伪类选择器</h3>
<pre><code>对于超链接状态的处理 

-   未被访问的超链接样
    -   :link

-   被点击时的超链接
    -   :active

-   访问后的超链接
    -   visited


案例: 

    修改当前页面 所有的超链接样式, 

    未被访问时, 颜色为#333 , 激活时颜色为#666 , 访问后颜色为#999

    HTML部分:

        &lt;a href=&quot;https://www.baidu.com&quot;&gt;点击去百度一下&lt;/a&gt;


    CSS部分:
        a:link{
            color:#333;
        }

        a:active{
            color:#666;
        }

        a:visited{
            color:#999;
        }
</code></pre>

<h3></h3>
<pre><code>鼠标悬停的样式 ,当鼠标滑出后, 样式自动恢复
:hover
</code></pre>

<h3></h3>
<pre><code>当焦点获取时
:focus
案例: 
    当焦点获取后, 更改输入框中的文本颜色为: 绿色;

    input:focus{
        #239923;        
    }
</code></pre>

<h2>常用样式</h2>
<h3>背景</h3>
<h5>背景颜色	***</h5>
<pre><code>background-color:颜色单词,#rgb,#rrggbb,rgb(r,g,b),rgba(r,g,b,a);

    -   rgb(0-255,0-255,0-255);
    -   rgba(0-255,0-255,0-255,0.0-1.0);

案例: 给body设置背景颜色

    body{
        background-color:rgba(100,255,100,0.5); 
    }

注意: 

    背景 颜色可以简写, 默认background属性 就是在修改背景颜色, 例如上述案例, 可以简写为:
    body{
        background:rgba(100,255,100,0.5);   
    }
</code></pre>

<h5>背景图片	***</h5>
<pre><code>在进行背景图片设置时, 可以指定多个图片, 图片指定越靠前, 图片的优先级越高 !

格式: 

    background-image:url(&quot;图片地址&quot;),url(&quot;图片地址&quot;);

案例: 

    给一个宽高为500的div , 设置三个大小不同的背景图片, 控制平铺为不平铺

    HTML部分:
        &lt;div&gt;

        &lt;/div&gt;

    CSS部分:

    div {
        width:500px;
        height:500px;
        background-image: url(&quot;images/bg1.png&quot;),url(&quot;images/bg2.png&quot;),url(&quot;images/bg3.png&quot;);
        background-repeat: no-repeat;
    }
</code></pre>

<h5>控制图片平铺</h5>
<pre><code>默认 ,我们的背景图片, 在水平与垂直方向会自动重复出现 (平铺)

    控制: background-repeat: 

            取值: 
                -   repeat: 默认效果
                -   repeat-x: 仅横向平铺
                -   repeat-y    : 仅垂直平铺
                -   no-repeat: 不平铺
</code></pre>

<h5>背景图片的缩放</h5>
<pre><code>background-size:x,y;

x,y 表示 背景占用元素宽高的百分比, 100%表示撑满!
</code></pre>

<h5>背景图片的滚动</h5>
<pre><code>background-attachment:

    -   scroll  : 跟随内容滑动而滑动
    -   fixed   : 内容滑动时, 背景固定
</code></pre>

<h5>背景 - 精灵图片的使用</h5>
<pre><code>步骤: 

    1.  根据精灵图片中要使用的部分的 宽高, 创建一个相同宽高的 标签 ;
    2.  通过  background-image 指定元素的背景图片为 整个精灵图片 !
    3.  通过background-position: 来制定当前标签背景图片的初始位置!


background-position的使用: 

    background-position:x y;

    x和y的取值, 采用px, 


案例: 

    HTML部分:

        &lt;div id=&quot;title&quot;&gt;
            &lt;ul&gt;
                &lt;li&gt;&lt;a href=&quot;#&quot; title=&quot;QQ聊天&quot;&gt;&lt;span class=&quot;icon1&quot;&gt;&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;
                &lt;li&gt;&lt;a href=&quot;#&quot; title=&quot;关注微博&quot;&gt;&lt;span class=&quot;icon2&quot;&gt;&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;
                &lt;li&gt;&lt;a href=&quot;#&quot; title=&quot;豆瓣主页&quot;&gt;&lt;span class=&quot;icon3&quot;&gt;&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;
                &lt;li&gt;&lt;a href=&quot;#&quot; title=&quot;人人网&quot;&gt;&lt;span class=&quot;icon4&quot;&gt;&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;
                &lt;li&gt;&lt;a href=&quot;#&quot; title=&quot;发送邮件&quot;&gt;&lt;span class=&quot;icon5&quot;&gt;&lt;/span&gt;&lt;/a&gt;&lt;/li&gt;
            &lt;/ul&gt;
        &lt;/div&gt;

    CSS部分:

        #title li {
            display: inline-block;
            width:30px;
            text-align: center; 
        }

        #title li span {
            display: inline-block; width : 16px;
            height: 16px;
            width: 16px;
        }

        .icon1 {
            background-image: url(&quot;images/bg_icon.gif&quot;);
            background-position: -0px -102px;
        }
        .icon2 {
            background-image: url(&quot;images/bg_icon.gif&quot;);
            background-position: -0px 0px;
        }
        .icon3 {
            background-image: url(&quot;images/bg_icon.gif&quot;);
            background-position: -0px -33px;
        }
        .icon4 {
            background-image: url(&quot;images/bg_icon.gif&quot;);
            background-position: -0px -51px;
        }
        .icon5 {
            background-image: url(&quot;images/bg_icon.gif&quot;);
            background-position: -0px -85px;
        }
</code></pre>

<h3>边框	***</h3>
<pre><code>格式: 

    border:宽度px,样式,颜色值; *****

    border-left:宽度px,样式,颜色值;
    border-top...
    border-right...
    border-bottom...

边框样式取值: 

    1.  实线: solid
    2.  虚线: dashed
    3.  点线: dotted


案例: 

    给img元素 设置边框为1px , 点线 , 红色;

    img{
        border:1px dotted red;
        width:300px;
        height:300px;
    }
</code></pre>

<h3>边框圆角	*</h3>
<pre><code>格式: 

    border-radius:圆角宽度;


注意: 

    如果元素的宽度和高度一致, 圆角宽度指定为50%时, 为圆形!

    圆角外面的元素内容 会被舍弃掉 !

案例: 

    圆角图片: 

        CSS部分:

        img{
            border:1px solid red;
            border-radius:50%;
            width:300px;
            height:300px;
        }


    圆角按钮:

        CSS部分:

        button{
            border:1px solid red;
            display: inline-block;
            padding-top: 15px;
            padding-bottom: 15px;
            padding-left: 22px;
            padding-right: 22px;
            font-size: 20px;
            background: #fff;
            border-radius: 5px;
        }

        button:hover{
            background: red;
            color:#fff;
        }
</code></pre>

<h3>处理溢出边框的内容</h3>
<pre><code>格式: 

    overflow:

        取值: 

            -   visible : 溢出内容可见 .默认值
            -   hidden  : 溢出部分隐藏
            -   scroll  : 给元素添加滚动条, 滑动展示内容
            -   auto    : 自适应效果, 当内容过多时, 自动添加滚动条, 内容没有溢出时, 不会出现滚动条!
</code></pre>


</body>
</html>

