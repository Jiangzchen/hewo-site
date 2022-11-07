
function message(message) {
    $.notify({
        title: "",
        message: message,
        icon: 'fa fa-check'
    },{
        type: "info"
    });
}

//JS操作cookies方法!
function setCookie(name,value) {
    var expiredays = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + expiredays*24*60*60*1000);
    document.cookie = name + "="+ escape(value) + ";expires=" + exp.toGMTString();
}

function getCookie(name) {
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return arr[2];
    else
        return null;
}

function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null)
        document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}

