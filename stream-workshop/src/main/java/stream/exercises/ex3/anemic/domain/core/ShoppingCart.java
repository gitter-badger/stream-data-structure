package stream.exercises.ex3.anemic.domain.core;

import stream.exercises.ex3.anemic.domain.model.Product;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class ShoppingCart {
    private List<Product> products;
    private boolean hasLoyaltyCard;

    public ShoppingCart(List<Product> products, boolean hasLoyaltyCard) {
        this.products = products;
        this.hasLoyaltyCard = hasLoyaltyCard;
    }

    public double getTotalCosts() {
        return getOrderCosts().andThen(applyDiscount()).apply(products);
    }

    public double getPaybackPoints() {
        return products.stream().map(Product::getPaybackPoints).reduce(0d, sum());
    }

    private Function<List<Product>, Double> getOrderCosts() {
        return list -> list.stream().map(productCostWithDiscount()).reduce(0d, sum());
    }

    private Function<Product, Double> productCostWithDiscount() {
        return p -> p.getAmount() * p.getPrice() * discount(p);
    }

    private Function<Double, Double> applyDiscount() {
        return cost -> hasLoyaltyCard ? cost * 0.95 : cost;
    }

    private BinaryOperator<Double> sum() {
        return (a, b) -> a + b;
    }

    private double discount(Product p) {
        return (100 - p.getDiscount()) / 100;
    }
}
