package com.yumpro.ddogo.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class hotplace_cate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotplace_cate_no;

    @Column
    private String hotplace_cate_name;
}
