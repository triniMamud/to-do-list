package app.todolist.exceptions.itemsException;

import app.todolist.DTOs.ErrorDto;
import org.springframework.http.HttpStatus;

public class ItemsException extends Exception{

    private ErrorDto error;
    HttpStatus status;

    public ItemsException(String message, HttpStatus status) {
        this.error = new ErrorDto(message, this.getClass().getSimpleName());
        this.status = status;
    }
}
