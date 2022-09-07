package TestWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * 06.09.2022
 * Шлепенков Алексей
 * Telegram: @avesanties
 * Discord: Alexey Sh.#3490
 * e-mail: schlepenkow@gmail.com
 * 
 * Задание 1
 * Напишите программу, записывающую 100 раз слово ”ТЕST” в файл.
 * Слова должны чередоваться по формату – четная итерация большими
 * буквами, нечетные – маленькими Пример: TESTtestTESTtestTEST…
 */

public class App{
    private static Logger appLogger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        String wordUpperCase = "TEST";
        String wordLowerCase = "test";
        String fileName = "output.txt";

        appLogger.info("Open file specified file");
        try(var bf = new BufferedWriter(new FileWriter(fileName))){
            appLogger.info("Write content to the file");
            bf.write(getWholeString(wordLowerCase, wordUpperCase));
        }
        catch(IOException e){
            appLogger.log(Level.SEVERE, "Can't open specified file", e);
        }

        appLogger.info("Content is written to file. The app is exiting");
    }

    /**
     * Создает строку для записи в файл.
     * @param args части строки.
     * @return возвращает строку для записи в файл.
     * Если массив аргументов пуст, возвращается пустая строка.
     */
    private static String getWholeString(String ...args){
        if (args.length == 0) return "";

        String partString = "";
        for(String str : args)
            partString += str + "\n";
        
        var sb = new StringBuilder();
        int count = 50;
        for(int i = 0; i < count; i++)
            sb.append(partString);

        return sb.toString();
    }
}