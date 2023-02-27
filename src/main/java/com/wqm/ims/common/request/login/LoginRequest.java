package com.wqm.ims.common.request.login;

import lombok.Data;

@Data
public class LoginRequest {
    private String phone;
    private String password;
    private Integer role;
}
