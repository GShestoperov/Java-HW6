import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashSet<Notebook> notebooks = new HashSet<>();

        notebooks.add(new Notebook("XJ-10", "Honor", 0x555555, "iCore7", 3.2,
                16, 512, "Windows 11 Home"));
        notebooks.add(new Notebook("XJ-11", "Honor", 0x555555, "iCore7", 3.2,
                8, 256, "Windows 11 Home"));
        notebooks.add(new Notebook("XJ-12", "Honor", 0x555555, "iCore7", 3.2,
                32, 1024, "Windows 11 Home"));
        notebooks.add(new Notebook("XJ-12", "Honor", 0x555555, "iCore7", 3.2,
                32, 1024, "Linux"));
        notebooks.add(new Notebook("XJ-12", "Honor", 0x333333, "iCore7", 3.2,
                32, 1024, "Linux"));
        notebooks.add(new Notebook("XJ-16", "Honor", 0x555555, "AMD", 3.0,
                16, 512, "Windows 11 Home"));
        notebooks.add(new Notebook("XJ-17", "Honor", 0x555555, "AMD", 3.0,
                16, 512, "Linux"));

        HashMap<Criterion, String> criteria = new HashMap<>();
        do {
            System.out.print(
                    "--- База данных по ноутбкукам -----------------------------------------------\n" +
                            "1 - Добавить критерий для фильтрации\n" +
                            "2 - Вывести все критерии для фильтрации\n" +
                            "3 - Удалить критерий для фильтрации\n" +
                            "4 - Фильтровать ноутбуки\n" +
                            "5 - Вывести все ноутбуки\n" +
                            "6 - Выход\n" +
                            "-----------------------------------------------------------------------------\n" +
                            "> ");
            int userInput = Integer.parseInt(scanner.nextLine());
            switch (userInput) {
                case 1:
                    addCriterion(criteria);
                    break;
                case 2:
                    outputCriteria(criteria);
                    break;
                case 3:
                    deleteCriterion(criteria);
                    break;
                case 4:
                    filterNotebooks(notebooks, criteria);
                    break;
                case 5:
                    outputNotebooks(notebooks);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Неверная команда");
                    continue;
            }
        } while (true);
    }

    public static void addCriterion(HashMap<Criterion, String> criteria) {
        System.out.print("Введите критерий фильтрации: \n" +
                "1 - ОЗУ\n" +
                "2 - Объем ЖД\n" +
                "3 - Операционная система\n" +
                "4 - Цвет\n" +
                "5 - Процессор\n" +
                "6 - Частота процессора\n" +
                "7 - Модель ноутбука\n" +
                "8 - Бренд ноутбука\n" +
                "> ");
        int userInput = Integer.parseInt(scanner.nextLine());
        Criterion criterion;
        switch (userInput) {
            case 1:
                criterion = Criterion.MEMORY_CAPACITY;
                System.out.print("Введите минимальный объем памяти (в Гб): ");
                break;
            case 2:
                criterion = Criterion.STORAGE_CAPACITY;
                System.out.print("Введите минимальный объем ЖД (в Гб): ");
                break;
            case 3:
                criterion = Criterion.OS;
                System.out.print("Введите название и версию операционной системы: ");
                break;
            case 4:
                criterion = Criterion.COLOR;
                System.out.print("Введите числовое значение цвета: ");
                break;
            case 5:
                criterion = Criterion.PROCESSOR;
                System.out.print("Введите название процессора: ");
                break;
            case 6:
                criterion = Criterion.PROCESSOR_FREQUENCY;
                System.out.print("Введите минимальное значение частоты процессора (в ГГц): ");
                break;
            case 7:
                criterion = Criterion.MODEL;
                System.out.print("Введите название модели ноутбука: ");
                break;
            case 8:
                criterion = Criterion.BRAND;
                System.out.print("Введите название бренда ноутбука: ");
                break;
            default:
                criterion = Criterion.BRAND;
                System.out.println("Неверный критерий");
                return;
        }
        String userStrInput = scanner.nextLine();
        criteria.put(criterion, userStrInput);
    }

    public static void outputCriteria(HashMap<Criterion, String> criteria) {
        System.out.println("Критерии для фильтрации:");
        if (criteria.isEmpty())
            System.out.println("Критерии не заданы");
        for (var item : criteria.entrySet()) {
            String msg;
            switch ((Criterion) (item.getKey())) {
                case MEMORY_CAPACITY:
                    msg = "Минимальный объем памяти (в Гб): ";
                    break;
                case STORAGE_CAPACITY:
                    msg = "Минимальный объем ЖД (в Гб): ";
                    break;
                case OS:
                    msg = "Название и версия операционной системы: ";
                    break;
                case COLOR:
                    msg = "Числовое значение цвета: ";
                    break;
                case PROCESSOR:
                    msg = "Название процессора: ";
                    break;
                case PROCESSOR_FREQUENCY:
                    msg = "Минимальное значение частоты процессора (в ГГц): ";
                    break;
                case MODEL:
                    msg = "Название модели ноутбука: ";
                    break;
                case BRAND:
                    msg = "Название бренда ноутбука: ";
                    break;
                default:
                    msg = "Неверный критерий";
            }
            System.out.println(msg + item.getValue());
        }
    }

    public static void outputNotebooks(HashSet<Notebook> notebooks) {
       System.out.println("Все ноутбуки: ");
       for (Notebook item : notebooks)
           System.out.println(item);
    }

    public static void deleteCriterion(HashMap<Criterion, String> criteria) {
        System.out.println("Выберите критерий для удаления: ");
        if (criteria.isEmpty()) {
            System.out.println("Критерии не заданы");
            return;
        }
        for (var item : criteria.entrySet()) {
            String msg;
            switch ((Criterion) (item.getKey())) {
                case MEMORY_CAPACITY:
                    msg = "1 - Минимальный объем памяти (в Гб): ";
                    break;
                case STORAGE_CAPACITY:
                    msg = "2 - Минимальный объем ЖД (в Гб): ";
                    break;
                case OS:
                    msg = "3 - Название и версия операционной системы: ";
                    break;
                case COLOR:
                    msg = "4 - Числовое значение цвета: ";
                    break;
                case PROCESSOR:
                    msg = "5 - Название процессора: ";
                    break;
                case PROCESSOR_FREQUENCY:
                    msg = "6 - Минимальное значение частоты процессора (в ГГц): ";
                    break;
                case MODEL:
                    msg = "7 - Название модели ноутбука: ";
                    break;
                case BRAND:
                    msg = "8 - Название бренда ноутбука: ";
                    break;
                default:
                    msg = "Неверный критерий";
            }
            System.out.println(msg + item.getValue());
        }
        System.out.print("> ");
        Criterion criterion;
        int userInput = Integer.parseInt(scanner.nextLine());
        switch (userInput) {
            case 1: criterion = Criterion.MEMORY_CAPACITY; break;
            case 2: criterion = Criterion.STORAGE_CAPACITY; break;
            case 3: criterion = Criterion.OS; break;
            case 4: criterion = Criterion.COLOR; break;
            case 5: criterion = Criterion.PROCESSOR; break;
            case 6: criterion = Criterion.PROCESSOR_FREQUENCY; break;
            case 7: criterion = Criterion.MODEL; break;
            case 8: criterion = Criterion.BRAND; break;
            default:
                System.out.println("Неверный критерий");
                return;
        }
        if (criteria.containsKey(criterion))
            criteria.remove(criterion);
        else
            System.out.println("Критерий не найден");
    }

    public static void filterNotebooks(HashSet<Notebook> notebooks, HashMap<Criterion, String> criteria) {
        System.out.println("Ноутбуки, соответствующие фильтрам: ");
        for (var notebook: notebooks) {
            boolean filtered = true;
            int filteredValue;
            double filteredDoubleValue;

            for (var criterion: criteria.entrySet()) {
                switch((Criterion)criterion.getKey()) {
                    case MEMORY_CAPACITY:
                        try {
                            filteredValue = Integer.parseInt(criterion.getValue());
                        } catch (Exception e) {
                            System.out.printf("Неверное значение критерия (Минимальный объем памяти, Гб): %s\n", criterion.getValue());
                            return;
                        }
                        if (notebook.getMemoryCapacity() < filteredValue)
                            filtered = false;
                        break;
                    case STORAGE_CAPACITY:
                        try {
                            filteredValue = Integer.parseInt(criterion.getValue());
                        } catch (Exception e) {
                            System.out.printf("Неверное значение критерия (Минимальный объем ЖД, Гб): %s\n", criterion.getValue());
                            return;
                        }
                        if (notebook.getStorageCapacity() < filteredValue)
                            filtered = false;
                        break;
                    case OS:
                        if (!notebook.getOperationSystem().equalsIgnoreCase(criterion.getValue()))
                            filtered = false;
                        break;
                    case COLOR:
                        try {
                            filteredValue = Integer.parseInt(criterion.getValue());
                        } catch (Exception e) {
                            System.out.printf("Неверное значение критерия (Цвет): %s\n", criterion.getValue());
                            return;
                        }
                        if (notebook.getColor() != filteredValue)
                            filtered = false;
                        break;
                    case PROCESSOR:
                        if (!notebook.getProcessor().equalsIgnoreCase(criterion.getValue()))
                            filtered = false;
                        break;
                    case PROCESSOR_FREQUENCY:
                        try {
                            filteredDoubleValue = Double.parseDouble(criterion.getValue());
                        } catch (Exception e) {
                            System.out.printf("Неверное значение критерия (Частота процессора, ГГц): %s\n", criterion.getValue());
                            return;
                        }
                        if (notebook.getProcessorGhz() < filteredDoubleValue)
                            filtered = false;
                        break;
                    case MODEL:
                        if (!notebook.getModel().equalsIgnoreCase(criterion.getValue()))
                            filtered = false;
                        break;
                    case BRAND:
                        if (!notebook.getBrand().equalsIgnoreCase(criterion.getValue()))
                            filtered = false;
                        break;
                }
                if (!filtered)
                    break;
            }

            if (filtered)
                System.out.println(notebook);
        }
    }
}