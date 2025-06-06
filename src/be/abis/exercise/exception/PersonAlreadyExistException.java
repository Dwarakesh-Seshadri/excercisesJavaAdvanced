package be.abis.exercise.exception;

public class PersonAlreadyExistException extends Throwable{
    public PersonAlreadyExistException(String message) {
        super(message);
    }
}
