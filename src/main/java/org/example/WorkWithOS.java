package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WorkWithOS {
    String strLogs;

    public String createDirectory(String dirpath) {
        File directory = new File(dirpath);
        if (directory.mkdirs()) {
            strLogs = "Directory created successfully";
        } else {
            strLogs = "ERROR not directory created";
        }
        return strLogs;
    }

    public String createFileData(String filename, String dirpath) {
        File newFile = new File(dirpath, filename);
        try {
            if (newFile.createNewFile())
                strLogs = "File created successfully";
            else
                strLogs = "ERROR file not created ";
        } catch (IOException e) {
            strLogs = e.getMessage();
            throw new RuntimeException(e);
        }
        return strLogs;
    }

    public void writeLogsData(String logtext) {
        try {
            FileWriter fw = new FileWriter("C:\\Games\\temp\\temp.txt", true);
            fw.write(logtext);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
