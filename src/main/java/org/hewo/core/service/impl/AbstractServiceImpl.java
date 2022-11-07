package org.hewo.core.service.impl;

import cn.hutool.core.util.IdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractServiceImpl {

    protected Logger LOGGER = LoggerFactory.getLogger(getClass());

    public String getId(){
        return IdUtil.fastSimpleUUID();
    }

}
