package tools;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Print {
    public static void printMenu() {
        System.out.print("1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：");
    }

    public static void promptToInputInfo() {
        System.out.print("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
    }

    public static void promptToInputId() {
        System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }

    public static void promptCorrectInfoFormat() {
        System.out.print("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }

    public static void promptCorrectIdFormat() {
        System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }

    public static void finishAdding(String name) {
        System.out.println("学生" + name + "的成绩被添加");
    }
}
