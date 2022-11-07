package org.hewo.modules.article.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import org.apache.ibatis.solon.annotation.Db;
import org.hewo.core.model.entity.R;
import org.hewo.core.service.impl.AbstractServiceImpl;
import org.hewo.modules.article.mapper.PmArticleMapper;
import org.hewo.modules.article.model.dto.PmArticleSaveDto;
import org.hewo.modules.article.model.entity.PmArticle;
import org.hewo.modules.article.model.vo.PmArticleVo;
import org.hewo.modules.article.service.PmArticleService;
import org.hewo.modules.article.service.PmCustomizeColumnService;
import org.noear.solon.annotation.Inject;
import org.noear.solon.aspect.annotation.Service;

import java.util.Map;

@Service
public class PmArticleServiceImpl extends AbstractServiceImpl implements PmArticleService {

    @Db
    private PmArticleMapper pmArticleMapper;
    @Inject
    private PmCustomizeColumnService pmCustomizeColumnService;

    @Override
    public R save(PmArticleSaveDto req) {
        String articleSaveId = IdUtil.fastSimpleUUID();
        req.setId(articleSaveId);
        pmArticleMapper.insert(req);

        Map<String, Object> customFieldMap = req.getCustomFieldMap();
        if (CollUtil.isNotEmpty(customFieldMap)) {
            pmCustomizeColumnService.saveCustomFieldData("pm_article",req.getId(),customFieldMap);
        }
        return R.ok().data(articleSaveId);
    }

    @Override
    public R info(String req) {
        PmArticle pmArticle = pmArticleMapper.selectById(req);
        PmArticleVo pmArticleVo = new PmArticleVo();
        BeanUtil.copyProperties(pmArticle,pmArticleVo,true);

        Map<String, Object> map = this.pmCustomizeColumnService.queryCustomData("pm_article", req);
        if (CollUtil.isNotEmpty(map)) {
            pmArticleVo.setCustomFieldMap(map);
        }
        return R.ok().data(pmArticleVo);
    }
}
