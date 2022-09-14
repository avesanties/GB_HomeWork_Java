package task1;

/*
 * 14.09.2022
 * Шлепенков Алексей
 * Telegram: @avesanties
 * Discord: Alexey Sh.#3490
 * e-mail: schlepenkow@gmail.com
 * 
 * Реализовать алгоритм сортировки слиянием.
 */

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] testArr = new int[]{4,5,3,2,7,3,0};
        testArr = sortArr(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    /**
     * Инкапсулирует в себе конкретную реализацию
     * сортировки.
     * @param arr массив, который необходимо отсортировать.
     * @return отсортированный массив.
     */
    static int[] sortArr(int[] arr){
        return divideArr(arr);
    }

    /**
     * Метод, рекурсивно выполняющий разделение массива на два
     * подмассива и вызывающий метод объединения двух массивов.
     * @param arr массив для разделения.
     * @return возвращается массив из одного элемента, считающийся
     * отсортированным, null или объединенный массив.
     */
    private static int[] divideArr(int[] arr){
        if(arr.length == 0) return null;
        if(arr.length == 1) return arr;

        int[] arrHalfOne = new int[arr.length / 2];
        int[] arrHalfTwo = new int[arr.length - arr.length / 2];

        System.arraycopy(arr, 0, arrHalfOne, 0, arrHalfOne.length);
        System.arraycopy(arr, arr.length / 2, arrHalfTwo, 0, arrHalfTwo.length);

        arrHalfOne = divideArr(arrHalfOne);
        arrHalfTwo = divideArr(arrHalfTwo);
    
        return mergeArr(arrHalfOne, arrHalfTwo);
    }

    /**
     * Выполняет слияние двух массивов, каждый из которых,
     * упорядочен во возрастанию.
     * @param arrOne первый отсортированный массив
     * @param arrTwo второй отсортированный массив
     * @return возвращается один массив, состоящий из расположенных по возрастанию элементов двух
     * первоначальных массивов.
     */
    private static int[] mergeArr(int[] arrOne, int[] arrTwo){
        int[] arrRes = new int[arrOne.length + arrTwo.length];
        int positionOne = 0;
        int positionTwo = 0;
        for(int i = 0; i < arrRes.length; i++){
            if(positionOne == arrOne.length){
                arrRes[i] = arrTwo[positionTwo];
                positionTwo++;
            }
            else if(positionTwo == arrTwo.length){
                arrRes[i] = arrOne[positionOne];
                positionOne++;
            }
            else if(arrOne[positionOne] < arrTwo[positionTwo]){
                arrRes[i] = arrOne[positionOne];
                positionOne++;
            }
            else{
                arrRes[i] = arrTwo[positionTwo];
                positionTwo++;
            }
        }
        return arrRes;
    }
}