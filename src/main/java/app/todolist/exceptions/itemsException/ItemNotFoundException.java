package app.todolist.exceptions.itemsException;

import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends ItemsException {
    public ItemNotFoundException(String value) {
        super("La tarea: " +value+ " no existe en la lista de To-Do", HttpStatus.NOT_FOUND);
    }
}
