package com.my.hacksa.dao;

import com.my.hacksa.entity.Exam;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Transactional
public class ExamDAO {
    @Autowired
    EntityManager em;

}
