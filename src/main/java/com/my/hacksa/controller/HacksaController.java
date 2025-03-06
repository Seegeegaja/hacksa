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

import java.util.*;
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
        List<InputDto> inputDtoList = new ArrayList<>();
        for (StudentDto student : studentDtoList) {
            InputDto inputDto = new InputDto();
            inputDto.setStudent_id(student.getStudent_id());
            inputDto.setName(student.getName());
            for (ExamDto exam : student.getExamList()) {
                inputDto.setKor(exam.getKor());
                inputDto.setMath(exam.getMath());
                inputDto.setEng(exam.getEng());
                inputDto.setHist(exam.getHist());
                inputDto.setTotal(exam.getKor() + exam.getMath() + exam.getEng() + exam.getHist());
                inputDto.setAvg(inputDto.getTotal() / 4);
            }
            inputDtoList.add(inputDto);
        }
        System.out.println("inputDtoList ======= "+inputDtoList);

        inputDtoList.sort((s1, s2) -> Integer.compare(s2.getTotal(), s1.getTotal()));
        int rank = 1;
        for (int i = 0; i < inputDtoList.size(); i++) {
            if (i > 0 && inputDtoList.get(i).getTotal() != inputDtoList.get(i - 1).getTotal()) {
                rank = i + 1;
            }
            inputDtoList.get(i).setRank(rank);
        }
        System.out.println("rank===" + inputDtoList);
        inputDtoList.sort(Comparator.comparing(InputDto::getStudent_id));
        System.out.println(inputDtoList);
        // 등수 계산
        model.addAttribute("dto", inputDtoList);
        return "content/total";
    }

}
//List<ExamDto> examList = examService.AllList();

//        List<InputDto> inputDtoList = examService.calcExam(inputDtoList);
//        System.out.println(studentDtoList);

//        List<InputDto> inputDtos = examList.stream()
//                        .map(x->
//                                new InputDto(x.getId(),x.getKor(),x.getMath(),x.getEng(),x.getHist(),0,x.getStudent_id(),0)).toList();
//        System.out.println(inputDtos);
