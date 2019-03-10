package tools;

import java.io.*;

public class DataFile {

    public static void write(String content, String pathName) {
        BufferedWriter writer = null;
        try {
            File file = new File(pathName);
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

    public static String read(String pathName) {
        String studentsStr = "";
        File file = new File(pathName);
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
