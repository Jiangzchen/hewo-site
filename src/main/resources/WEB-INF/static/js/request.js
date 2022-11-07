
//axios封装post请求
function post(url,data) {
    // https://blog.csdn.net/qq_34309704/article/details/80572077
    let currentCookie = getCookie("currentCookie");
    console.log("currentCookie"+currentCookie);
    let result = axios({
        method: 'post',
        url: url,
        data: data,
        header: {
            'Authorization': currentCookie
        }
    }).then(resp => {
        return resp.data;
    }).catch(error => {
        return "exception=" + error;
    });
    return result;
}


//get请求
function get(url) {
    var result = axios({
        method: 'get',
        url: url
    }).then(function (resp) {
        return resp.data;
    }).catch(function (error) {
        return "exception=" + error;
    });
    return result;
}