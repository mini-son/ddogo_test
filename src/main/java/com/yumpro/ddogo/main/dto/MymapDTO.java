package com.yumpro.ddogo.main.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class MymapDTO {

    private int map_no;
    private int hotplace_no;
    private int user_no;
    private  char recom;
    private String map_memo;
    private LocalDateTime recom_date;
}
