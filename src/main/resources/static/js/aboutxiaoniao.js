window.onload = function () {
    var oScreenBanner = document.getElementsByClassName("screen-banner")[0];
    var oAllScreen = document.getElementsByClassName("all-screen")[0];
    var arrScreen = document.getElementsByClassName("screen");
    var oSpan = document.getElementById("nav");
    var arrSpan = oSpan.getElementsByTagName("li");
    var screenW;
    var screenH;
    var page = 0;
    function resize(){
        screenW = document.documentElement.clientWidth;   //获取屏幕宽高
        screenH = document.documentElement.clientHeight;
        oAllScreen.style.width = oScreenBanner.style.width = screenW+"px";
        oScreenBanner.style.height = screenH+"px";
        oAllScreen.style.height = screenH*arrScreen.length+"px";
        for(var i=0;i<arrScreen.length;i++){
            arrScreen[i].style.width = screenW+"px";
            arrScreen[i].style.height = screenH+"px";
        }
        oAllScreen.style.top = -page*screenH+"px";

    }
    resize();
    window.onresize = function(){
        resize();
        setTimeout(resize,50);
    };
    var isRunning = false;   //当isRunning为true时，鼠标滚轴失效//当isRunning为false时，鼠标滚轴起作用

    //点击头部nav显示对应页面
    for(var i=0;i<arrSpan.length;i++){
        arrSpan[i].index=i;
        arrSpan[i].onclick=function(){
            //alert(this.index);
            if(this.index == 0){
                oAllScreen.style.top=0;
            }else if(this.index == 4){
                oAllScreen.style.top=-4*screenH+"px";
            }else if(this.index == 5){
                oAllScreen.style.top=0;
            } else{
                oAllScreen.style.top=-(this.index+1)*screenH+"px";
            }
            }
        }

    function scrollUp(){
        if(isRunning == false){
            isRunning = true;
            setTimeout(function(){
                isRunning = false;
            },1000)
            if(page>0){
                page--;
                oAllScreen.style.top = -page*screenH+"px";
            }
        }
    }
    function scrollDown(){
        if(isRunning == false) {
            isRunning = true;
            setTimeout(function(){
                isRunning = false;
            },1000)
            if (page < arrScreen.length - 1) {
                page++;
                oAllScreen.style.top = -page * screenH + "px";
            }
        }
    }
    addEvent(window,"mousewheel",mousewheel);
    addEvent(window,"DOMMouseScroll",mousewheel);
    //滚轴事件函数
    function mousewheel(ev){
        var oEvent = window.event||ev;
        if(GLOBAL.welcomeOver){
            if(oEvent.detail){
                if(oEvent.detail>0){                  //向下滚动
                    scrollDown();
                }else{                                //向上滚动
                    scrollUp();
                }
            }else if(oEvent.wheelDelta){
                if(oEvent.wheelDelta<0){                  //向下滚动
                    scrollDown();
                }else{                                //向上滚动
                    scrollUp();
                }
            }
        }
    }
    function addEvent (ele,type,listener)
    {
        if(ele.addEventListener){                        //click
            ele.addEventListener(type,listener);
        }else{                                           //onclick
            ele.attachEvent("on"+type,listener);
        }
    }



}
