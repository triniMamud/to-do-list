package app.todolist.service;

import app.todolist.DTOs.ItemDtoRequest;
import app.todolist.DTOs.ItemDtoResponse;
import app.todolist.exceptions.itemsException.ItemAlreadyExistsOnToDoListException;
import app.todolist.exceptions.itemsException.ItemNotFoundException;

import java.util.List;

public interface IItemsService {

    List<ItemDtoResponse> getItemList();
    Void createItem(ItemDtoRequest itemRequest) throws ItemAlreadyExistsOnToDoListException;
    ItemDtoResponse updateItem(ItemDtoRequest itemRequest) throws ItemNotFoundException;
    Void deleteItem (ItemDtoRequest itemRequest) throws ItemNotFoundException;
}
