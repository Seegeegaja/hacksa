package com.my.hacksa.service;

import com.my.hacksa.dao.StudentDAO;
import com.my.hacksa.dto.ExamDto;
import com.my.hacksa.dto.InputDto;
import com.my.hacksa.dto.StudentDto;
import com.my.hacksa.entity.Exam;
import com.my.hacksa.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentDAO dao;


    public List<StudentDto> getAllList() {
        List<Student> students = dao.getAllList();
        if (ObjectUtils.isEmpty(students)) {
            return Collections.emptyList();
        }
        return students.stream().map(x -> StudentDto.fromEntity(x)).toList();
    }

    public void insrt(InputDto dto) {
        Exam exam = new Exam();
        exam.setMath(dto.getMath());
        exam.setEng(dto.getEng());
        exam.setKor(dto.getKor());
        exam.setHist(dto.getHist());
        dao.insert(exam, dto.getStudent_id());
    }

    public List<StudentDto> AllList() {
        List<Student> students = dao.AllList();
        return students.stream().map(x -> StudentDto.fromEntity(x)).toList();
    }
}
