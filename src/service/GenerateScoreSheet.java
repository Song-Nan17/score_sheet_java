package service;

import tools.DataFile;
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
        String scoreSheet = GetScoreSheet.getScoreSheet();
        DataFile.write(scoreSheet, "./scoreSheet.txt");
        System.out.println(scoreSheet);
    }
}
