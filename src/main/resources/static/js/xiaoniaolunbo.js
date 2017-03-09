/**
 * Created by lenovo-1 on 2016/12/21.
 */
var GLOBAL = GLOBAL || {};
$(function () {
   //s2  概述页轮播
    (function () {
        var oPrev = $(".s2 .prev");
        var oNext = $(".s2 .next");
        var arrDiv = $(".s2>ul>div");
        var page = 0;
        oNext.click(function () {
                page++;
                if(page>=arrDiv.length){
                    page =0;
                }
                for(j = 0; j<arrDiv.length;j++){
                    arrDiv[j].style.display = "none";
                }
                arrDiv[page].style.display = "block";
            })
        oPrev.click(function(){
            page--;
            if(page < 0){
                page = arrDiv.length -1;
            }
            for(j = 0; j<arrDiv.length;j++){
                arrDiv[j].style.display = "none";
            }
            arrDiv[page].style.display = "block";
        })
    })();
    //s4   小鸟掌云页轮播
    (function () {
        var  oUl=$(".s4 .main>ul");
        var oLeft = $(".s4 .btn .prev");
        var oRight = $(".s4 .btn .next");
        var  page=1;
        oLeft.click(function(){
            page--;
            if(page>=1){
                oUl.stop(true,true).animate({"left":page*-915+"px"})
            }else {
                page=2;
                oUl.stop(true,true).animate({"left":"0px"}, function () {
                    oUl.css("left",-2*915+"px")
                })
            }
            oRight.css("backgroundPositionY","-8px");
            oLeft.css({
                "backgroundPositionY":"0",
                "transition":".3s"
            })
        });
        oRight.click(function(){
            page++;
            if(page<3){
                oUl.stop(true,true).animate({"left":page*-915+"px"})
            }else {
                page=1;
                oUl.stop(true,true).animate({"left":3*-915+"px"}, function () {
                    oUl.css("left","-915px")
                })
            }
            oLeft.css("backgroundPositionY","-8px");
            oRight.css({
                "backgroundPositionY":"0",
                "transition":".3s"
            })
        });
    })();
    //展示页  定时器
    GLOBAL.welcomeOver = false;
    (function () {
        var oWel = $(".welcome-warp");
        var oIcon = $(".welcome .icon");
        show();
        function show(){
            GLOBAL.welcomeTimer = setTimeout(function(){
                oIcon.animate({"margin-top":"0px","margin-bottom":"0"},function(){
                    $(".welcome .animate").each(function (i) {
                        var _this = $(this);
                        setTimeout(function () {
                            _this.show().addClass("animated fadeInUp");
                        },200*(i+1));
                    })
                });
            },5000)
        }
        function clear () {
            oWel.animate({top:"-1000px"},1000,function(){
               GLOBAL.welcomeOver = true;
            });
        }
        setTimeout(clear,10000);
        oWel.dblclick(function () {
            oWel.animate({"top":"-100%"},500, function () {
                GLOBAL.welcomeOver = true;
                clearTimeout( GLOBAL.welcomeTimer);
            });
        });
    })();

});