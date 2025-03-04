package com.my.hacksa.service;

import com.my.hacksa.dao.ExamDAO;
import com.my.hacksa.dto.ExamDto;
import com.my.hacksa.entity.Exam;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamDAO dao;


}
