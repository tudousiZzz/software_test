package com.exam.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class Login {
    private Integer username;
    private String password;


}
