package org.hewo.modules.system.controller;

import org.hewo.core.controller.AbstractController;
import org.hewo.core.model.entity.R;
import org.hewo.core.model.request.ModelRequest;
import org.hewo.core.model.request.PageRequest;
import org.hewo.modules.system.model.dto.SysUserSaveDto;
import org.hewo.modules.system.service.SysUserService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;

@Mapping("user")
@Controller
public class SysUserController extends AbstractController {

    @Inject
    private SysUserService sysUserService;

    @Post
    @Mapping("create")
    public R create(ModelRequest<SysUserSaveDto> req){
        return sysUserService.create(req.getData());
    }

    @Post
    @Mapping("page")
    public R page(PageRequest<String> req){
        return sysUserService.page(req.getPage(),req.getPageSize(),req.getData());
    }

}
