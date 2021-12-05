package com.exercise.todolist.controller;

import com.exercise.todolist.DTOs.ItemDtoRequest;
import com.exercise.todolist.DTOs.ItemDtoResponse;
import com.exercise.todolist.exceptions.ItemAlreadyExistsOnToDoListException;
import com.exercise.todolist.service.IFoldersService;
import com.exercise.todolist.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ToDoListController {

    @Autowired
    IItemsService itemsService;
    @Autowired
    IFoldersService foldersService;

    @GetMapping("/list")
    public ResponseEntity<List<ItemDtoResponse>> getItemList() {
        return new ResponseEntity<>(itemsService.getItemList(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Void> createItem(@RequestBody @Valid ItemDtoRequest itemRequest) throws ItemAlreadyExistsOnToDoListException {
        return new ResponseEntity<>(itemsService.createItem(itemRequest), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ItemDtoResponse> updateItem(@RequestBody @Valid ItemDtoRequest itemRequest) {
        return new ResponseEntity<>(itemsService.updateItem(itemRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteItem(@RequestBody @Valid ItemDtoRequest itemRequest) {
        return new ResponseEntity<>(itemsService.deleteItem(itemRequest), HttpStatus.OK);
    }

}
