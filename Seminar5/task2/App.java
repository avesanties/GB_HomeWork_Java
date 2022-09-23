package task2;

/*
 * 19.09.2022
 * Шлепенков Алексей
 * Telegram: @avesanties
 * Discord: Alexey Sh.#3490
 * e-mail: schlepenkow@gmail.com
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) {
        var pb = new PhoneBook();
        pb.add("259-32-00", "Alex");
        pb.add("259-32-01", "James");
        pb.add("259-32-02", "James");

        System.out.println(pb.getPhoneNumber("James"));
        pb.removePhoneNumber("James");
        System.out.println(pb.getPhoneNumber("Alex"));
    }
}
/**
 * Простой класс, реализующий логику телефонной книги.
 * Для хранения данных используется структура HashMap.
 */
class PhoneBook{
    private HashMap<String, List<String>> persons = new HashMap<>();

    public void add(String phoneNumber, String name){
        if(!persons.containsKey(name))
            persons.put(name, new ArrayList<>());
        
        persons.get(name).add(phoneNumber);
    }

    public String getPhoneNumber(String name){
        if(!persons.containsKey(name))
            return "";
        
        String numbers = "";
        for(String number : persons.get(name)){
            numbers += number + " ";
        }

        return numbers;
    }

    public void removePhoneNumber(String name){
        if(name != null)
            persons.remove(name);
    }
}
