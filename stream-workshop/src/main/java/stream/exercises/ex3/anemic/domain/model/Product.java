package stream.exercises.ex3.anemic.domain.model;

public class Product {
    private double price;
    private double amount;
    private double discount;
    private double paybackPoints;

    public Product(double price, double amount, double discount, double paybackPoints) {
        this.price = price;
        this.amount = amount;
        this.discount = discount;
        this.paybackPoints = paybackPoints;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPaybackPoints() {
        return paybackPoints;
    }
}
