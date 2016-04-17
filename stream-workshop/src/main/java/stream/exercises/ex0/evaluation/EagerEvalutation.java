package stream.exercises.ex0.evaluation;

public class EagerEvalutation {

    public static void main(String[] args) {

        //lazyEval();
    }

    public static void lazyEval() {
        //boolean isCalled = callMethod("second");
        if (callMethod("first") && callMethod("second")) {
            System.out.println("DONE");
        }
    }

    private static boolean callMethod(String name) {
        System.out.println(name + " was called");
        return false;
    }

}
