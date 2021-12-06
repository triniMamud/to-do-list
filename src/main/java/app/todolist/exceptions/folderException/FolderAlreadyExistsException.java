package app.todolist.exceptions.folderException;

import org.springframework.http.HttpStatus;

public class FolderAlreadyExistsException extends FolderException {
    public FolderAlreadyExistsException(String value) {
        super("La carpeta: " +value+ " ya existe", HttpStatus.BAD_REQUEST);
    }
}
