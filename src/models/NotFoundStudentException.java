package models;

public class NotFoundStudentException extends Exception{
    public NotFoundStudentException(String message){
        super(message);
    }
}
