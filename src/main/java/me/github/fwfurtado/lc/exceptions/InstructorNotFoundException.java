package me.github.fwfurtado.lc.exceptions;

public class InstructorNotFoundException extends IllegalArgumentException {
    public InstructorNotFoundException(String message) {
        super(message);
    }
}
