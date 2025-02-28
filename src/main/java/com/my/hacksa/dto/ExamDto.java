package com.my.hacksa.dto;

import com.my.hacksa.entity.Exam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExamDto {
    private Long id;
    private int kor;
    private int math;
    private int eng;
    private int hist;
    private String student_id;

    public ExamDto(Long id, int kor, int math, int eng, int hist, String student_id) {
        this.id = id;
        this.kor = kor;
        this.math = math;
        this.eng = eng;
        this.hist = hist;
        this.student_id = student_id;
    }

    public ExamDto(Long id, int kor, int math, int eng, int hist) {
        this.id = id;
        this.kor = kor;
        this.math = math;
        this.eng = eng;
        this.hist = hist;
    }


    public static ExamDto fromEntity(Exam exam) {
        String studentId = null;
        if (exam.getStudent() != null) {
            studentId = exam.getStudent().getStudent_id();
        }
        return new ExamDto(
                exam.getId(),
                exam.getKor(),
                exam.getMath(),
                exam.getEng(),
                exam.getHist(),
                studentId
        );
    }

    public static Exam fromDto(ExamDto dto) {
        Exam exam = new Exam();
        exam.setId(dto.getId());
        exam.setKor(dto.getKor());
        exam.setMath(dto.getMath());
        exam.setEng(dto.getEng());
        exam.setHist(dto.getHist());
        return exam;
    }
}
