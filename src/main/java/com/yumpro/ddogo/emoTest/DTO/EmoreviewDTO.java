package com.yumpro.ddogo.emoTest.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EmoreviewDTO {

    private int review_no;
    private String review;
    private int hotplace_no;
    private int map_no;
    private double emo_result;
}
