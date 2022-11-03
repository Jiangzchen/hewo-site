package org.hewo.modules.auth.controller;

import org.hewo.core.controller.AbstractController;
import org.hewo.core.model.entity.R;
import org.hewo.core.model.request.ModelRequest;
import org.hewo.modules.auth.model.dto.AuthDto;
import org.hewo.modules.auth.model.vo.AuthVo;
import org.hewo.modules.auth.service.AuthService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;
import org.noear.solon.core.handle.ModelAndView;

@Controller
@Mapping("auth")
public class AuthController extends AbstractController {

    @Inject
    private AuthService authService;

    @Post
    @Mapping("verifyAuth")
    private R verifyAuth(ModelRequest<AuthDto> req){
        AuthVo authVo = authService.verifyAuth(req.getData());
        return R.ok("登录成功").data(authVo);
    }

    @Mapping("toLogin")
    private ModelAndView toLogin(){
        ModelAndView mav = new ModelAndView("system/login.ftl");
        return mav;
    }

    @Mapping("index")
    private ModelAndView index(){
        ModelAndView mav = new ModelAndView("system/index.ftl");
        return mav;
    }
}
