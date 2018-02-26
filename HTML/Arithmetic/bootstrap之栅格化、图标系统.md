## 1.栅格系统 

      把每个显示的区域的行划分成12等份,可以在不同屏幕下指定每一列所占的份数。一般是大屏幕下一列所占的份数越少 小屏幕下一列所占的份数应该偏多。
   
## 2.栅格系统列的偏移 

       <div  class="container">
             <div class="row">
                 <div  class="col-md-8 bg">8份</div>
                 <div  class="col-md-3 col-md-offset-1 bg">3份</div>
             </div>
       </div> 
   
## 3.列的移动 

      push  向右
      pull  向左 
        <div  class="container">
             <div class="row">
                 <div  class="col-md-6  col-md-push-6 bg">左</div>
                 <div  class="col-md-6 col-md-pull-6 bg">右</div>
             </div>
        </div>

## 4.响应式类 

      在不同屏幕下 可以对元素进行 显示和 隐藏 
      visible-屏幕说明-元素显示方式说明 
      hidden-屏幕说明  
      屏幕说明    lg  大屏    md 中等屏    sm  小屏   xs  超小屏 
      显示方式说明   inline  inline-block  block 
 
## 5.下拉菜单 

      class="dropdown"   data-toggle="dropdown"
      class="caret"    class="dropdown-menu"

      class="dropup"   
      class="dropdown-header"
      class="dropdown-menu-right"
      class="divider"  
      class="disabled" 
      class="dropdown open" 
  
## 6.导航

  ### 6.1 基本导航
  
       ul    class="nav"  class="nav nav-tabs"
    
  ### 6.2 胶囊式导航
  
       class="nav  nav-pills nav-stacked" 
    
  ### 6.3 导航 下拉菜单 
  
       先做一个胶囊式 导航   然后给第二个导航 加一个下拉菜单
       把导航项的li 当做下拉菜单的 div   并且把 下拉菜单按钮 使用a 标签完成否则比较丑
       
 ## 7.导航条 
 
       <div class="navbar navbar-default navbar-fixed-top">
            <div class="navbar-header">
                 <span  class="navbar-brand">LINGDU.COM</span>
            </div>
            <ul class="nav navbar-nav">
                 <li> <a href="#">首页</a> </li>
                 <li> <a href="#">笔记</a> </li>
                 <li> <a href="#">视频</a> </li>
                 <li> <a href="#">课件</a> </li>
                 <li> <a href="#">关于</a> </li>
            </ul>
            <div class="navbar-text navbar-left" style="font-size: 20px">
                            不&nbsp;&nbsp;忘&nbsp;&nbsp;初&nbsp;&nbsp;心   
                            方&nbsp;&nbsp;得&nbsp;&nbsp;始&nbsp;&nbsp;终 
            </div>
            <form  class="navbar-form navbar-left">
                 <div class="input-group">
                      <input  type="text" class="form-control">
                      <label  class="input-group-addon">搜索</label>
                 </div>
            </form>
        </div>
    
## 8.缩略图
  
        写一个栅格系统  要求每一列中 显示有图片 
        图片的显示 要求 在大屏幕下 一行显示6张   中等屏幕下显示 4 张  小屏幕下 显示3张  
        超小屏幕下 显示 2 张。
        栅格系统 +  class="thumbnail" 
    
## 9.折叠和展开
  
        <button   class="btn btn-primary"  data-toggle="collapse" 
        data-target="#content">
            折叠和展开
        </button>
        <div  id="content" class="collapse">
        </div>
    
## 10.图片轮播 (跑马灯)
  
          <div id="imgs" data-ride="carousel"  class="carousel slide" 
              style="width: 544px" data-interval="3000">
              <div class="carousel-inner">
                <div class="item active">
                  <img src="img/ad01.jpg" alt="1" />
                </div>
                <div class="item">
                  <img src="img/ad02.jpg" alt="2" />
                </div>
                <div class="item">
                  <img src="img/ad03.jpg" alt="3" />
                </div>
                <div class="item">
                  <img src="img/ad04.jpg" alt="4" />
                </div>
                <div class="item">
                  <img src="img/ad05.jpg" alt="5" />
                </div>
                <div class="item">
                  <img src="img/ad06.jpg" alt="6" />
                </div>
              </div>
              <a href="#imgs" data-slide="prev" class="carousel-control let"></a>
              <a href="#imgs" data-slide="next" class="carousel-control right"></a>
              <ol class="carousel-indicators">
                <li class="active" data-target="#imgs" data-slide-to="0"></li>
                <li data-target="#imgs" data-slide-to="1"></li>
                <li data-target="#imgs" data-slide-to="2"></li>
                <li data-target="#imgs" data-slide-to="3"></li>
                <li data-target="#imgs" data-slide-to="4"></li>
                <li data-target="#imgs" data-slide-to="5"></li>
              </ol>
            </div>
