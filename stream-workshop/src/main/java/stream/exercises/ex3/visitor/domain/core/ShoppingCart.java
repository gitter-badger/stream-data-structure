package stream.exercises.ex3.visitor.domain.core;

import stream.exercises.ex3.visitor.domain.service.MeatSellerVisitor;
import stream.exercises.ex3.visitor.domain.service.Visitable;

import java.util.List;

public class ShoppingCart {
    private List<Visitable> products;
    private boolean hasLoyaltyCard;

    public ShoppingCart(List<Visitable> products, boolean hasLoyaltyCard) {
        this.products = products;
        this.hasLoyaltyCard = hasLoyaltyCard;
    }

    public double getTotalCosts() {
        MeatSellerVisitor visitor = visitCart();
        double postage = visitor.getTotalCost();

        if (hasLoyaltyCard) {
            return postage * 0.95;
        } else {
            return postage;
        }
    }

    public double getPaybackPoints() {
        MeatSellerVisitor visitor = visitCart();
        return visitor.getPaybackPoints();
    }

    private MeatSellerVisitor visitCart() {
        MeatSellerVisitor visitor = new MeatSellerVisitor();
        for (Visitable product : products) {
            product.accept(visitor);
        }
        return visitor;
    }
}
