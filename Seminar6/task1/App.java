package task1;

/*
 * 27.09.2022
 * Шлепенков Алексей
 * Telegram: @avesanties
 * Discord: Alexey Sh.#3490
 * e-mail: schlepenkow@gmail.com
 * 
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * Создать множество ноутбуков.
 * Реализовать методы фильтрации-сортировки ноутбуки их первоначального множества
 * и вывести проходящие по условиям. Сделать так, как мы обсуждали на семинаре (M - V - C)
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var n1 = new Notebook.NotebookBuilder("Huawei MateBook D 14 14")
                        .setColor(Colors.BLACK).setHDD(1000)
                        .setOS(OperationSystems.WINDOWS11).setRAM(6).build();
        var n2 = new Notebook.NotebookBuilder("Digma EVE 10 A201, 10.1")
                        .setColor(Colors.BLACK).setHDD(500)
                        .setOS(OperationSystems.WINDOWS10).setRAM(2).build();
        var n3 = new Notebook.NotebookBuilder("ASUS L210MA-GJ243T, 11.6")
                        .setColor(Colors.WHITE).setHDD(1000)
                        .setOS(OperationSystems.WINDOWS11).setRAM(4).build();
        var n4 = new Notebook.NotebookBuilder("Lenovo IdeaPad 1 11ADA05, 11.6")
                        .setColor(Colors.GREEN).setHDD(1000)
                        .setOS(OperationSystems.WINDOWS11).setRAM(4).build();
        var n5 = new Notebook.NotebookBuilder("HP 14s-dq3002ur, 14")
                        .setColor(Colors.BLACK).setHDD(1500)
                        .setOS(OperationSystems.WINDOWS11).setRAM(8).build();
        var n6 = new Notebook.NotebookBuilder(" HP 250 G8, 15.6")
                        .setColor(Colors.GREEN).setHDD(256)
                        .setOS(OperationSystems.UBUNTU).setRAM(6).build();

        var nc = new NotebookController(Arrays.asList(n1,n2,n3,n4,n5,n6));

        boolean isExit = false;
        var sc = new Scanner(System.in);
        while(!isExit){
            NotebookView.showHelp();
            try{
                String[] userInput = sc.nextLine().split(" ");
                Integer filterId = Integer.valueOf(userInput[0]);
                String filterValue = userInput[1];

                if (!NotebookController.ALL_RULES.contains(filterId)){
                    System.out.println("Wrong rule provided.");
                } else{
                    var inputFilter = new HashMap<Integer, String>();
                    inputFilter.put(filterId, filterValue);
                    var result = nc.filter(inputFilter);
                    NotebookView.showTable(result);
                }
            }
            catch(NumberFormatException e){
                System.out.println("Wrong filter number provided.");
            }catch(IndexOutOfBoundsException e){
                System.out.println("Not enough or no parameters provided.");
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            System.out.println("\nType N to exit.");
            if(sc.nextLine().equalsIgnoreCase("n"))
                isExit = true;
        }
        sc.close();
    }
}