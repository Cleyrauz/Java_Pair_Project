package models;

public enum ItemType {

    FAJITAS("Fajitas", 10.50),
    COLA("Coca-cola", 2.50),
    WATER("Water", 1.00),
    FANTA("Fanta", 2.00),
    LEMONADE("Lemonade", 2.10),
    SPARKLING_WATER("Sparkling Water", 1.50),
    BEER("Beer", 3.00),
    GIN("Gin", 5.00),
    VODKA("Vodka", 4.70),
    TEQUILA("Tequila", 4.90),
    MOJITO("Mojito", 4.50),
    WHISKY("Whisky", 7.00),
    RUM("Rum", 3.50),
    PINA_COLADA("Pina Colada", 11.99),
    SANGRIA("Sangria", 9.55),
    REDWINE("Red Wine", 8.00),
    WHITEWINE("White Wine", 8.00),
    ROSEWINE("Rose Wine", 7.00),
    AREPAS("Arepas", 13.00),
    TEQUENOS("Tequeños", 15.45),
    CHILLI("Chilli con Carne", 8.35),
    TACOS("Tacos", 7.25),
    ENCHILADAS("Enchiladas", 5.49),
    PIE("Pie", 3.30),
    STEAK("Steak", 17.99),
    FOIE_GRAS("Foie Gras", 13.40),
    SALMON("Salmon", 14.50),
    MACKEREL("Mackerel", 5.67),
    PATE("Pate", 6.50),
    ICECREAM("Ice Cream", 4.50),
    TIRAMISU("Tiramisu", 6.99),
    STICKYTOFFEE("Sticky Toffee Pudding", 5.99),
    VENISON("Venison Steak", 21.67),
    CHOCOLATE_FUDGE("Chocolate Fudge Cake", 5.78),
    SORBET("Lemon Sorbet", 3.50),
    BURGER("Cheeseburger", 6.50),
    BANOFFEE_PIE("Banoffee Pie", 4.60),
    CHEESECAKE("White Chocolate Cheesecake", 5.67),
    KEBAB("Lamb Kebab", 7.89);


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
