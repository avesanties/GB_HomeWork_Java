package task1;
/**
 * Класс описывает состояние ноутбука и предоставляет
 * простейший интерфейс для взаимодействия с ним.
 */
public class Notebook{
    /**
     * Наименование модели ноутбука.
     */
    private final String model;

    /**
     * Объем оперативной памяти в Гб.
     */
    private int ram;

    /**
     * Операционных система ноутбука. Представлена 
     * объектом класса {@code OperationSystems}.
     */
    private OperationSystems os;

    /**
     * Объем жесткого диска.
     */
    private int hdd;

    /**
     * Цвет ноутбука. Представлен объектом
     * класса {@code Colors}.
     */
    private final Colors color;

    /**
     * Создает объект класса {@code Notebook} с использованием
     * полей внутреннего класса {@code NotebookBuilder}.
     * Реализация паттерна builder подсмотрена <a href="https://github.com/iluwatar/java-design-patterns/tree/master/builder">тут</a>.
     * @param nb
     */
    private Notebook(NotebookBuilder nb){
        this.model = nb.model;
        this.ram = nb.ram;
        this.os = nb.os;
        this.hdd = nb.hdd;
        this.color = nb.color;
    }

    public String getModel(){ return this.model;}

    public int getRAM(){ return this.ram;}

    public OperationSystems getOS(){ return this.os;}

    public int getHDD(){ return this.hdd;}

    public Colors getColor(){ return this.color;}

    public static class NotebookBuilder{
        private String model;
        private int ram;
        private OperationSystems os;
        private int hdd;
        private Colors color;

        public NotebookBuilder(String model){
            this.model = model;
        }

        public NotebookBuilder setRAM(int ram){
            this.ram = ram;
            return this;
        }

        public NotebookBuilder setOS(OperationSystems os){
            this.os = os;
            return this;
        }

        public NotebookBuilder setHDD(int hdd){
            this.hdd = hdd;
            return this;
        }

        public NotebookBuilder setColor(Colors color){
            this.color = color;
            return this;
        }

        public Notebook build(){
            return new Notebook(this);
        }
    }
}

/**
 * Перечисление цветов поля color класса {@code Notebook}.
 */
enum Colors{
    RED("Red"), BLUE("Blue"), BLACK("Black"), WHITE("White"), GREEN("Green");

    private String color;
    Colors(String name){
        this.color = name;
    }

    @Override
    public String toString(){
        return color;
    }
}

/**
 * Перечисление операционных систем поля os класса {@code Notebook}.
 */
enum OperationSystems{
    WINDOWS10("Windows 10"), WINDOWS11("Windows 11"), UBUNTU("Ubuntu"), MACOS("Mac OS");

    private String name;
    OperationSystems(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }
}