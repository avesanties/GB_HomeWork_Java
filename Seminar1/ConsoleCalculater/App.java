package Seminar1.ConsoleCalculater;

import java.util.Scanner;

/*
 * 03.09.2022
 * Шлепенков Алексей
 * Telegram: @avesanties
 * Discord: Alexey Sh.#3490
 * e-mail: schlepenkow@gmail.com
 * 
 * Написать консольный калькулятор принимающий два числа и оператор(умножение, деление, сложение, вычитание)
 * и завершающий процесс по решению пользователя. Завершающее слово должно быть не регистрочувствительным
 * (Пример: поданные слова в разном регистре "Да", "да", "дА", "ДА" - должны быть однозначно трактованны, как "Да").
 * 
 * Пример:
 * Введите первое число:
 * 5
 * Введите второе число:
 * 10
 * Введите желаемую операцию
 *
 * Результат: 50
 * Хотите продолжить?
 * Нет
 */

public class App{
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        boolean isExit = false;

        while(!isExit){
            print("Введите первое число: ");
            double num1 = sc.nextDouble();

            print("Введите второе число: ");
            double num2 = sc.nextDouble();

            print("Введите желаемую операцию");
            String op = sc.next();

            double result = (double)Math.round(operation(op, num1, num2) * 100) / 100;
            
            print("Результат: " + result);

            print("Хотите продолжить? нет - выйти.");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("нет")) isExit = true;
        }
        sc.close();
    }

    /**
     * Простой метод для вывода сообщений в консоль.
     * @param message содержание сообщения
     */
    private static void print(String message){
        System.out.println(message);
    }

    /**
     * Возвращает результат вычисления на основании заданных аргументов и операции.
     * Если операция, заданная пользователем не распознана, выводится сообщение об ошибке,
     * приложение закрывается.
     * @param op операция над аргументами
     * @param num1 первый аргумент
     * @param num2 второй аргумент
     * @return результат вычисления
     */
    private static double operation(String op, double num1, double num2){
        switch (op){
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            default:
                print("Операция не найдена! Калькулятор будет закрыт.");
                System.exit(1);
                return 0.0;
        }
    }
}