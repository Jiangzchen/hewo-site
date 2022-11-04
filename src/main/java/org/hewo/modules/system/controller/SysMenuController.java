package org.hewo.modules.system.controller;

import org.hewo.core.controller.AbstractController;
import org.hewo.core.model.entity.R;
import org.hewo.core.model.request.ListRequest;
import org.hewo.core.model.request.ModelRequest;
import org.hewo.core.model.request.PageRequest;
import org.hewo.modules.system.model.dto.SysMenuSaveDto;
import org.hewo.modules.system.model.dto.SysUserSaveDto;
import org.hewo.modules.system.service.SysMenuService;
import org.hewo.modules.system.service.SysUserService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

@Mapping("system/menu")
@Controller
public class SysMenuController extends AbstractController {

    @Inject
    private SysMenuService sysMenuService;

    @Mapping("save")
    public R save(ModelRequest<SysMenuSaveDto> req){
       return sysMenuService.save(req.getData());
    }

    @Mapping("info")
    public R info(ModelRequest<String> req){
        return sysMenuService.info(req.getData());
    }

    @Mapping("list")
    public R page(PageRequest<String> req){
        return sysMenuService.list(req.getPage(),req.getPageSize(),req.getData());
    }

    @Mapping("remove")
    public R remove(ListRequest<String> req){
        return sysMenuService.batchRemove(req.getData());
    }
}
