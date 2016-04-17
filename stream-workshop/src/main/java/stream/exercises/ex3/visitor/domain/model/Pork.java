package stream.exercises.ex3.visitor.domain.model;

import stream.exercises.ex3.visitor.domain.service.Visitable;
import stream.exercises.ex3.visitor.domain.service.Visitor;

public class Pork implements ByWeight, Visitable {
    private double price;
    private double weight;

    public Pork(double price, double weight) {
        this.price = price;
        this.weight = weight;
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

}
