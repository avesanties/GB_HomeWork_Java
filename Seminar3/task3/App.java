package task3;

import java.util.ArrayList;

/*
 * 14.09.2022
 * Шлепенков Алексей
 * Telegram: @avesanties
 * Discord: Alexey Sh.#3490
 * e-mail: schlepenkow@gmail.com
 * 
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
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

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : numList){
            if(num > max) max = num;
            if(num < min) min = num;
            sum += num;
        }
        double avg = ((double)sum) / numList.size();

        System.out.println(String.format("max: %d, min: %d, average: %.2f", max, min, avg));
    }
}
