package com.yumpro.ddogo.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Mymap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int map_no;

    @Column
    private int hotplace_no;

    @Column
    private int user_no;

    @Column

    private  char recom;

    @Column
    private String map_memo;
    @Column
    private LocalDateTime recom_date;
}
