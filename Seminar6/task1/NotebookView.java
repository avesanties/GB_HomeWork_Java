package task1;

import java.util.List;

/**
 * Клас реализует логику представления результатов работы с коллекцией
 * объектов {@code Notebook}.
 */
public class NotebookView {

    /**
     * Представляет результаты фильтрации метода {@link NotebookController#filter(java.util.Map) filter}
     * класса {@code NotebookController}.
     * @param notebooks список объектов класса {@code Notebook}.
     */
    public static void showTable(List<Notebook> notebooks){
        System.out.println("-".repeat(100) + "\nResult:");
        for(Notebook n : notebooks)
            System.out.println(String.format("Model: %s, RAM: %s, HDD: %s, OS: %s, Color: %s.", n.getModel()
                                                                                                ,n.getRAM()
                                                                                                ,n.getHDD()
                                                                                                ,n.getOS()
                                                                                                ,n.getColor()));
        System.out.println(String.format("%d rows", notebooks.size()));
    }

    /**
     * Отображает опции для пользователя.
     */
    public static void showHelp(){
        System.out.println("Provide filter criteria as presented below: ");
        System.out.println("1 RAM\n2 HDD\n3 Operation system\n4 Color.\n");
    }
}
