package stream.exercises.ex3.visitor.domain.model;

import stream.exercises.ex3.visitor.domain.service.Visitable;
import stream.exercises.ex3.visitor.domain.service.Visitor;

public class Beef implements ByWeight, Discountable, PaybackProduct, Visitable {
    private double price;
    private double weight;
    private double discount;
    private double paybackPoints;

    public Beef(double price, double weight, double discount, double paybackPoints) {
        this.price = price;
        this.weight = weight;
        this.discount = discount;
        this.paybackPoints = paybackPoints;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public double paybackPoints() {
        return paybackPoints;
    }
}
