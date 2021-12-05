package com.exercise.todolist.service;

import com.exercise.todolist.DTOs.ItemDtoRequest;
import com.exercise.todolist.DTOs.ItemDtoResponse;
import com.exercise.todolist.exceptions.itemsException.ItemAlreadyExistsOnToDoListException;
import com.exercise.todolist.exceptions.itemsException.ItemNotFoundException;

import java.util.List;

public interface IItemsService {

    List<ItemDtoResponse> getItemList();
    Void createItem(ItemDtoRequest itemRequest) throws ItemAlreadyExistsOnToDoListException;
    ItemDtoResponse updateItem(ItemDtoRequest itemRequest) throws ItemNotFoundException;
    Void deleteItem (ItemDtoRequest itemRequest) throws ItemNotFoundException;
}
