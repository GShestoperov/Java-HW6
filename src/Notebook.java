import java.util.Objects;

public class Notebook {
    private String model;
    private String brand;
    private int color;
    private String processor;
    private double processorGhz;
    private int memoryCapacity; // в Гигабайтах
    private int storageCapacity; // в Гигабайтах
    private String operationSystem;

    public Notebook(String model, String brand, int color, String processor, double processorGhz, int memoryCapacity, int storageCapacity, String operationSystem) {
        if (model == null || model.isEmpty())
            this.model  = "<Model>";
        else
            this.model = model;
        if (brand == null || brand.isEmpty())
            this.brand  = "<Brand>";
        else
            this.brand = brand;
        this.color = color;
        if (processor == null || processor.isEmpty())
            this.processor  = "<Processor>";
        else
            this.processor = processor;
        if (processorGhz >= 0.001)
            this.processorGhz = processorGhz;
        else
            this.processorGhz = 0.001;
        if (memoryCapacity >= 1)
            this.memoryCapacity = memoryCapacity;
        else
            this.memoryCapacity = 1;
        if (storageCapacity >= 8)
            this.storageCapacity = storageCapacity;
        else
            this.storageCapacity = 8;
        if (operationSystem == null || operationSystem.isEmpty())
            this.operationSystem  = "<OS>";
        else
            this.operationSystem = operationSystem;
    }

    @Override
    public String toString() {
        return "Notebook(" +
                model + '/' +
                brand + '/' +
                color + '/' +
                processor + '/' +
                processorGhz +'/' +
                memoryCapacity +'/' +
                storageCapacity +'/' +
                operationSystem +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return color == notebook.color && Objects.equals(model, notebook.model) && Objects.equals(brand, notebook.brand) && Objects.equals(operationSystem, notebook.operationSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, brand, color, operationSystem);
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getColor() {
        return color;
    }

    public String getProcessor() {
        return processor;
    }

    public double getProcessorGhz() {
        return processorGhz;
    }

    public int getMemoryCapacity() {
        return memoryCapacity;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public String getOperationSystem() {
        return operationSystem;
    }
}

