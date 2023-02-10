package com.ispan.pcbuy.dto;

import javax.validation.constraints.*;
import lombok.Data;

@Data
public class UserRegisterRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
