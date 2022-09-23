package Seminar5.task1;

/*
 * 19.09.2022
 * Шлепенков Алексей
 * Telegram: @avesanties
 * Discord: Alexey Sh.#3490
 * e-mail: schlepenkow@gmail.com
 * 
 * 
 * Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
 * Строки с одинаковой длиной не должны “потеряться”.
 * Пример:
 * “Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись”
 * Результат:
 * [и], [ты], [Еще], [день, друг, Пора], [Мороз], [солнце], [чудесный, дремлешь, проснись], [красавица], [прелестный]
 */

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String inputStr = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        var res = wordsSort(inputStr);
        System.out.println(res);
    }

    /**
     * Метод сортирует слова входной строки на основе их длины.
     * Для хранения слов с одинаковой длиной используется одна из реализаций
     * интерфейса List - ArrayList.
     * @param s строка для сортировки.
     * @return возвращает tree map объект, содержащий слова, расположенные
     *         по возрастанию их длины.
     */
    private static TreeMap<Integer, List<String>> wordsSort(String s){
        var sortedMap = new TreeMap<Integer, List<String>>();
        for(String word : s.split(" ")){
            int l = word.length();
            if(!sortedMap.containsKey(l)) 
                sortedMap.put(l, new ArrayList<>());
            
            sortedMap.get(l).add(word);
        }
        return sortedMap;
    }
}
