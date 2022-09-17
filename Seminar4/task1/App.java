package task1;

/*
 * 16.09.2022
 * Шлепенков Алексей
 * Telegram: @avesanties
 * Discord: Alexey Sh.#3490
 * e-mail: schlepenkow@gmail.com
 * 
 * 1) Реализуйте сущность “Deque” с помощью массива Integer, массив ограничен в размере size <=5 . Нужно реализовать методы

 * boolean offerFirst(Integer element); //добавляет элемент element в самое начало массива. Если элемент удачно добавлен, возвращает true, иначе - false
 * boolean offerLast(Integer element); //добавляет элемент element в конец массива. Если элемент удачно добавлен, возвращает true, иначе - false
 * Integer peekFirst(); //возвращает без удаления элемент из начала массива. Если массив пуст, возвращает значение null
 * Integer peekLast(); //возвращает без удаления последний элемент массива. Если массив пуст, возвращает значение null
 * Integer pollFirst(); //возвращает с удалением элемент из начала массива. Если массив пуст, возвращает значение null
 * Integer pollLast(); //возвращает с удалением последний элемент массива. Если массив пуст, возвращает значение null
 */

public class App {
    public static void main(String[] args) {
        MyArrayDeque arr = new MyArrayDeque();
    }

    static <T>void print(T arg){
        System.out.println(arg);
    }
}

/**
 * Класс частично реализовывает контракт интерфейса Deque для типа Integer.
 * В основе лежит циклический массив элементов типа Integer.
 */
class MyArrayDeque {
    /**
     * Массив, в котором хранятся элементы коллекции.
     */
    private Integer[] elements;

    /**
     * Индекс элемента начала очереди.
     */
    private int tail;

    /**
     * Индекс элемента конца очереди.
     */
    private int head;

    /**
     * Максимальный размер очереди по условию задачи.
     */
    private static int MAX_ARRAY_SIZE = 5;

    /**
     * Создает массив с максимальной емкостью.
     */
    public MyArrayDeque(){
        elements = new Integer[MAX_ARRAY_SIZE];
    }

    /**
     * Добавляет указанный элемент в начало очереди.
     * @param num элемент для добавления в очередь.
     * @return возвращает false, если очередь заполнена, true -
     * - в случае успешного добавления элемента
     * @throws NullPointerException выбрасывается исключение, если указанный элемент равен null
     */
    public boolean offerFirst(Integer num){
        if (num == null)
            throw new NullPointerException();
        
        if(isFull())
            return false;
        
        elements[head] = num;
        head = inc(head, elements.length);
        return true;
    }

    /**
     * Добавляет указанный элемент в конец очереди.
     * @param num элемент для добавления в очередь.
     * @return возвращает false, если очередь заполнена, true -
     * - в случае успешного добавления элемента
     * @throws NullPointerException если указанный элемент равен null
     */
    public boolean offerLast(Integer num){
        if (num == null)
            throw new NullPointerException();
    
        if(isFull())
            return false;
    
        elements[tail = dec(tail, elements.length)] = num;
        return true;
    }
    
    public Integer peekFirst(){
        return elements[dec(head, elements.length)];
    }

    public Integer peekLast(){
        return elements[tail];
    }

    public Integer pollFirst(){
        int h;
        Integer num = elements[h = dec(head, elements.length)];
        if(num != null){
            elements[h] = null;
            head = h;
        }

        return num;
    }

    public Integer pollLast(){
        Integer num = elements[tail];
        if(num != null){
            elements[tail] = null;
            tail = inc(tail, elements.length);
        }

        return num;
    }
    
    /**
     * Представляем значения коллекции в виде строки.
     * Элементы со значением null отображаются для большей
     * наглядности.
     * @return возвращает значения коллекции в виде строки.
     */
    @Override
    public String toString(){
        Integer[] es = elements;
        return String.format("[%d, %d, %d, %d, %d]", es[0], es[1], es[2], es[3], es[4]);
    }

    /**
     * Циклически уменьшает индекс на единицу.
     * @param i текущий индекс.
     * @param length длинна массива.
     * @return возвращает уменьшенное на единицу значение индекса.
     */
    private static int dec(int i, int length){
        if(--i < 0)
            return i = length - 1;
        return i;
    }

    /**
     * Циклически увеличивает индекс на единицу.
     * @param i текущий индекс.
     * @param length длинна массива.
     * @return возвращает увеличенное на единицу значение индекса.
     */
    private static int inc(int i, int length){
        if(++i >= length)
            return i = 0;
        return i;
    }

    /**
     * Проверяет, заполнена ли очередь.
     * @return возвращает результат проверки заполнения очереди.
     */
    private boolean isFull(){
        return elements[tail] != null
                && elements[head] != null
                && (-1 <= head-tail && head-tail<= 1);
    }
}