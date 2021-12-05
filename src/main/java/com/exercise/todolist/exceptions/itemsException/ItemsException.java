package com.exercise.todolist.exceptions.itemsException;

import com.exercise.todolist.DTOs.ErrorDto;
import org.springframework.http.HttpStatus;

public class ItemsException extends Exception{

    private ErrorDto error;
    HttpStatus status;

    public ItemsException(String message, HttpStatus status) {
        this.error = new ErrorDto(message, this.getClass().getSimpleName());
        this.status = status;
    }
}
