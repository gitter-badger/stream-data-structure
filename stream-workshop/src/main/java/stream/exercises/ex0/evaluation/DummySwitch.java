package stream.exercises.ex0.evaluation;

public class DummySwitch {

    public String value(String input) {
        switch (input) {
            case "Java":
                return "Poor you";
            case "Scala":
                return "Better one";
            case "Haskell":
                return "NERD!";
            default: throw new IllegalStateException("You fool!");
        }
    }
}
