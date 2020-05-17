package me.github.fwfurtado.lc.exceptions;

public class CourseNotFoundException extends IllegalArgumentException {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
