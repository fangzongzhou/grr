/**
 * Created by lenovo-1 on 2016/12/15.
 */
$(function () {
    //引入头部
    $("#header").load("header.html");
    //引入底部
    $("#footer").load("footer.html");
    //鼠标点击pen标志
    (function () {
        var oPen = $(".pen");
        var oLine = $(".p");
        oPen.click(function () {
           oLine.css({
               "width":"100px",
               "backgroundpositionX":"-980px"
           }).animate({
                "width":"1100px",
                "backgroundpositionX":"0px"
            })

        });
    })();
    //事件委托
    (function () {
        $(".list").delegate(".div","click", function () {
            //alert(this.id);
           window.open("article.html?type=xiaoniaoNews&articleId="+$(this).attr("id"));
        })
    })();
    /* var oList = $(".list");
     oList.addEventListener("click",function(ev){
     var oEvent = window.event || ev;
     //拿到事件源
     var oTar =  oEvent.target
     })*/
    //加载内容
    (function () {
        var pageTimes = 0;
        $(".list").html("");
        loadListData();
        $(".down").click(function () {
            pageTimes++;
            loadListData();
        });
        function loadListData(){
            var list = listData["listData0"+pageTimes];
            if(!list || !list.data.list.length){
                return;
            }
            if(list.success == "成功"){
                var data = list.data;
                var arrList = data.list;
                for(var i = 0;i<arrList.length;i++){
                    var itemHtml = $("#itemHtml").html();
                    console.log(itemHtml);
                    itemHtml = itemHtml.replace("$articleId$",arrList[i].sysId)
                    .replace("$articleCover$",arrList[i].coverImg)
                    .replace("$articleTitle$",arrList[i].title)
                    .replace("$articleTime$",arrList[i].creatAt)
                    .replace("$describe$",arrList[i].describe);
                    $(".list").append(itemHtml);
                }
                var count = data.count;
                var pageSize = data.pageSize;
                var pageStart = data.pageStart;
                if(Math.floor(count/pageSize) == pageStart){
                    $(".down").css("opacity",0.3);
                    $(".more").attr("src","image/list_gomore_bg_nomore.jpg")
                }else{

                }
            }
        }
    })();
})




