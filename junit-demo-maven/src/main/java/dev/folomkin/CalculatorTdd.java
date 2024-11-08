package dev.folomkin;

public class CalculatorTdd {

    public enum Command {
        SUM, DIVIDE
    }

    public int calculate(Command command, int arg1, int arg2) {
        int argAbs1 = Math.abs(arg1);
        int argAbs2 = Math.abs(arg2);
        return switch (command) {
            case SUM -> sum(argAbs1, argAbs2);
            case DIVIDE -> div(argAbs1, argAbs2);
            default -> {
                yield 0;
            }
        };
    }

    public int sum(int arg1, int arg2) {
        return arg1 + arg2;
    }

    public int div(int arg1, int arg2) {
        if (arg2 == 0)
            throw new IllegalArgumentException("Division by zero!!!");
        else
            return (arg1 / arg2);
    }
}
