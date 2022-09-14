package task2;

import java.util.ArrayList;

/*
 * 14.09.2022
 * Шлепенков Алексей
 * Telegram: @avesanties
 * Discord: Alexey Sh.#3490
 * e-mail: schlepenkow@gmail.com
 * 
 * Пусть дан произвольный список(ArrayList) целых чисел, удалить из него четные числа.
 */

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>();
        numList.add(5);
        numList.add(4);
        numList.add(4);
        numList.add(9);
        numList.add(17);
        numList.add(3);

        System.out.println(numList.toString());
        
        for(int i = 0; i < numList.size(); i++){
            if(numList.get(i) % 2 == 0){
                numList.remove(i);
                i--;
            } 
        }
            
        System.out.println(numList.toString());
    }
}
