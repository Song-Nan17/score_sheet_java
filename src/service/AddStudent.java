package service;

import tools.Input;
import tools.Print;

public class AddStudent {

    public static void addStudent() {
        Print.promptToInputInfo();
        String input = Input.getInput();
        while (!CheckInput.isCorrectInfoFormat(input)) {
            Print.promptCorrectInfoFormat();
            input = Input.getInput();
        }
        Add.addStudent(input);
    }
}
