
$(function(){
    if (self != top) {
        top.location.href = self.location.href;
    }
    $('#btnLogin').on('click', login);

    $(document).keyup(function (event) {
        if (event.keyCode === 13) {
            $('#btnLogin').trigger('click');
        }
    })
});

// 登录方法
function login() {
    let userCode = $("#userCode").val();
    if (userCode === '') {
        message("用户名不能为空");
        return false;
    }

    let password = $("#password").val();
    if (password === '') {
        message("密码不能为空");
        return false;
    }

    var req = {"data": {"userCode": userCode, "password": password}};
    post(baseUrl + auth.accessToken, req).then(res => {
        if (res.code != 0) {
            message(res.msg);
            return false;
        }
        setCookie("currentCookie", res.data.token);
        top.location.href = baseUrl+auth.index;
    });
}