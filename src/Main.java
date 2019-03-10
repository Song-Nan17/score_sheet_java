import service.AddStudent;
import service.GenerateScoreSheet;
import tools.Input;
import tools.Print;

public class Main {
    public static void main(String[] args) {
        RUN:
        while (true) {
            Print.printMenu();
            String choice = Input.getInput();
            switch (choice) {
                case "1":
                    AddStudent.addStudent();
                    continue RUN;
                case "2":
                    GenerateScoreSheet.generateScoreSheet();
                    continue RUN;
                case "3":
                    break RUN;
            }
        }
    }
}
