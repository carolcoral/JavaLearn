
<h1>CSS 03</h1>
<hr />
<h3>盒模型	*****</h3>
<pre><code>元素占用的空间大小: 

    宽度: width+左右边框宽度+左右内边距的宽度+左右外边距的宽度

    高度: height+上下边框宽度+上下内边距的宽度+上下外边距的宽度
</code></pre>

<h5>内边距	*****</h5>
<pre><code>元素自身内容, 距离边框的距离 !

语法: 

    padding-left:长度单位;      设置左内边距
    padding-top:长度单位;       设置上内边距
    padding-right:长度单位;     设置右内边距
    padding-bottom:长度单位;        设置下内边距;

语法2:

    padding:左,上,右,下;

语法3:
    padding:长度;
</code></pre>

<h5>外边距	*****</h5>
<pre><code>元素的边框, 距离外部其他元素的 盒模型的距离 !

语法: 

    margin-left:长度单位;       设置左外边距
    margin-top:长度单位;        设置上外边距
    margin-right:长度单位;      设置右外边距
    margin-bottom:长度单位;     设置下外边距;

语法2:

    margin:左,上,右,下;

语法3:
    margin:长度;
</code></pre>

<h3>***</h3>
<pre><code>通过外边距的设置, 可以让元素在父元素中 横向居中

margin: 0 auto;
</code></pre>

<h5>设置元素中的文本  垂直居中	***</h5>
<pre><code>在网页中, 文本在文本行中 , 会自动垂直居中 !

我们通过设置文本的行高, 将行高设置为父元素的高度, 则可以实现文本的垂直居中 !

line-height: xxpx;
</code></pre>

<h3>在设置CSS时, 可以设置当前样式 采用父元素继承	 	了解</h3>
<pre><code>将任意样式的值, 指定: inherit
</code></pre>

<h3>文字样式	***</h3>
<pre><code>-   字体设置: 
    -   font-family:&quot;宋体&quot;;

-   字体样式:
    -   font-style:
        -   normal : 默认样式
        -   italic : 倾斜
        -   oblique: 斜体

-   字体大小
    -   font-size  : 长度单位;

-   字体加粗
    -   font-weight:bold;

-   字体颜色:
    -   color:颜色值;

-   文本排列方式
    -   text-align:left/center/right;

-   文字修饰
    -   text-decoration:
        -   underline:下划线
        -   overline: 上划线
        -   line-through: 删除线

-   行高设置
    -   line-height:长度;

-   首行文本缩进
    -   text-indent:2em;


-   文字阴影(CSS3样式)

    -   text-shadow:横向偏移量 垂直偏移量 [阴影的模糊距离] 阴影颜色;
</code></pre>

<h3>表格样式	了解</h3>
<pre><code>table 标签 在添加边框时, 会出现一些问题(双层边框) ; 

解决: 

    先按照盒模型设置边框的方式, 给table标签和 td标签设置边框 !

    然后通过如下表格边框样式, 修改双层边框问题:

    border-collapse:collapse;
</code></pre>

<h3>列表样式 熟悉</h3>
<pre><code>无论是有序列表ol 还是无序列表ul , 都可以通过list-style-type来修改列表前的文字或图形样式!

list-style-type

    无序列表取值 ul:
        -   none    : 不显示   *****
        -   disc    : 实心圆
        -   circle  : 空心圆
        -   square  : 实心方块



    有序列表取值:
        -   none    : 不显示
        -   decimal : 数字显示
        -   lower-romen: 小写罗马数字
        -   upper-romen: 大写罗马数字
</code></pre>

<h3></h3>
<pre><code>自定义列表前置 图片      了解

给li添加如下样式: 

格式: 

        list-style-image:url(&quot;图片地址&quot;);


案例: 

    .menu1{
        list-style-image: url(&quot;images/img1.png&quot;);
    }
    .menu2{
        list-style-image: url(&quot;images/img2.png&quot;);
    }
    .menu3{
        list-style-image: url(&quot;images/img3.png&quot;);
    }
    .menu4{
        list-style-image: url(&quot;images/img4.png&quot;);
    }
    .menu5{
        list-style-image: url(&quot;images/img5.png&quot;);
    }
</code></pre>

<h5>鼠标形状	***</h5>
<pre><code>cursor:

    常用取值: 

        -   default : 默认 指针
        -   auto    : 自动
        -   pointer : 手指
        -   text    : 工字形 , 焦点形状
        -   wait    : 等待
        -   help    : 帮助
</code></pre>

<h3>定位 *****</h3>
<pre><code>元素按照定位的模式, 进行显示. 

例如 , 默认定位下, 元素从上至下排列, 行内元素从左至右排列 !
</code></pre>

<h5>默认定位 ***</h5>
<pre><code>元素按照不同的元素分类, 拥有自己的默认显示模式: 

