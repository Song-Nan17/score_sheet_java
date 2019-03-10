package service;

import com.alibaba.fastjson.JSON;
import model.Student;
import tools.Print;
import tools.StudentsDataFile;

import java.util.*;

public class Add {

    public static void addStudent(String input) {
        List<String> infos = Arrays.asList(input.split("，"));
        String name = infos.get(0);
        String id = infos.get(1);
        Map<String, Double> scores = getScoreMap(infos);

        String studentsStr = StudentsDataFile.read();
        List<Student> students = JSON.parseArray(studentsStr, Student.class);
        students = students == null ? new ArrayList<>() : students;
        students.add(new Student(name, id, scores));
        StudentsDataFile.write(JSON.toJSONString(students));

        Print.finishAdding(name);
    }

    public static Map<String, Double> getScoreMap(List<String> infos) {
        Map<String, Double> scores = new HashMap<>();
        infos.stream().skip(2).map(s -> s.split("：")).forEach(arr -> scores.put(arr[0], Double.parseDouble(arr[1])));
        return scores;
    }
}
