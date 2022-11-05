package org.hewo.modules.system.service;

import org.hewo.core.model.entity.R;
import org.hewo.modules.system.model.dto.AuthDto;
import org.hewo.modules.system.model.vo.AuthVo;

public interface AuthService {
    R accessToken(AuthDto req);
}
