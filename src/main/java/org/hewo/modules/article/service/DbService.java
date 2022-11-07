package org.hewo.modules.article.service;

public interface DbService {
    boolean isExistTable(String tableName);

    boolean isExistField(String tableName, String fieldName);

    Integer insert(String sql);
}
