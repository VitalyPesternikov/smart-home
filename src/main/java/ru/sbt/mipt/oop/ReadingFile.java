package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Vitaly on 12.10.2017.
 */
public class ReadingFile {
    Gson gson = new Gson();
    String json;
    public SmartHome createsmarthome() throws IOException{
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        return gson.fromJson(json, SmartHome.class);
    }
}
