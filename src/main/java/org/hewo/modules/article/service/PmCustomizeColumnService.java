package org.hewo.modules.article.service;

import java.util.Map;

public interface PmCustomizeColumnService {
    boolean saveCustomFieldData(String tableNamePrefix, String id, Map<String, Object> customFieldMap);

    Map<String, Object> queryCustomData(String tableNamePrefix, String id);
}
