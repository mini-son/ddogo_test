package com.yumpro.ddogo.main.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ReviewDTO {

    private int hotplace_no;
    private String review;
    private double avg_emo_result;
}
