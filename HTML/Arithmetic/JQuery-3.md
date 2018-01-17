
<h1>Jquery</h1>
<p>2018年01月17日14:05:15</p>
<hr />
<h3>Jquery事件</h3>
<pre><code>在JS中, 我们通过元素的onXXX属性, 指定事件触发的代码 ,  这种原生的操作, 让我们的JS脚本和HTML元素之间耦合过高 !

在Jquery框架中 , 我们可以通过选择器, 锁定一个或一组元素, 然后再通过Jquery的函数 , 给元素添加事件!
</code></pre>

<h5>绑定 / 解绑事件 *****</h5>
<pre><code>绑定事件: 

    $obj.bind(&quot;事件类型&quot;,处理函数function);

解除绑定:

    $obj.unbind(&quot;事件类型&quot;);

模拟元素事件:   (了解)

    $obj.trigger(&quot;事件类型&quot;);

案例:  $obj.trigger(&quot;click&quot;); 会触发$obj的点击事件!
</code></pre>

<h5>Jquery事件函数 ***</h5>
<pre><code>$obj.click(fn)/click()//当点击
$obj.dblclick(fn)/dblclick()//当双击
$obj.blur(fn)/blur()//当失去焦点
$obj.focus(fn)/focus()//当获取焦点
$obj.change(fn)/change()//当状态发生改变
$obj.keydown(fn)/keydown()//当键盘按下
$obj.keyup(fn)/keyup()//当键盘弹起
$obj.mouseover(fn)/mouseover()//当鼠标指针位于元素上方
$obj.mouseout(fn)/mouseout()//当鼠标指针从元素上方滑出
$obj.submit(fn)/submit()//当表单数据的提交
$obj.load(fn)/unload(fn)//当元素加载完毕/销毁


案例: 

$obj.click(function(){
    //当$obj被点击时, 这个代码块自动执行
});
</code></pre>

<h5>组合事件 *</h5>
<pre><code>鼠标移入移出事件: 

$obj.hover(in,out);

    参数1. function类型, 在鼠标移入时自动触发
    参数2. function类型, 在鼠标移出时自动触发
</code></pre>

<h5>动态绑定事件函数</h5>
<pre><code>给未来元素, 添加事件 !

格式:  

    $父元素对象.on(&quot;事件类型&quot;,&quot;子元素选择器&quot;,处理函数);

父元素必须是已经存在的!

案例: 
</code></pre>

<h5>文档处理函数</h5>
<pre><code>-   创建元素: 

    var $obj = $(&quot;html标签&quot;);  ***

-   将创建的元素添加到网页中

    -   向父元素的内部追加:
        $父元素.append($新元素);  * 

    -   向父元素的内部前置
        $父元素.prepend($新元素);

    -   插入到参考元素的后一个位置
        $参考元素.after($新元素);

    -   插入到参考元素的前一个位置
        $参考元素.before($新元素);

-   删除一个节点


    -   删除当前节点  *
        $obj.remove();  

    -   清空节点  *
        $obj.empty();

    -   克隆节点
        -   携带事件克隆
            $newObj = $oldObj.clone(true);
        -   不携带事件克隆
            $newObj = $oldObj.clone();
</code></pre>

<h3>文档查找函数</h3>
<pre><code>children() 查找子元素
next() 查找后面的兄弟元素    *****
prev() 查找前面的兄弟元素
siblings() 查找兄弟元素
find(选择器) 查找子元素及后代元素    *****
parent() 查找父元素  *
parents(selector) 查找祖先元素
</code></pre>

<h3>文档筛选函数  了解</h3>
<pre><code>eq(index)   返回index+1位置处的jQuery对象
first()  获取第一个元素
last() 获取最后一个元素
is(expr)  判断元素是否满足expr条件
not(expr) 删除与指定表达式匹配的元素
get(index) 取得其中一个匹配的DOM元素
</code></pre>

<h3>Jquery 工具函数</h3>
<pre><code>-   each 函数(遍历)

    格式:  

        -   遍历Jquery对象的格式
            $obj.each(function(){
                //因为一个Jquery对象就是一个dom对象的集合, 所以这个操作是在循环遍历一个dom集合, 在这个方法中 this 就是每次遍历的单个dom对象 
            });

            案例: 

            JS部分: 

                $(function(){
                    $(&quot;p&quot;).each(function(){
                        console.info(this.innerHTML);
                    });

                });

            HTML部分:

                &lt;p&gt;111111111111111111111111111&lt;/p&gt;
                &lt;p&gt;222222222222222222222222222&lt;/p&gt;
                &lt;p&gt;333333333333333333333333333&lt;/p&gt;
                &lt;p&gt;444444444444444444444444444&lt;/p&gt;


        -   遍历数组的格式

            $.each(数组,function(i,value){
                //i 表示遍历的元素下标
                //value 表示数组中i下标的数据值
            });


            案例: 

                var arr = new Array(11,22,33,23,13);
                $(function(){
                    $.each(arr,function(i,value){
                        console.info(i+&quot;----&gt;&quot;+value);
                    });
                });
</code></pre>

<h3></h3>
<pre><code>-   去除数组中的重复元素 ,不用接收返回值 ,直接操作的就是源数组

    $.unique(数组);

    案例: 

    var arr = new Array(&quot;高飞&quot;,&quot;高天&quot;,&quot;大红&quot;,&quot;大紫&quot;,&quot;高飞&quot;);
    $.unique(arr);

    console.info(arr);
</code></pre>

<h3></h3>
<pre><code>-   合并数组 , 将两个数组中的元素 合并到第一个数组中

    $.merge(arr1,arr2);

    var arr1 = new Array(&quot;高飞&quot;,&quot;高天&quot;);
    var arr2 = new Array(&quot;大红&quot;,&quot;大紫&quot;,&quot;高飞&quot;);
    $.merge(arr1,arr2);
    console.info(arr1);
</code></pre>

<h3></h3>
<pre><code>-   去除字符串中前后的空格


    text = $.trim(text);

    ---------------------

    var text= &quot;                                  高飞飞飞飞飞                                      &quot;;
    console.info(text);
    text = $.trim(text);
    console.info(text);
</code></pre>


</body>
</html>

