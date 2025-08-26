package com.kh.spring04.controller;

import java.util.List; // <-- 잊지 말고 import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring04.dao.StudentDao;
import com.kh.spring04.dto.StudentDto;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/add")
    public String add(@ModelAttribute StudentDto studentDto) {
        studentDao.insert(studentDto);
        return "등록 완료";
    }

    @RequestMapping("/edit")
    public String edit(@ModelAttribute StudentDto studentDto) {
        boolean success = studentDao.update(studentDto);
        return success ? "변경완료" : "존재하지 않는 학생";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam int studentNo) {
        return studentDao.delete(studentNo) ? "삭제 완료" : "존재하지 않는 학생 번호";
    }

    @RequestMapping("/list")
    public String list(
            @RequestParam(required = false) String column,
            @RequestParam(required = false) String keyword
    ) {
        boolean isSearch = column != null && !column.isBlank()
                        && keyword != null && !keyword.isBlank();

        List<StudentDto> studentList = isSearch
                ? studentDao.selectList(column, keyword)   // 검색
                : studentDao.selectList();                 // 전체 조회 (DAO 오버로드 필요)

        StringBuilder buffer = new StringBuilder();
        buffer.append("결과 수 : ").append(studentList.size()).append("<br>");
        if (studentList.isEmpty()) {
            buffer.append("결과가 존재하지 않습니다");
        } else {
            for (StudentDto s : studentList) {
                buffer.append(s).append("<br>");
            }
        }
        return buffer.toString();
    }

    @RequestMapping("/detail")
    public String detail(@RequestParam int studentNo) {
        StudentDto studentDto = studentDao.selectOne(studentNo);
        return (studentDto != null) ? studentDto.toString() : "존재하지 않는 학생 번호";
    }
}
