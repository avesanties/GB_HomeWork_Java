package task2;

import java.util.ArrayDeque;

/*
 * 17.09.2022
 * Шлепенков Алексей
 * Telegram: @avesanties
 * Discord: Alexey Sh.#3490
 * e-mail: schlepenkow@gmail.com
 * 
 * Дана строка содержащая последовательность логически верно открывающихся
 * и закрывающихся скобок. Требуется написать метод, удаляющий крайние скобки
 * и выводящий при этом логически правильное выражение.
 * Пример 1:Ввод: s = "(()())(())" Вывод: "()()()”
 * Пример 2: Ввод: s = "()()" Вывод: ""
 */

public class App{
    public static void main(String[] args) {
        System.out.println(test("", cutParentheses("")));
        System.out.println(test("", cutParentheses("()()()")));
        System.out.println(test("()", cutParentheses("(())")));
        System.out.println(test("()()", cutParentheses("(())(())()")));
        System.out.println(test("(()())", cutParentheses("((()()))")));
        System.out.println(test("()()()", cutParentheses("(()())(())")));
        System.out.println(test("(((())))", cutParentheses("((((()))))")));
    }

    /**
     * Метод удаляет содержащиеся в строке скобки верхнего уровня.
     * @param s строка, содержащая логически верно открывающиеся и закрывающие скобки.
     * @return возвращает строку без скобок верхнего уровня.
     */
    private static String cutParentheses(String s){
        ArrayDeque<Character> resultDeq = new ArrayDeque<>();
        int lvl = 0;
        for(Character ch : s.toCharArray()){
            if(ch == '('){
                if(lvl != 0) resultDeq.add(ch);
                lvl++;
            } else if(ch == ')'){
                lvl--;
                if(lvl != 0) resultDeq.add(ch);
            }
        }

        return ConvertToString(resultDeq);
    }

    private static String ConvertToString(ArrayDeque<Character> deq){
        StringBuilder sb = new StringBuilder();
        for(Character ch : deq){
            sb.append(ch);
        }

        return sb.toString();
    }

    private static boolean test(String expected, String Actual){
        return expected.equals(Actual);
    }
}
