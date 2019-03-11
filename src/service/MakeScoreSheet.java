package service;

import com.sun.deploy.util.StringUtils;
import model.Student;
import tools.Calculate;

import java.util.*;
import java.util.stream.Collectors;

public class MakeScoreSheet {
    public static String makeScoreSheet(List<Student> wantedStudents, List<Student> students) {
        String scoreSheet = "成绩单\n";
        Set<String> courses = getCourses(wantedStudents.get(0));
        List<String> scoreStrings = getScoreStrings(wantedStudents, courses);
        scoreSheet += "姓名|" + StringUtils.join(courses, "|") + "|平均分|总分\n" +
                "========================\n" +
                StringUtils.join(scoreStrings, "\n") +
                "\n========================\n";
        List<Double> totalScores = students.stream().mapToDouble(student -> student.getTotalScore())
                .boxed().collect(Collectors.toList());
        scoreSheet += "全班总分平均数：" + formatScore(Calculate.calculateAverage(totalScores)) +
                "\n全班总分中位数：" + formatScore(Calculate.calculateMedian(totalScores)) + "\n";
        return scoreSheet;
    }

    public static Set<String> getCourses(Student student) {
        return student.getScores().keySet();
    }

    public static List<String> getScoreStrings(List<Student> students, Set<String> courses) {
        List<String> scoreStrings = new ArrayList<>();
        students.stream().forEach(student -> {
            String scoreString = student.getName();
            Map<String, Double> scores = student.getScores();
            for (String course : courses) {
                Optional optional = Optional.ofNullable(scores.get(course));
                Double score = (Double) optional.orElse(0.0);
                scoreString += "|" + formatScore(score);
            }
            scoreString += "|" + formatScore(student.getAverageScore()) + "|" + formatScore(student.getTotalScore());
            scoreStrings.add(scoreString);
        });
        return scoreStrings;
    }

    public static String formatScore(Double score) {
        return score % 1 != 0 ? "" + score : "" + score.intValue();
    }
}
