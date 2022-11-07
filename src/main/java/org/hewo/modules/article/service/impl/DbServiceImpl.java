package org.hewo.modules.article.service.impl;

import org.apache.ibatis.solon.annotation.Db;
import org.hewo.modules.article.mapper.DbMapper;
import org.hewo.modules.article.service.DbService;
import org.noear.solon.aspect.annotation.Service;

@Service
public class DbServiceImpl implements DbService {
    @Db
    private DbMapper dbMapper;

    @Override
    public boolean isExistTable(String tableName) {
        Integer count = this.dbMapper.isExistTable(tableName);
        if (null == count) {
            count = 0;
        }
        return 0 != count;
    }

    @Override
    public boolean isExistField(String tableName, String fieldName) {
        Integer count = this.dbMapper.isExistField(tableName, fieldName);
        if (null == count) {
            count = 0;
        }
        return 0 != count;
    }

    @Override
    public Integer insert(String sql) {
        return this.dbMapper.insert(sql);
    }
}
