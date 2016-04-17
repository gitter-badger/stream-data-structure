package stream.exercises.ex3.visitor.domain.service;

import stream.exercises.ex3.visitor.domain.model.*;

public class MeatSellerVisitor implements Visitor {
    private double totalCost;
    private double paybackPoints;

    @Override
    public void visit(Pork pork) {
        totalCost += pork.getWeight() * pork.getPrice();
    }

    @Override
    public void visit(Beef beef) {
        totalCost += beef.getWeight() * beef.getPrice() * discount(beef);
        paybackPoints += beef.paybackPoints();
    }

    @Override
    public void visit(Sausage sausage) {
        totalCost += sausage.getAmount() * sausage.getPrice() * discount(sausage);
        paybackPoints += sausage.paybackPoints();
    }

    private double discount(Discountable discountable) {
        return (100 - discountable.getDiscount()) / 100;
    }

    @Override
    public void visit(Frankfurter frankfurter) {
        totalCost += frankfurter.getAmount() * frankfurter.getPrice();
        paybackPoints += frankfurter.paybackPoints();
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getPaybackPoints() {
        return paybackPoints;
    }
}

