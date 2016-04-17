package stream.exercises.ex3.visitor.domain.service;

public interface Visitable {
    void accept(Visitor visitor);
}
