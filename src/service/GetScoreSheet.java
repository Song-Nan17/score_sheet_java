package service;

import com.alibaba.fastjson.JSON;
import model.Student;
import tools.DataFile;

import java.util.*;
import java.util.stream.Collectors;

public class GetScoreSheet {
    public static String getScoreSheet(String input) {
        String scoreSheet = "当前数据中还没有学生信息，无法获取成绩单。";
        List<String> ids = Arrays.asList(input.split("，"));
        String studentsStr = DataFile.read("./students.txt");
        if (!studentsStr.isEmpty()) {
            scoreSheet = "输入的学生学号不存在。";
            List<Student> students = JSON.parseArray(studentsStr, Student.class);
            List<Student> wantedStudents = students.stream().filter(student -> ids.contains(student.getId())).collect(Collectors.toList());
            if (!wantedStudents.isEmpty()) {
                scoreSheet = MakeScoreSheet.makeScoreSheet(wantedStudents, students);
                DataFile.write(scoreSheet, "./scoreSheet.txt");
            }
        }
        return scoreSheet;
    }
}
