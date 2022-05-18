package com.shuz.shuzProject.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WishCheckResponseDto {
    private boolean wishCheck;
    private Long wishNo;

}
