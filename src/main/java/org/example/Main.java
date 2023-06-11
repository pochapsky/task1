package org.example;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> dirList = new ArrayList<String>();
        dirList.add("C:\\Games" + "/temp");
        dirList.add("C:\\Games" + "/savegames");
        dirList.add("C:\\Games" + "/src/main");
        dirList.add("C:\\Games" + "/src/test");
        dirList.add("C:\\Games" + "/res/drawables");
        dirList.add("C:\\Games" + "/res/vectors");
        dirList.add("C:\\Games" + "/res/icons");
        Map<String, String> fileDir = new HashMap<String, String>();
        fileDir.put("Main.java", "C:\\Games" + "/src/main");
        fileDir.put("Utils.java", "C:\\Games" + "/src/main");
        fileDir.put("temp.txt", "C:\\Games" + "/temp");
        WorkWithOS workWithOS = new WorkWithOS();
        String logs = new String();
        StringBuilder sb = new StringBuilder(logs);
        for (String list : dirList) {
            LocalDateTime currentDate = LocalDateTime.now();
            sb.append(String.valueOf(currentDate) + "|" + String.valueOf(workWithOS.createDirectory(list)) + "|" + String.valueOf(list) + "\n");
        }
        for (Map.Entry<String, String> item : fileDir.entrySet()) {
            LocalDateTime currentDate = LocalDateTime.now();
            sb.append(String.valueOf(currentDate) + "|" + String.valueOf(item.getKey()) + "|" + String.valueOf(workWithOS.createFileData(item.getKey(), item.getValue())) + "\n");
        }
        workWithOS.writeLogsData(sb.toString());


    }
}