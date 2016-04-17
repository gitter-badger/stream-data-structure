package stream.exercises.ex3.anemic.domain.core

import spock.lang.Specification
import stream.exercises.ex3.anemic.domain.model.Product

class ShoppingCartTest extends Specification {
    def "should return total amount without discount"() {
        given:
            List<Product> products = [
                new Product(25d, 1d, 10d, 10d),
                new Product(13d, 1d, 0d, 0d),
                new Product(10d, 4d, 20d, 1d),
                new Product(45d, 10d, 0d, 2d)
            ]
            ShoppingCart cart = new ShoppingCart(products, false)
        expect:
            cart.getTotalCosts() == 517.5
            cart.getPaybackPoints() == 13d
    }

    def "should return total amount with discount"() {
        given:
            List<Product> products = [
                new Product(25d, 1d, 10d, 10d),
                new Product(13d, 1d, 0d, 0d),
                new Product(10d, 4d, 20d, 1d),
                new Product(45d, 10d, 0d, 2d)
            ]
            ShoppingCart cart = new ShoppingCart(products, true)
        expect:
            cart.getTotalCosts() == 491.625
            cart.getPaybackPoints() == 13d
    }
}

