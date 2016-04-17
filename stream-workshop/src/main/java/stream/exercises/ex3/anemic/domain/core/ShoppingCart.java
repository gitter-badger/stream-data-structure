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
        throw new UnsupportedOperationException("Missing implementation");
    }

    // if client has loyalty card it should get 5% discount of total costs
    private Function<Double, Double> applyDiscount() {
        throw new UnsupportedOperationException("Missing implementation");
    }

    //helper function which can be used also for count total cost
    private BinaryOperator<Double> sum() {
        throw new UnsupportedOperationException("Missing implementation");
    }
}
