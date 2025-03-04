package com.my.hacksa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputDto {
    private int kor;
    private int math;
    private int eng;
    private int hist;
    private int total;
    private String student_id;
    private int rank;
}
