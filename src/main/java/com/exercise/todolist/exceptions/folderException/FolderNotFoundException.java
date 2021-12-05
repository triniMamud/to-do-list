package com.exercise.todolist.exceptions.folderException;

import org.springframework.http.HttpStatus;

public class FolderNotFoundException extends FolderException {
    public FolderNotFoundException(String value) {
        super("La carpeta: " +value+ " no existe", HttpStatus.NOT_FOUND);
    }
}
