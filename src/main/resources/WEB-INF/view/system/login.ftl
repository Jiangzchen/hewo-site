<!DOCTYPE html>
<html>
<head>
    <#include "../includes/_head.ftl">
    <title>Login - Hewo Admin</title>
</head>
<body>
    <div id="hewo">
    <section class="material-half-bg">
        <div class="cover"></div>
    </section>
    <section class="login-content">
        <div class="logo">
            <h1>Hewo</h1>
        </div>
        <div class="login-box">
            <form class="login-form" action="#!">
                <h3 class="login-head"><i class="fa fa-lg fa-fw fa-user"></i>SIGN IN</h3>
                <div class="form-group">
                    <label class="control-label">USERNAME</label>
                    <input class="form-control" id="userCode" name="userCode" type="text" placeholder="用户名" autofocus>
                </div>
                <div class="form-group">
                    <label class="control-label">PASSWORD</label>
                    <input class="form-control" id="password" name="password" type="password" placeholder="密码">
                </div>
                <div class="form-group">
                    <div class="utility">
                        <div class="animated-checkbox">
                            <label>
                                <input type="checkbox"><span class="label-text">Stay Signed in</span>
                            </label>
                        </div>
                        <p class="semibold-text mb-2"><a href="#" data-toggle="flip">Forgot Password ?</a></p>
                    </div>
                </div>
                <div class="form-group btn-container">
                    <button class="btn btn-primary btn-block" id="btnLogin" onClick="return false"><i class="fa fa-sign-in fa-lg fa-fw"></i>SIGN IN</button>
                </div>
            </form>
            <form class="forget-form" action="#!">
                <h3 class="login-head"><i class="fa fa-lg fa-fw fa-lock"></i>Forgot Password ?</h3>
                <div class="form-group">
                    <label class="control-label">EMAIL</label>
                    <input class="form-control" type="text" placeholder="邮箱">
                </div>
                <div class="form-group btn-container">
                    <button class="btn btn-primary btn-block" id="btnReset" onClick="return false"><i class="fa fa-unlock fa-lg fa-fw"></i>RESET</button>
                </div>
                <div class="form-group mt-3">
                    <p class="semibold-text mb-0"><a href="#" data-toggle="flip"><i class="fa fa-angle-left fa-fw"></i> Back to Login</a></p>
                </div>
            </form>
        </div>
    </section>
    </div>
    <#--Javascript-->
    <#include "../includes/_javascript.ftl">
    <script src="/js/system/login.js"></script>
</body>
</html>