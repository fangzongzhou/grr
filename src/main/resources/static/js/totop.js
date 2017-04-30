/**
 * Created by lenovo-1 on 2016/12/19.
 */
$(function () {
    var top = $(".toTop");
    var letter = $(".letter")
    var dashboard= $(".dashboard")
    var key=1
    $(window).scroll(function () {
        if(document.body.scrollTop<800){
            top.slideUp(100)
            letter.slideUp(100)
        }else{
            top.slideDown(0)
            letter.slideDown(0)
        }
    });
    top.click(function () {
        $("body").animate({scrollTop:0})
    })
    letter.click(function () {
        if(key==1) {
            dashboard.load("dashboard.html")
            dashboard.slideDown(100)
            key=0
        }else {
            dashboard.slideUp(100)
            key=1
        }
    })
});