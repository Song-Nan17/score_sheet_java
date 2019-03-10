package service;

import com.alibaba.fastjson.JSON;
import model.Student;
import tools.DataFile;
import tools.Print;

import java.util.*;

public class Add {

    public static void addStudent(String input) {
        List<String> infos = Arrays.asList(input.split("，"));
        String name = infos.get(0);
        String id = infos.get(1);
        Map<String, Double> scores = getScoreMap(infos);

        String studentsStr = DataFile.read("./students.txt");
        List<Student> students = JSON.parseArray(studentsStr, Student.class);
        students = students == null ? new ArrayList<>() : students;
        students.add(new Student(name, id, scores));
        DataFile.write(JSON.toJSONString(students), "./students.txt");

        Print.finishAdding(name);
    }

    public static Map<String, Double> getScoreMap(List<String> infos) {
        Map<String, Double> scores = new HashMap<>();
        infos.stream().skip(2).map(s -> s.split("：")).forEach(arr -> scores.put(arr[0], Double.parseDouble(arr[1])));
        return scores;
    }
}
