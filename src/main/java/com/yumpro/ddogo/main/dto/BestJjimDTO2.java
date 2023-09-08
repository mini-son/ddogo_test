package com.yumpro.ddogo.main.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BestJjimDTO2 {

    //private int review_no;
    //private String review;
    private int hotplace_no;
    //private int map_no;
    private String hotplace_name;
    private List<HashMap<String, Object>> reviewList;
//    private double emo_result;
//    private double avg_emo_result;
//    private int jjim;
//    private String address;
    //private List<HashMap<String, Object>> reviewList;
}
