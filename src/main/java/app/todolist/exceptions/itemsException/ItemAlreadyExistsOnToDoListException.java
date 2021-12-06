package app.todolist.exceptions.itemsException;

import org.springframework.http.HttpStatus;

public class ItemAlreadyExistsOnToDoListException extends ItemsException {
    public ItemAlreadyExistsOnToDoListException(String value) {
        super("La tarea: " +value+ " ya existe en la lista de To-Do", HttpStatus.BAD_REQUEST);
    }
}
