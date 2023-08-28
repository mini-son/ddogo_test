package com.yumpro.ddogo.emo_test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class emoreview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_no;

    @Column
    private String review;
}
