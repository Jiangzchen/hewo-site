package org.hewo.modules.system.controller;

import org.hewo.core.controller.AbstractController;
import org.hewo.core.model.entity.R;
import org.hewo.core.model.request.ListRequest;
import org.hewo.core.model.request.ModelRequest;
import org.hewo.core.model.request.PageRequest;
import org.hewo.modules.system.model.dto.SysMacroSaveDto;
import org.hewo.modules.system.model.dto.SysRoleSaveDto;
import org.hewo.modules.system.service.SysMacroService;
import org.hewo.modules.system.service.SysRoleService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

@Controller
@Mapping("system/role")
public class SysRoleController extends AbstractController {

    @Inject
    private SysRoleService sysRoleService;

    @Mapping("list")
    public R list(PageRequest<String> req){
        return sysRoleService.list(req.getPage(),req.getPageSize(),req.getData());
    }

    @Mapping("save")
    public R save(ModelRequest<SysRoleSaveDto> req){
        return sysRoleService.save(req.getData());
    }

    @Mapping("update")
    public R update(ModelRequest<SysRoleSaveDto> req){
        return sysRoleService.update(req.getData());
    }

    @Mapping("info")
    public R info(ModelRequest<String> req){
        return sysRoleService.info(req.getData());
    }

    @Mapping("remove")
    public R remove(ListRequest<String> req){
        return sysRoleService.batchRemove(req.getData());
    }

}
