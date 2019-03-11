package service;

import tools.Input;
import tools.Print;

public class GenerateScoreSheet {
    public static void generateScoreSheet() {
        Print.promptToInputId();
        String input = Input.getInput();
        while (!CheckInput.isCorrectIdFormat(input)) {
            Print.promptCorrectIdFormat();
            input = Input.getInput();
        }
        String scoreSheet = GetScoreSheet.getScoreSheet(input);
        Print.print(scoreSheet);
    }
}
