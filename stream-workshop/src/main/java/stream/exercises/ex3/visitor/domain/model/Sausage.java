package stream.exercises.ex3.visitor.domain.model;

import stream.exercises.ex3.visitor.domain.service.Visitable;
import stream.exercises.ex3.visitor.domain.service.Visitor;

public class Sausage implements ByPiece, Discountable, PaybackProduct, Visitable {
    private double price;
    private double amount;
    private double discount;
    private double paybackPoint;

    public Sausage(double price, double amount, double discount, double paybackPoint) {
        this.price = price;
        this.amount = amount;
        this.discount = discount;
        this.paybackPoint = paybackPoint;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getAmount() {
        return amount;
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
        return paybackPoint;
    }
}
