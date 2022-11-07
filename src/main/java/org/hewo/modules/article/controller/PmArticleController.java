package org.hewo.modules.article.controller;

import org.hewo.core.controller.AbstractController;
import org.hewo.core.model.entity.R;
import org.hewo.core.model.request.ModelRequest;
import org.hewo.core.model.request.PageRequest;
import org.hewo.modules.article.model.dto.PmArticleSaveDto;
import org.hewo.modules.article.service.PmArticleService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;

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
}
