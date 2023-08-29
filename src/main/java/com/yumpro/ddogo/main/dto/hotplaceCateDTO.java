package com.yumpro.ddogo.main.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class hotplaceCateDTO {

    private int hotplace_cate_no;
    private String hotplace_cate_name;
}
