package models;

public enum ItemType {

    FAJITAS("Fajitas", 10.50),
    COLA("Coca-cola", 2.50);

    private String name;
    private double price;

    ItemType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
