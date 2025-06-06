package be.abis.exercise.exception;

public class PersonNotFoundException extends Throwable {
    public PersonNotFoundException(String message) {
        super(message);
    }
}
