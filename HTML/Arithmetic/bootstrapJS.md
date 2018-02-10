## 1.bootstrap 的 特点

>1. 跨设备 跨浏览器 
>2. 响应式 (可以根据不同的屏幕 做出适应 )
>3. 内置jquery 插件 
>4. 支持 h5  css3
>5. 支持 Less 动态样式 
    
## 2.bootstrap 的使用步骤

>2.1 下载bootstrap  并拷贝到 项目的 WebContent 下 
  
>2.2 导入css  和 js 文件  (注意先导入jquery  后导入bootstrap)
  
>2.3 使用bootstrap的样式 
  
## 3.bootstrap  对全局的排版做了内置支持

>比如 全局 字体 和 颜色

>标题样式的修改  和  支持class 形式的标题

>支持class 形式的 文本对齐

>支持文本 大小写 等 修改 

>缩略语  abbr

>列表的样式   
 
## 4.按钮 

>普通按钮   按钮的修改  大小  激活和禁用 
  
## 5.特殊按钮   

>js插件  ----  按钮 

>开关按钮     data-toggle="button"
  
## 6.表格

>6.1 做一个普通的hmtl 表格

>6.2 基本表格修饰 class = "table"

>6.3 条纹状表格 class = "table table-stripted"

>6.4 带边框的表格 class = "table table-bordered"

>6.5 鼠标滑过 class = "table table-hover"

>6.6 表格背景 class="active|success|info|warning|danger"

>6.7 隐藏表格一行 和  响应式表格 ,隐藏表格之前的方式 依然可用  现在多了一种加 class="sr-only" 的方式。class="table table-responsive"  大于768 没有边框  小于等于768 有边框 
  
## 7.表单 

>7.1 独占式表单 （每个元素都独占一行） 在表单内的元素上加  class="form-control" 

>7.2 内联式表单 ,在表单上  加 class="form-inline" ,在表单内的元素上加  class="form-control"  ,大于768 时  元素在一行显示 ,小于768 则转换成独占式 

>7.3 组合输入框,可以将多个元素 组合成一个元素 ,form 表单 上 加 class="form-group",然后在这组元素外 加一个  div  并设置 class="input-group" ,输入框 前 加一个  class="input-group-addon"   当然也可以给后面追加元素 

>7.4 输入框的大小可以通过 input-lg  input-sm  这些样式控制 

>7.5 表单验证:在输入框的外边 加 span  样式设置成   has-success 或者 has-error 等。为了让标签和 表单元素状态同步   给文本加一个 label 标签 并且 样式设置成 control-label    
  
              
