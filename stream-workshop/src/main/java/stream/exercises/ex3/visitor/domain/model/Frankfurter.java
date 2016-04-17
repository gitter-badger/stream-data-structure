package stream.exercises.ex3.visitor.domain.model;

import stream.exercises.ex3.visitor.domain.service.Visitable;
import stream.exercises.ex3.visitor.domain.service.Visitor;

public class Frankfurter implements ByPiece, PaybackProduct, Visitable{
    private double price;
    private double amount;
    private double paybackPoints;

    public Frankfurter(double price, double amount, double paybackPoints) {
        this.price = price;
        this.amount = amount;
        this.paybackPoints = paybackPoints;
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
    public double paybackPoints() {
        return paybackPoints;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
