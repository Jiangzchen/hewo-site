package org.hewo.modules.system.controller;

import org.hewo.core.controller.AbstractController;
import org.hewo.core.model.entity.R;
import org.hewo.core.model.request.ModelRequest;
import org.hewo.modules.system.model.dto.AuthDto;
import org.hewo.modules.system.service.AuthService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
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
    @Mapping("accessToken")
    private R accessToken(ModelRequest<AuthDto> req){
        return authService.accessToken(req.getData());
    }

    @Get
    @Mapping("toLogin")
    private ModelAndView toLogin(){
        return mav("system/login");
    }

    @Get
    @Mapping("index")
    private ModelAndView index(){
        return mav("system/index");
    }

    @Get
    @Mapping(value = "logout")
    public ModelAndView logout() {
        return mav("system/login");
    }
}
