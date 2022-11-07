package org.hewo.modules.article.controller;

import org.hewo.core.controller.AbstractController;
import org.hewo.core.model.entity.R;
import org.hewo.core.model.request.ModelRequest;
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
    private PmArticleService articleService;

    @Post
    @Mapping("save")
    public R save(ModelRequest<PmArticleSaveDto> req){
        return articleService.save(req.getData());
    }

    @Post
    @Mapping("info")
    public R info(ModelRequest<String> req){
        return articleService.info(req.getData());
    }
}
