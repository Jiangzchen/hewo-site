package org.hewo.modules.system.service;

import org.hewo.core.model.entity.R;

import java.util.List;

public interface SysLogService {
    R list(int page, int pageSize, String req);

    R batchRemove(List<String> req);

    R batchRemoveAll();
}
