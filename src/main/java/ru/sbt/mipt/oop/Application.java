package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //ReadingFile readingFile = new ReadingFile();
        //SmartHome smartHome = readingFile.createSmartHome("smart-home-1.js");
        // начинаем цикл обработки событий
        ProcessingEvents processingEvents = (ProcessingEvents)context.getBean("processingEvents");//new ProcessingEvents(smartHome);
        processingEvents.process();

    }

}
