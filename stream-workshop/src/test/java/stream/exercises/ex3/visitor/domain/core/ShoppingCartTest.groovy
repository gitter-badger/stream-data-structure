package stream.exercises.ex3.visitor.domain.core

import spock.lang.Specification
import stream.exercises.ex3.visitor.domain.model.Beef
import stream.exercises.ex3.visitor.domain.model.Frankfurter
import stream.exercises.ex3.visitor.domain.model.Pork
import stream.exercises.ex3.visitor.domain.model.Sausage
import stream.exercises.ex3.visitor.domain.service.Visitable

class ShoppingCartTest extends Specification {
    def "should return total amount without discount"() {
        given:
            List<Visitable> products = [
                new Beef(25d, 1d, 10d, 10d),
                new Pork(13d, 1d),
                new Sausage(10d, 4d, 20d, 1d),
                new Frankfurter(45d, 10d, 2d)
            ]
            ShoppingCart cart = new ShoppingCart(products, false)
        expect:
            cart.getTotalCosts() ==  517.5
            cart.getPaybackPoints() == 13d
    }

    def "should return total amount with discount"() {
        given:
            List<Visitable> products = [
                new Beef(25d, 1d, 10d, 10d),
                new Pork(13d, 1d),
                new Sausage(10d, 4d, 20d, 1d),
                new Frankfurter(45d, 10d, 2d)
            ]
            ShoppingCart cart = new ShoppingCart(products, true)
        expect:
            cart.getTotalCosts() ==  491.625
            cart.getPaybackPoints() == 13d
    }
}
