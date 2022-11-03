package org.hewo.modules.auth.service;

import org.hewo.modules.auth.model.dto.AuthDto;
import org.hewo.modules.auth.model.vo.AuthVo;

public interface AuthService {
    AuthVo verifyAuth(AuthDto req);
}
