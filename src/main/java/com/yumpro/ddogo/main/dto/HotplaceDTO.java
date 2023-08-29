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
public class HotplaceDTO {

    private Integer hotplace_no;
    private String sido;
    private String gugun;
    private String hotplace_name;
    private String address;
    private int hotplace_cate_no;
    private double lat;
    private double lng;

}
