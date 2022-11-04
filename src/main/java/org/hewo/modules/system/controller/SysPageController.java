package org.hewo.modules.system.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;

@Controller
public class SysPageController {

    @Mapping("/{module}/{function}/{url}.ftl")
    public ModelAndView page(String module,String function,String url) {
        return new ModelAndView(String.format("/%s/%s/%s.ftl",module,function,url));
    }

    /**
     * 404页面
     * @return
     */
    @Mapping("error/404")
    private ModelAndView notFoundPage(){
        return new ModelAndView("error/404.ftl");
    }

    /**
     * 403页面
     * @return
     */
    @Mapping("error/403")
    private ModelAndView noAuthPage(){
        return new ModelAndView("error/403.ftl");
    }

    /**
     * 500页面
     * @return
     */
    @Mapping("error/500")
    private ModelAndView sysError(){
        return new ModelAndView("error/500.ftl");
    }

    /**
     * 系统首页
     * @return
     */
    @Mapping("dashboard")
    private ModelAndView main(){
        return new ModelAndView("system/dashboard.ftl");
    }
}
