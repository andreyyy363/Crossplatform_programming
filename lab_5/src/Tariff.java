// Клас Тарифів
public class Tariff {
    private final String name;
    private double price;

    public Tariff(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tariff " + name + " - price: " + price;
    }
}