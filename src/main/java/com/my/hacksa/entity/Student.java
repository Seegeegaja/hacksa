package com.my.hacksa.entity;

import com.my.hacksa.constant.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @Column(nullable = false, length = 6)
    private String student_id;
    @Column(length = 10)
    private String name;
    @Column(length = 15)
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(length = 20)
    private String address;

    @OneToMany(mappedBy = "student" , fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Exam> examList = new ArrayList<>();
}
