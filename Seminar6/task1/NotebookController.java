package task1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Клас {@code NotebookController} содержит функциональность по фильтрации
 * объектов класса {@code Notebook} по его полям.
 */
public class NotebookController {

    /**
     * Список объектов {@code Notebook} относительно которых, необъодимо выполнять
     * фильтрацию.
     */
    private List<Notebook> notebooks;

    /**
     * Множество всех правил фильтрации.
     */
    public static final HashSet<Integer> ALL_RULES = new HashSet<Integer>(Arrays.asList(1,2,3,4));

    /**
     * Создается объект управления списком объектов {@code Notebook}.
     * @param notebooks
     */
    public NotebookController(List<Notebook> notebooks){
        this.notebooks = notebooks;
    }

    /**
     * Используя ряд вспомогательных методов, выполняется фильтрация 
     * списка объектов класса {@code Notebook} по заданному пользователем
     * критерию.
     * @param rules заданный пользователем критерий фильтрации.
     * @return возвращается список объектов класса {@code Notebook},
     *         отвечающих указанному критерию.
     * @throws IllegalArgumentException выбрасывается при неверном значении
     *         констант классов {@code OperationSystems} и {@code Colors}.
     * @throws NumberFormatException выбрасывается при невозможности сконвертировать
     *         указанное пользователем значения фильтра в число.
     */
    public List<Notebook> filter(Map<Integer, String> rules) throws IllegalArgumentException, NumberFormatException{
        List<Notebook> notebooksFiltered = new LinkedList<>();
        if(rules.containsKey(1)){
            Integer rule = Integer.valueOf((String) rules.get(1));
            filterByRAM(notebooksFiltered, rule);
        }
        else if(rules.containsKey(2)){
            Integer rule = Integer.valueOf((String) rules.get(2));
            filterByHDD(notebooksFiltered, rule);
        }
        else if(rules.containsKey(3)){
            OperationSystems rule = OperationSystems.valueOf(rules.get(3));
            filterByOS(notebooksFiltered, rule);
        }
        else if(rules.containsKey(4)){
            Colors rule = Colors.valueOf(rules.get(4));
            filterByColor(notebooksFiltered, rule);
        }

        return notebooksFiltered;
    }

    private void filterByRAM(List<Notebook> notebooksFiltered, Integer min){
        for(Notebook n : notebooks)
            if(n.getRAM() > min) notebooksFiltered.add(n);
    }

    private void filterByHDD(List<Notebook> notebooksFiltered, Integer min){
        for(Notebook n : notebooks)
            if(n.getHDD() > min) notebooksFiltered.add(n);
    }

    private void filterByOS(List<Notebook> notebooksFiltered, OperationSystems os){
        for(Notebook n : notebooks)
            if(n.getOS() == os) notebooksFiltered.add(n);
    }

    private void filterByColor(List<Notebook> notebooksFiltered, Colors color){
        for(Notebook n : notebooks)
            if(n.getColor() == color) notebooksFiltered.add(n);
    }
}
