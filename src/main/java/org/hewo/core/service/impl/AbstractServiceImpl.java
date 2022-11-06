package org.hewo.core.service.impl;

import cn.hutool.core.util.IdUtil;

public abstract class AbstractServiceImpl {

    public String getId(){
        return IdUtil.fastSimpleUUID();
    }

}
