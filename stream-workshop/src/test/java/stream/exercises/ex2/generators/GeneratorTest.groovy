package stream.exercises.ex2.generators

import spock.lang.Ignore

import java.util.stream.Collectors

class GeneratorTest extends spock.lang.Specification {

    Generator generator = new Generator()
    String elem = "elem"


    def 'test firsNEvents'() {
        expect:
            generator.firsNEvents(2, Arrays.asList(elem, elem, elem, elem, elem).stream()) == Arrays.asList(elem, elem)
    }

    def 'test nRepeat'() {
        expect:
            generator.nRepeat(elem).limit(5).collect(Collectors.toList()) == Arrays.asList(elem, elem, elem, elem, elem)
    }

    def 'test stream of natural numbers'() {
        expect:
            generator.nNumbers().limit(5).collect(Collectors.toList()) == Arrays.asList(0, 1, 2, 3, 4)
    }

    def 'test stream of fibonacci numbers'() {
        expect:
            generator.fibNumbers().limit(8).collect(Collectors.toList()) == Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13)
    }

    def 'test interleaved stream'() {
        expect:
            generator.nInterleave(generator.nRepeat('aEvent'), generator.nRepeat('bEvent')).limit(6).collect(Collectors.toList()) == Arrays.asList('aEvent', 'bEvent', 'aEvent', 'bEvent', 'aEvent', 'bEvent')
    }

    @Ignore
    def 'test stream of odd numbers'() {
    }
}
