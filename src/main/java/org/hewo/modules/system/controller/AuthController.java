package org.hewo.modules.system.controller;

import org.hewo.core.controller.AbstractController;
import org.hewo.core.model.entity.R;
import org.hewo.core.model.request.ModelRequest;
import org.hewo.modules.system.model.dto.AuthDto;
import org.hewo.modules.system.model.vo.AuthVo;
import org.hewo.modules.system.service.AuthService;
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

    @Mapping("accessToken")
    private R verifyAuth(ModelRequest<AuthDto> req){
        return authService.verifyAuth(req.getData());
    }

    @Mapping("toLogin")
    private ModelAndView toLogin(){
        return new ModelAndView("system/login.ftl");
    }

    @Mapping("index")
    private ModelAndView index(){
        return new ModelAndView("system/index.ftl");
    }
}
