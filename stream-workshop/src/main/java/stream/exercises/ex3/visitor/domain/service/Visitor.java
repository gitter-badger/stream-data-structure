package stream.exercises.ex3.visitor.domain.service;

import stream.exercises.ex3.visitor.domain.model.Beef;
import stream.exercises.ex3.visitor.domain.model.Frankfurter;
import stream.exercises.ex3.visitor.domain.model.Pork;
import stream.exercises.ex3.visitor.domain.model.Sausage;

public interface Visitor {
    void visit(Pork pork);

    void visit(Beef beef);

    void visit(Sausage sausage);

    void visit(Frankfurter frankfurter);
}
