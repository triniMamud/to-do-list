package com.exercise.todolist.exceptions.folderException;

import com.exercise.todolist.DTOs.ErrorDto;
import org.springframework.http.HttpStatus;

public class FolderException extends Exception {
    private ErrorDto error;
    HttpStatus status;

    public FolderException(String message, HttpStatus status) {
        this.error = new ErrorDto(message, this.getClass().getSimpleName());
        this.status = status;
    }
}
