package org.hewo.modules.system.controller;

import org.hewo.core.controller.AbstractController;
import org.hewo.core.model.entity.R;
import org.hewo.core.model.request.ListRequest;
import org.hewo.core.model.request.ModelRequest;
import org.hewo.core.model.request.PageRequest;
import org.hewo.modules.system.model.dto.SysUserSaveDto;
import org.hewo.modules.system.model.dto.UpdatePswdDto;
import org.hewo.modules.system.service.SysUserService;
import org.noear.solon.annotation.*;

import java.awt.*;

@Mapping("system/user")
@Controller
public class SysUserController extends AbstractController {

    @Inject
    private SysUserService sysUserService;

    @Mapping("save")
    public R save(ModelRequest<SysUserSaveDto> req){
       return sysUserService.save(req.getData());
    }

    @Mapping("info")
    public R info(ModelRequest<String> req){
        return sysUserService.info(req.getData());
    }

    @Mapping("infoMe")
    public R infoMe(){
        return sysUserService.infoMe();
    }

    @Mapping("list")
    public R page(PageRequest<String> req){
        return sysUserService.list(req.getPage(),req.getPageSize(),req.getData());
    }

    @Mapping("remove")
    public R remove(ListRequest<String> req){
        return sysUserService.batchRemove(req.getData());
    }

    @Mapping("updatePswd")
    public R updatePswd(ModelRequest<UpdatePswdDto> req){
        return sysUserService.updatePswd(req.getData());
    }

    @Mapping("enable")
    public R enable(ListRequest<String> req) {
        return sysUserService.enable(req.getData());
    }

    @Mapping("disable")
    public R disable(ListRequest<String> req) {
        return sysUserService.disable(req.getData());
    }

    @Mapping("reset")
    public R reset(ModelRequest<SysUserSaveDto> req) {
        return sysUserService.reset(req.getData());
    }
}