-   块元素: block
    独占一行, 可以设置宽高,多个块元素从上至下排列 , 常见块元素: h1-h6 p div 
-   行内元素: inline
    多个行内元素, 共享一行, 无法设置宽高 , 从左至右在一行内排列 ! 常见的行内元素: a span button b i
-   行内块元素: inline-block
    多个行内块元素, 共享一行, 可以设置宽高, 从左至右在一行内排列, 常见的行内块元素: input , img
</code></pre>

<h3></h3>
<pre><code>修改默认定位下, 元素的显示模式 *****

display: 

    -   none    : 隐藏元素
    -   block   : 设置为块元素
    -   inline  : 设置为行内元素
    -   inline-block:设置为行内块元素
</code></pre>

<h5>浮动定位 ***</h5>
<pre><code>被添加了浮动的元素, 不会再使用默认定位,进行元素的显示 . 

浮动的作用: 

    将一个元素, 放置到父元素的 左边 或者 右边 ! 元素依然在父元素的内部.

格式: 

        float:left/right;


清除浮动的影响:

    可以设置一个元素的某个方向,  清除浮动影响 !

    clear: left/right/both;
</code></pre>

<h5>相对定位, 绝对定位, 固定定位 . 确定元素位置的方式 *****</h5>
<pre><code>通过4个样式 ,来确定元素处于的位置

1.  left:  表示元素偏移或距离左侧的位置
2.  right: 表示元素偏移或距离右侧的位置
3.  top: 表示元素偏移或距离上边的位置
4.  bottom: 表示元素偏移或距离下边的位置


注意: 一般情况下我们只需要通过两个样式 即可指定元素的位置 .
</code></pre>

<h5>修改定位中的 元素堆叠顺序 *****</h5>
<pre><code>z-index:数字;

    z-index数字的值越大, 表示距离用户越近 !

    值越小, 距离用户越远 , 默认的值为0 ;

    如果多个堆叠的元素, z-index值相同, 那么元素编写靠后的 显示在前面 !
</code></pre>

<h5>相对定位 ***</h5>
<pre><code>格式: 

    position:relative;

相对定位的元素 会占用网页的空间, 且会覆盖其他元素 !

在相对定位中, left ,right ,top ,bottom属性的偏移值

含义为: 

    元素相对于自身正常的坐标 的 偏移值 !

例如: 一个元素原本所在的位置: x:100,y:100

    指定了 bottom:10px,right:10px;  那么它的位置就到了 x:90,y90
</code></pre>

<h5>绝对定位 *****</h5>
<pre><code>格式: 

    position: absolute;


绝对定位的元素 不会占用网页的空间,它会覆盖其它元素 ,

在绝对定位中 left , right , top , bottom属性的值表示距离body 或 最近的绝对定位/固定定位祖先元素的边框 ! 
</code></pre>

<h5>固定定位 *****</h5>
<pre><code>格式: 
    position:fixed;

将元素的位置, 固定在浏览器的某一个位置, 不跟随网页的滑动而滑动, 且不占用任何的网页空间

在绝对定位中 left , right , top , bottom属性的值表示距离浏览器窗口的距离 ! 
</code></pre>

<h1>HTML5</h1>
<pre><code>HTML5版本与HTML4版本的区别:     了解

1.  doctype声明
    HTML4: &lt;!DOCTYPE html PUBLIC &quot;-//W3C//DTD HTML 4.01 Transitional//EN&quot; &quot;http://www.w3.org/TR/html4/loose.dtd&quot;&gt;
    HTML5: &lt;!DOCTYPE html&gt;

2.  字符编码设置
    HTML4: &lt;meta http-equiv=&quot;Content-Type&quot; content=&quot;text/html;charset=UTF-8&quot;&gt;
    HTML5: &lt;meta charset=&quot;UTF-8&quot;&gt;

3.  大小写不敏感
    标签名称大小写不敏感 ,
    属性名称大小写不敏感 , 
    固定属性值大小写不敏感

    例如:
        &lt;iNPut TyPe=&quot;BuTTON&quot; value=&quot;按钮&quot;&gt;

4.  布尔值属性
        有的属性, 仅有两种取值 , 一般表示ture/false

        在HTML5版本中, 更改了部分Boolean类型的属性, 只要属性出现, 任意赋值或不赋值, 都表示true

    例如:
        &lt;audio src=&quot;https://itdage.cn/mp3/sf.mp3&quot; controls &gt;&lt;/audio&gt;

5.  引号省略
    如果属性的值中不存在特殊的字符, 可以省略双引号 

    例如: &lt;input type=button value=哈哈哈&gt;

6.  省略结尾标签
    可以不编写结束标签
</code></pre>

