/**
 * Created by lenovo-1 on 2016/12/19.
 */
$(function () {
    var top = $(".toTop");
    var letter = $(".letter")
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
});