package org.hewo.modules.system.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthDto implements Serializable {
    private String userCode;
    private String password;
}
