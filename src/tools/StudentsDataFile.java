package tools;

import java.io.*;

public class StudentsDataFile {

    public static void write(String content) {
        BufferedWriter writer = null;
        try {
            File file = new File("./students.txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            writer = new BufferedWriter(fileWriter);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read() {
        String studentsStr = "";
        File file = new File("./students.txt");
        if (file.exists()) {
            BufferedReader reader = null;
            try {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String tempString = null;
                while ((tempString = reader.readLine()) != null) {
                    studentsStr += tempString;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return studentsStr;
    }
}
