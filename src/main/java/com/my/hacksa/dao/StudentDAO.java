package com.my.hacksa.dao;

import com.my.hacksa.entity.Exam;
import com.my.hacksa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class StudentDAO {
    @Autowired
    EntityManager em;

    public List<Student> getAllList(){
        String sql = "SELECT s FROM Student AS s " +
                "ORDER BY s.student_id ASC";
        List<Student> students = em.createQuery(sql).getResultList();
        return students;
    }
    public void insert(Exam exam, String studentId) {
        Student student = em.find(Student.class, studentId);
        exam.setStudent(student);
        student.getExamList().add(exam);
        em.persist(exam);
        em.persist(student);

    }
//    "SELECT s FROM Student AS s " +
//            "JOIN FETCH s.examList " +
//            "ORDER BY s.student_id ASC";
//SELECT * from student s left join exam e on s.student_id = e.student_id;
    public List<Student> AllList() {
        String sql = "SELECT s FROM Student s LEFT JOIN Exam e ON s.student_id = e.student.student_id";
        List<Student> students = em.createQuery(sql , Student.class).getResultList();
        return students;
    }


}
