$(function () {
    //引入头部文件
    $("#header").load("header.html");
    //banner图模块
    (function () {
        var oBanner=$(".banner-warp");
        var arrDiv = $(".check>div");
        var arrBanner = $(".banner-warp>.banner");
        var oNext = oBanner.find(".choose .next");
        var oPrev = oBanner.find(".choose .prev");
        var page=0 ;
        arrDiv.click(function () {
            var index = $(this).index();
            arrBanner.hide().eq(index).show();
            arrDiv.removeClass("now").eq(index).addClass("now");
            page = $(this).index();
        });
        oNext.click(function () {
            page++;
            if(page >2){page = 0};
            bannerMove();
        });
        oPrev.click(function () {
            page--;
            if(page < 0){page = 2};
            bannerMove();
        });
        function bannerMove(){
            arrBanner.hide().eq(page).show();
            arrDiv.removeClass("now").eq(page).addClass("now");
        }
    })();
    //主要产品模块
    (function () {
        var arrDiv = $(".product>.left .dianl");
        var arrImg = $(".product .rec .img img");
        var arrBird = $(".product .rec .bird-logo")
        var arrT1 = $(".product .rec .text .t1");
        var arrT2 = $(".product .rec .text .t2");
        var arrH1 = $(".product .rec .text>h1")
        var oNext =  $(".product .rec .line .next");
        var oPrev = $(".product .rec .line .prev");
        var nowIndex = 0;
        var oldIndex = 0;
        arrDiv.click(function () {
            nowIndex = $(this).index();
            imgMove();
        });
        oNext.click(function () {
            nowIndex++;
            if(nowIndex > 5){nowIndex = 0};
            imgMove();
        });
        oPrev.click(function () {
            nowIndex--;
            if(nowIndex < 0){nowIndex = 5};
            imgMove();
        });
        function imgMove(){
            if(nowIndex>oldIndex){
                arrImg.hide().eq(nowIndex).show().attr("class","").addClass("animated bounceInRight");
                arrT1.hide().eq(nowIndex).show().attr("class","t1").addClass("animated bounceInRight");
                arrT2.hide().eq(nowIndex).show().attr("class","t2").addClass("animated bounceInRight");
                arrBird.hide().eq(nowIndex).show().attr("class","bird-logo").addClass("animated bounceInRight");
                arrH1.hide().eq(nowIndex).show().attr("class","").addClass("animated bounceInRight");
                arrDiv.addClass("others1").eq(nowIndex).removeClass("others1").addClass("now1");
            }else{
                arrImg.hide().eq(nowIndex).show().attr("class","").addClass("animated bounceInLeft");
                arrT1.hide().eq(nowIndex).show().attr("class","t1").addClass("animated bounceInLeft");
                arrT2.hide().eq(nowIndex).show().attr("class","t2").addClass("animated bounceInLeft");
                arrBird.hide().eq(nowIndex).show().attr("class","bird-logo").addClass("animated bounceInLeft");
                arrH1.hide().eq(nowIndex).show().attr("class","").addClass("animated bounceInLeft");
                arrDiv.addClass("others1").eq(nowIndex).removeClass("others1").addClass("now1");
            }
            oldIndex = nowIndex;
        }
    })();
    //地图模块
    // (function () {
    //     function initMap(){
    //         createMap();//创建地图
    //         setMapEvent();//设置地图事件
    //         addMapControl();//向地图添加控件
    //         addMarker();//向地图中添加marker
    //     }
    //
    //     //创建地图函数：
    //     function createMap(){
    //         var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
    //         var point = new BMap.Point(116.357247,40.095792);//定义一个中心点坐标
    //         map.centerAndZoom(point,17);//设定地图的中心点和坐标并将地图显示在地图容器中
    //         window.map = map;//将map变量存储在全局
    //     }
    //
    //     //地图事件设置函数：
    //     function setMapEvent(){
    //         map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
    //         map.enableScrollWheelZoom();//启用地图滚轮放大缩小
    //         map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
    //         map.enableKeyboard();//启用键盘上下左右键移动地图
    //     }
    //
    //     //地图控件添加函数：
    //     function addMapControl(){
    //         //向地图中添加缩放控件
    //         var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
    //         map.addControl(ctrl_nav);
    //         //向地图中添加缩略图控件
    //         var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
    //         map.addControl(ctrl_ove);
    //         //向地图中添加比例尺控件
    //         var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
    //         map.addControl(ctrl_sca);
    //     }
    //
    //     //标注点数组
    //     var markerArr = [{title:"平西府地铁站",content:"这里是北京地铁8号线平西府站",point:"116.357238|40.095916",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
    //     ];
    //     //创建marker
    //     function addMarker(){
    //         for(var i=0;i<markerArr.length;i++){
    //             var json = markerArr[i];
    //             var p0 = json.point.split("|")[0];
    //             var p1 = json.point.split("|")[1];
    //             var point = new BMap.Point(p0,p1);
    //             var iconImg = createIcon(json.icon);
    //             var marker = new BMap.Marker(point,{icon:iconImg});
    //             var iw = createInfoWindow(i);
    //             var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
    //             marker.setLabel(label);
    //             map.addOverlay(marker);
    //             label.setStyle({
    //                 borderColor:"#808080",
    //                 color:"#333",
    //                 cursor:"pointer"
    //             });
    //
    //             (function(){
    //                 var index = i;
    //                 var _iw = createInfoWindow(i);
    //                 var _marker = marker;
    //                 _marker.addEventListener("click",function(){
    //                     this.openInfoWindow(_iw);
    //                 });
    //                 _iw.addEventListener("open",function(){
    //                     _marker.getLabel().hide();
    //                 })
    //                 _iw.addEventListener("close",function(){
    //                     _marker.getLabel().show();
    //                 })
    //                 label.addEventListener("click",function(){
    //                     _marker.openInfoWindow(_iw);
    //                 })
    //                 if(!!json.isOpen){
    //                     label.hide();
    //                     _marker.openInfoWindow(_iw);
    //                 }
    //             })()
    //         }
    //     }
    //     //创建InfoWindow
    //     function createInfoWindow(i){
    //         var json = markerArr[i];
    //         var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
    //         return iw;
    //     }
    //     //创建一个Icon
    //     function createIcon(json){
    //         var icon = new BMap.Icon("http://app.baidu.com/map/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
    //         return icon;
    //     }
    //
    //     initMap();//创建和初始化地图
    // })();
    //引入底部文件
    $("#footer").load("footer.html");
    //业务模块
    (function () {
        var oYw = $(".yewu");
        var arrShow = oYw.find(".div1 .show");
        var arrBtn = oYw.find(".div1 i");

        arrBtn.click(function () {
            var index = $(this).index(".div1 i");
            //alert(index);
            arrShow.eq(index).slideToggle();
            $(this).toggleClass("yw-click");
        });
    })();
    //团队介绍模块
    (function () {
        var oWarp = $(".team-warp .team .warp ul");
        var oPrev =$(".team .prev");
        var oNext= $(".team .next");
        var arrDiv = $(".team .check>div");
        var nowIndex = 1;
        var index = $(this).index();
        var page1=0
        oPrev.click(function () {
           nowIndex--;
            if(nowIndex>=1){
                oWarp.stop(true,true).animate({"left":nowIndex*-1100+"px"});
                arrDiv.removeClass("now").eq(index).addClass("now");
            }else{
                nowIndex=5;
                oWarp.stop(true,true).animate({"left":"0px"}, function () {
                    oWarp.css("left",-5*1100+"px")
                })
            }
            page1--;
		    if(page1<0){
		        page1=4;
		    }
            arrDiv.siblings().removeClass("now");
       		arrDiv.eq(page1).addClass("now");
        });
        oNext.click(function(){
            nowIndex++;
            if(nowIndex<oWarp.find("li").size()-1){
                oWarp.stop(true,true).animate({"left":nowIndex*-1100+"px"})
            }else {
                nowIndex=1;
                oWarp.stop(true,true).animate({"left":6*-1100+"px"}, function () {
                    oWarp.css("left","-1100px")
                })
            }
            page1++;
		    if(page1>=5){
		        page1=0;
		    }
            arrDiv.siblings().removeClass("now");
       		arrDiv.eq(page1).addClass("now");
        });
        arrDiv.click(function () {
        	var index=arrDiv.index(this)+1;
            $(this).siblings().removeClass("now");
        	$(this).addClass("now");
        	if (nowIndex<5){
	            oWarp.animate({"left":index*-1100+"px"},500,'linear');
	        }
	        else {
	            index=0;
	            oWarp.stop(true,true).animate({"left":3*-1100+"px"},function(){
	                oWarp.css("left","0")
	            });
	        }
	        nowIndex=index;
        	page1=index-1;
        });


    })();
    $("#scroll").load("totop.html");

























})