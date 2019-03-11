package tools;

import java.util.List;

public class Calculate {

    public static double calculateAverage(List<Double> list) {
        double average = list.stream().mapToDouble(x -> x).sum() / list.size();
        return Math.round(average * 100) / 100.0;
    }

    public static double calculateMedian(List<Double> list) {
        int lastIndex = list.size() - 1;
        return lastIndex % 2 == 0 ? list.get(lastIndex / 2) : (list.get(lastIndex / 2) + list.get(lastIndex / 2 + 1)) / 2.0;
    }
}
