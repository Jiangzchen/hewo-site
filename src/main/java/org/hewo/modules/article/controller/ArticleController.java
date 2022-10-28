package org.hewo.modules.article.controller;

import org.hewo.core.controller.AbstractController;
import org.hewo.core.model.entity.R;
import org.hewo.core.model.request.ModelRequest;
import org.hewo.modules.article.model.dto.ArticleSaveDto;
import org.hewo.modules.article.service.ArticleService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;

@Mapping("article")
@Controller
public class ArticleController extends AbstractController {

    @Inject
    private ArticleService articleService;

    @Post
    @Mapping("create")
    public R create(ModelRequest<ArticleSaveDto> req){
        return articleService.create(req.getData());
    }
}
