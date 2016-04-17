package stream.exercises.ex0.evaluation

import spock.lang.Specification

class EagerEvalutationTest extends Specification {
    EagerEvalutation eval = new EagerEvalutation()

    def 'should eager evalutate function' () {
        expect:
            eval.lazyEval()
    }
}
