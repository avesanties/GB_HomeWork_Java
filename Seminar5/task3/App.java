package task3;

/*
 * 23.09.2022
 * Шлепенков Алексей
 * Telegram: @avesanties
 * Discord: Alexey Sh.#3490
 * e-mail: schlepenkow@gmail.com
 * 
 * Реализовать алгоритм пирамидальной сортировки (HeapSort).
*/

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        print(test(new int[]{1,2,3,4,5,6}, heapSort(new int[]{1,2,3,4,5,6})));
        print(test(new int[]{1,2,3,4,5,6}, heapSort(new int[]{6,5,4,3,2,1})));
        print(test(new int[]{}, heapSort(new int[]{})));
        print(test(new int[]{9,9,9,9,9}, heapSort(new int[]{9,9,9,9,9})));
        print(test(new int[]{5,14,15,29,33}, heapSort(new int[]{33,15,5,14,29})));
    }

    /**
     * Выполняет сдвиг наибольшего элемента в конец массива.
     * В цикле запускает метод {@code makeHeap} создания кучи для
     * неотсортированной части массива.
     * @param arr массив, относительно которого необходимо
     *        выполнить сортировку.
     * @return отсортированный массив.
     */
    public static int[] heapSort(int[] arr){
        for(int i = arr.length - 1; i > 0; i--){
            makeHeap(arr, i);
            int buff = arr[i];
            arr[i] = arr[0];
            arr[0] = buff;
        }

        return arr;
    }

    /**
     * Выполняет создание кучи. В результате
     * в корне дерева оказывается наибольший элемент,
     * который в свою очередь в {@code heapSort}
     * перемещается в отсортированную часть массива.
     * @param arr маассив, относительно которого необходимо
     *        выполнить сортировку.
     * @param end индекс последнего элемента неотсортированной
     *        части массива.
     */
    private static void makeHeap(int[] arr, int end){
        int startNode = (end - 1) / 2;

        for(int i = startNode; i >= 0; i--)
            heapify(arr, end, i);
    }

    /**
     * Рекурсивно перемещает наибольший элемент поддерева кучи
     * в его корень.
     * @param arr маассив, относительно которого необходимо
     *        выполнить сортировку.
     * @param end индекс последнего элемента неотсортированной
     *        части массива.
     * @param root корень текущего поддерева.
     */
    private static void heapify(int[] arr, int end, int root){
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if(left <= end && arr[left] > arr[largest]){
            largest = left;
        }

        if(right <= end && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != root){
            int buff = arr[root];
            arr[root] = arr[largest];
            arr[largest] = buff;

            heapify(arr, end, largest);
        }
    }

    private static boolean test(int[] expected, int[] actual){
        return Arrays.equals(expected, actual);
    }

    private static <T> void print(T content){
        System.out.println(content);
    }
}