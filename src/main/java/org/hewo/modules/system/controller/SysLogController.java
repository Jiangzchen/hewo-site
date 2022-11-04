package org.hewo.modules.system.controller;

import org.hewo.core.controller.AbstractController;
import org.hewo.core.model.entity.R;
import org.hewo.core.model.request.ListRequest;
import org.hewo.core.model.request.PageRequest;
import org.hewo.modules.system.service.SysLogService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

@Controller
@Mapping("system/log")
public class SysLogController extends AbstractController {

    @Inject
    private SysLogService sysLogService;

    @Mapping("list")
    public R list(PageRequest<String> req){
        return sysLogService.list(req.getPage(),req.getPageSize(),req.getData());
    }

    @Mapping("remove")
    public R remove(ListRequest<String> req){
        return sysLogService.batchRemove(req.getData());
    }

    @Mapping("clear")
    public R batchRemoveAll(){
        return sysLogService.batchRemoveAll();
    }
}
