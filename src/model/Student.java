package model;

import java.util.Map;

public class Student {
    private String name;
    private String id;
    private Map<String, Double> scores;
    private double totalScore;
    private double averageScore;

    public Student(String name, String id, Map<String, Double> scores) {
        this.name = name;
        this.id = id;
        this.scores = scores;
        this.totalScore = computeTotalScore();
        this.averageScore = this.totalScore / this.scores.size();
    }

    public double computeTotalScore() {
        return this.scores.values().stream().reduce(0.0, Double::sum);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Double> getScores() {
        return this.scores;
    }

    public void setScores(Map<String, Double> scores) {
        this.scores = scores;
    }

    public double getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public double getAverageScore() {
        return this.averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
}
