package com.my.hacksa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputDto {
    private String student_id;
    private String name;
    private int kor;
    private int math;
    private int eng;
    private int hist;
    private int total;
    private int avg;
    private int rank;



}
