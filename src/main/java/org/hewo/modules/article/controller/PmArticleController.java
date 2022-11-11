package org.hewo.modules.article.controller;

import cn.hutool.json.JSONUtil;
import org.hewo.core.controller.AbstractController;
import org.hewo.core.model.entity.R;
import org.hewo.core.model.request.ModelRequest;
import org.hewo.core.model.request.PageRequest;
import org.hewo.modules.article.model.dto.PmArticleSaveDto;
import org.hewo.modules.article.service.PmArticleService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;
import org.noear.solon.core.JarClassLoader;
import org.noear.solon.hotplug.PluginManager;
import org.noear.solon.hotplug.PluginPackage;

import java.io.File;
import java.util.Arrays;

@Mapping("article")
@Controller
public class PmArticleController extends AbstractController {

    @Inject
    private PmArticleService pmArticleService;

    @Post
    @Mapping("save")
    public R save(ModelRequest<PmArticleSaveDto> req){
        return pmArticleService.save(req.getData());
    }

    @Post
    @Mapping("info")
    public R info(ModelRequest<String> req){
        return pmArticleService.info(req.getData());
    }

    @Post
    @Mapping("list")
    public R page(PageRequest<String> req){
        return pmArticleService.list(req.getPage(),req.getPageSize(),req.getData());
    }

    @Get
    @Mapping("add1")
    public R add1(){
        File jarFile = new File("C:/Users/Tronksoft-P-K011/Desktop/_runing/hewo-plugin-hello.jar");
        //加载插件并启动
        PluginPackage jarPlugin = PluginManager.loadJar(jarFile).start();

        return R.ok();
    }

    @Get
    @Mapping("add/{file}")
    public R add(String file){
        String url = String.format("C:\\Users\\Tronksoft-P-K011\\Desktop\\_runing\\%s.jar",file);
        File file1 = new File(url);
        PluginManager.add(file, file1);
        PluginManager.start(file);


        /*File jarFile = new File(url);
        //加载插件并启动
        PluginPackage jarPlugin = PluginManager.loadJar(jarFile).start();**/
        return R.ok().data(file);
    }

    @Get
    @Mapping("rem/{file}")
    public R rem(String file){




        //PluginManager.loadJar(jarFile).stop();
           PluginManager.unload(file);
           PluginManager.remove(file);

           try {
               String url = String.format("C:\\Users\\Tronksoft-P-K011\\Desktop\\_runing\\%s.jar",file);
               File jarFile = new File(url);
               boolean delete = jarFile.delete();
               System.out.println(delete);
           }catch (Exception e){
               e.printStackTrace();
           }


        return R.ok().data(file);
    }

    public static void main(String[] args) {

    }
}
