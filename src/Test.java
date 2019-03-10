import model.Student;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Double> scores = new HashMap<>();
        scores.put("英语", 95.0);
        scores.put("语文", 90.0);
        scores.put("数学", 95.0);
        Student student = new Student("小明", "2150302036", scores);
        System.out.println("name: " + student.getName() + " id: " + student.getId() + " scores: " + student.getScores() + " total: " + student.getTotalScore()
                + " average: " + student.getAverageScore());
    }
}
