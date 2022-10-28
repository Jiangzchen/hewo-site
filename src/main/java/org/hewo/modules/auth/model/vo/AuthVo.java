package org.hewo.modules.auth.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthVo implements Serializable {
    private String userCode;
    private String phone;
    private String token;
}
