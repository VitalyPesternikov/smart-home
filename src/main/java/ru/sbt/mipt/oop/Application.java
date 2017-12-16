package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        ReadingFile readingFile = new ReadingFile();
        SmartHome smartHome = readingFile.createSmartHome("smart-home-1.js");
        // начинаем цикл обработки событий
        ProcessingEvents processingEvents = new ProcessingEvents(smartHome);
        processingEvents.process();

    }

}
