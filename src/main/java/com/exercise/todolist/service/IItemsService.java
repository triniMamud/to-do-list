package com.exercise.todolist.service;

import com.exercise.todolist.DTOs.ItemDtoRequest;
import com.exercise.todolist.DTOs.ItemDtoResponse;
import com.exercise.todolist.exceptions.ItemAlreadyExistsOnToDoListException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IItemsService {

    List<ItemDtoResponse> getItemList(HttpServletRequest req);
    Void createItem(ItemDtoRequest itemRequest, HttpServletRequest req) throws ItemAlreadyExistsOnToDoListException;
    ItemDtoResponse updateItem(ItemDtoRequest itemRequest, HttpServletRequest req);
    Void deleteItem (ItemDtoRequest itemRequest, HttpServletRequest req);
}
