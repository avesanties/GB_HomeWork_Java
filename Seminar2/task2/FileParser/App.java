package FileParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * 07.09.2022
 * Шлепенков Алексей
 * Telegram: @avesanties
 * Discord: Alexey Sh.#3490
 * e-mail: schlepenkow@gmail.com
 * 
 * Задание 2
 * Напишите программу, которая считает, распарсит и выведет в логгер заранее созданный 
 * файл с именами, предметами и оценками студентов
 * Формат строк в файле:
 * Андрей 5
 * Алена 5
 * Игорь 4
 * Формат вывода: Ученик %s получил сегодня %d.
 */

public class App{
    private static Logger appLogger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        appLogger.info("Start file reading");

        String file = "input.txt";
        try(var br = new BufferedReader(new FileReader(file))){
            String str;
            while((str = br.readLine()) != null){
                String[] data = str.split(" ");
                String name = data[0];
                int mark = Integer.parseInt(data[1]);
                appLogger.info(String.format("Ученик %s получил сегодня %d", name, mark));
            }
            appLogger.info("Reading finished. File closed");
        } catch(IOException e){
            appLogger.log(Level.SEVERE, "File not found", e);
        }
    }
}