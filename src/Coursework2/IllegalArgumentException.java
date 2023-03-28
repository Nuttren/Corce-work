package Coursework2;

public class IllegalArgumentException extends Exception {
    private String argument;
    public IllegalArgumentException (String argument) {
        super("Illegal value:" + argument);
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }
}
