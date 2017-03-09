/**
 * Created by lenovo-1 on 2016/12/15.
 */
var GLOBAL = GLOBAL || {};
$(function () {
    //引入头部和底部
    $("#header").load("header.html");
    $("#footer").load("footer.html");
    $("#totop").load("totop.html");
    //文章内容加载
    (function () {
        GLOBAL.artileType = getUrlParams("type");
        GLOBAL.articleId = getUrlParams("articleId");
        loadArticleData();
        function getUrlParams(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) {
                return r[2];
            } else {
                return "";
            }
        }
        function loadArticleData(){
           var aData =  articleData[GLOBAL.artileType+GLOBAL.articleId];
            $(".title .p1").text(aData.data.typeTitle);
            $(".title .p2").text(aData.data.typeEntitle);
            $(".p").html(aData.data.title+'<div class="pen"></div>');
            $(".time").text(aData.data.updateAt);
            $(".art-img img").attr("src",aData.data.coverImg);
            $("#content").html(aData.data.content);
        }
    })();
    //鼠标点击pen标志
    (function () {
        var oPen = $(".pen");
        var oLine = $(".p");
        oPen.click(function () {
            oLine.css({
                "width": "100px",
                "backgroundpositionX": "-980px"
            }).animate({
                "width": "780px",
                "backgroundpositionX": "0px"
            })

        });
    })();
    //鼠标点击heart表示
    var arr=["one","two","three","four"];
    var isLike = false;
    $(".heart").click(function () {
        if(!isLike){
            var content = arr[Math.floor(Math.random()*arr.length)];
            $(".text").text(content);
            $(".text").css({"opacity":"1","top":"-200px"});
            $(".text").animate({"top":"0"},300).
            delay(300).
            animate({"left":"-200px","opacity":"0"},300, function () {
                $(".heart").animate({"backgroundPositionY":"-74px"});

            });
            isLike = true;
        }else{
            isLike = false;
            $(".heart").animate({"backgroundPositionY":"0px"});
        }





    });
})
