package org.hewo.modules.auth.service;

import org.hewo.core.model.entity.R;
import org.hewo.modules.auth.model.dto.AuthDto;

public interface AuthService {
    R verifyAuth(AuthDto req);
}
