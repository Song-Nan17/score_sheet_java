package service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CheckInput {
    public static boolean isCorrectInfoFormat(String input) {
        List<String> infos = Arrays.asList(input.split("，"));
        boolean isCorrect = infos.size() >= 2 ? true : false;
        if (infos.size() > 2) {
            isCorrect = infos.stream().skip(2).map(s -> s.split("：")).allMatch(s -> s.length == 2 && isNumberic(s[1]));
        }
        return isCorrect;
    }

    public static boolean isCorrectIdFormat(String input) {
        return Arrays.stream(input.split("，")).anyMatch(id -> isNumberic(id));
    }

    public static boolean isNumberic(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        return pattern.matcher(str).matches() ? true : false;
    }
}