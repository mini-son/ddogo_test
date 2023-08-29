package com.yumpro.ddogo.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hotplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotplace_no;

    @Column
    private String sido;

    @Column
    private String gugun;

    @Column
    private String hotplace_name;

    @Column
    private String address;

    @Column
    private int hotplace_cate_no;

    @Column
    private double lat;

    @Column
    private double lng;

}