<h3>HTML5新增标签</h3>
<h5>新增结构标签 *</h5>
<pre><code>在HTML5之前 , 我们使用DIV进行块的划分, 在HTML5中给DIV派生了一些标签, 用来语义化的表示结构
section标签
    表示页面中的内容区域 , 比如章节/页眉/页脚..等 表示文档结构
article标签
    表示页面中一块与上下文不相关的独立内容 , 比如一篇文章
aside标签
    与article进行辅助的 , 文章内容之外的
header标签
    整个页面的标题, 头部
hgroup标签
    表示对整个页面或页面中的一个内容区域的标题的组合
nav标签
    表示页面中导航连接部分
figure标签
    表示一段独立的流内容 , 一般用来表示文档主体流内容中的一个独立单元 , 使用figcaption为figure标签组添加标题
</code></pre>

<h5>新增多媒体标签 ***</h5>
<pre><code>1.   音乐播放 audio

    -   src :   音乐地址, 本地相对地址,网络地址
    -   autoplay:   html5版本的boolean类型属性, 属性只要出现就表示true ; true表示自动播放
    -   controls:   添加播放器的控制器

    案例: https://itdage.cn/mp3/sf.mp3

    &lt;audio src=&quot;https://itdage.cn/mp3/sf.mp3&quot; autoplay=&quot;1&quot;&gt;&lt;/audio&gt;

    尽量使用mp3格式


2.  视频播放 video

    -   src :   视频地址, 本地相对地址,网络地址
    -   autoplay:   html5版本的boolean类型属性, 属性只要出现就表示true ; true表示自动播放
    -   controls:   添加播放器的控制器

    案例: mp4/xwzydr.mp4

    &lt;video src=&quot;mp4/xwzydr.mp4&quot; controls=&quot;1&quot;&gt;您的浏览器版本过低, 暂不支持HTML5视频播放&lt;/video&gt;

    尽量使用mp4格式

3. 多媒体播放 embed (目前一般用来做动画播放)

    -   src :   动画地址

    案例:

        &lt;embed src=&quot;https://itdage.cn/shiba.swf&quot;&gt;&lt;/embed&gt; 
</code></pre>

<h5>新增表单 type属性 熟悉</h5>
<pre><code>在HTML5 . 给input标签, 增加了更多的type属性 

email   :   必须输入邮件 (大多数浏览器是不支持的)    
url     :   输入url地址 (大多数浏览器是不支持的)
number  :   只能输入数字 , 且会存在一个数字的加减按钮 ***
color   :   调色板
</code></pre>

<h3>熟悉</h3>
<pre><code>日期类的input的type属性


date    :   输入年月日 ***
month   :   输入年月
week    :   输入年周
time    :   输入时间 (时分秒)
datetime:   输入年月日时间 -- 大多数浏览器不支持
datetime-local  : 输入本地年月日时间 
</code></pre>

<h5>新增的其它标签	了解</h5>
<pre><code>mark    :   高亮显示的文本片段

progress:   进度条
        max属性:  进度条最大值
        value属性:进度条当前值

time    :   描述时间,  方便搜索引擎收录

wbr     :   软换行
</code></pre>

<h5>可扩展内容区域	了解</h5>
<pre><code>&lt;details&gt;
    &lt;summary&gt;展开查看&lt;/summary&gt;
    这里的文字 就是展开后的文字
&lt;/details&gt;
</code></pre>

<h5>联想文本输入框	了解</h5>
<pre><code>步骤1.
        先编写被联想的文本列表
        使用datalist标签 + option标签创建列表, 并指定id属性(id属性是用来关联输入框的)
        &lt;datalist id=&quot;mydata&quot;&gt;
            &lt;option value=&quot;高飞飞&quot;&gt;
            &lt;option value=&quot;高飞飞爱搅基&quot;&gt;
            &lt;option value=&quot;高飞飞喜欢喝牛奶&quot;&gt;
            &lt;option value=&quot;高飞飞喜欢吃香蕉&quot;&gt;
            &lt;option value=&quot;哈哈哈哈哈哈&quot;&gt;
        &lt;/datalist&gt;

步骤2.编写一个input输入框,  并将datalist绑定到输入框的list属性中

    input标签的list属性, 可以指定一个datalist的id.

    &lt;input list=&quot;mydata&quot;&gt;
</code></pre>

<h5>HTML5 过时标签	了解</h5>
<pre><code>被废弃的标签, 在HTML5版本中, 依然可以使用, 大致分为三类: 

    1.  所有的样式标签 , 因为这些标签可以被CSS所替代, 所以更推荐使用CSS来完成, 
        例如: i b center ...
    2.  废弃了一些frame框架, 仅保留了一个frame框架 : iframe
    3.  废弃了一些 大多数浏览器厂商 在html4版本中未支持的标签 !
</code></pre>

</body>
</html>

