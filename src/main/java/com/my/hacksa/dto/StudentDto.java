package com.my.hacksa.dto;

import com.my.hacksa.constant.Gender;
import com.my.hacksa.entity.Exam;
import com.my.hacksa.entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String student_id;
    private String name;
    private String phone;
    private Gender gender;
    private String address;
    private List<ExamDto> examList = new ArrayList<>();

    public static StudentDto fromEntity(Student student) {
        return new StudentDto(
                student.getStudent_id(),
                student.getName(),
                student.getPhone(),
                student.getGender(),
                student.getAddress(),
                student.getExamList().stream().map(x -> ExamDto.fromEntity(x)).toList()
        );
    }

    public static Student fromDto(StudentDto dto) {
        Student student = new Student();
        student.setStudent_id(dto.getStudent_id());
        student.setName(dto.getName());
        student.setPhone(dto.getPhone());
        student.setGender(dto.getGender());
        student.setAddress(dto.getAddress());
        return student;
    }
}
