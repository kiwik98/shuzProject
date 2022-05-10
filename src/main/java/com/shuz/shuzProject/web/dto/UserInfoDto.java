package com.shuz.shuzProject.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class UserInfoDto {

    private String id;
    private String password;
    private char gender;
}
