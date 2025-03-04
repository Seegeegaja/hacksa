package com.my.hacksa.controller;

import com.my.hacksa.dto.ExamDto;
import com.my.hacksa.dto.InputDto;
import com.my.hacksa.dto.StudentDto;
import com.my.hacksa.entity.Exam;
import com.my.hacksa.service.ExamService;
import com.my.hacksa.service.StudentService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("content")
public class HacksaController {
    private final StudentService service;
    private final ExamService examService;

    public HacksaController(StudentService service, ExamService examService) {
        this.service = service;
        this.examService = examService;
    }

    @GetMapping("list")
    public String list(Model model) {
        List<StudentDto> studentDtoList = service.getAllList();
        model.addAttribute("dto", studentDtoList);
        return "content/list";
    }

    @GetMapping("examInsert")
    public String examInsert() {
        return "content/examInsert";
    }

    @GetMapping("examInto")
    public String insert(InputDto dto) {
        service.insrt(dto);
        return "redirect:/content/examInsert";
    }

    @GetMapping("total")
    public String total(Model model) {
        List<StudentDto> studentDtoList = service.AllList();

        model.addAttribute("dto", studentDtoList);

        return "content/total";
    }

}
