package com.exercise.todolist.controller;

import com.exercise.todolist.DTOs.FolderDtoResponse;
import com.exercise.todolist.DTOs.ItemDtoRequest;
import com.exercise.todolist.DTOs.ItemDtoResponse;
import com.exercise.todolist.exceptions.folderException.FolderAlreadyExistsException;
import com.exercise.todolist.exceptions.folderException.FolderNotFoundException;
import com.exercise.todolist.exceptions.itemsException.ItemAlreadyExistsOnToDoListException;
import com.exercise.todolist.service.IFoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/folder")
public class FoldersController {

    @Autowired
    IFoldersService foldersService;

    @GetMapping("/list")
    public ResponseEntity<List<FolderDtoResponse>> getFolders() {
        return new ResponseEntity<>(foldersService.getFolders(), HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemDtoResponse>> getItemsInFolders(@RequestParam("foldername") @Valid String folderName) {
        return new ResponseEntity<>(foldersService.getItems(folderName), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Void> createFolder(@RequestBody @Valid String folderName) throws FolderAlreadyExistsException {
        return new ResponseEntity<>(foldersService.createFolder(folderName), HttpStatus.OK);
    }

    /*@PutMapping("/update")
    public ResponseEntity<ItemDtoResponse> updateItem(@RequestBody @Valid ItemDtoRequest itemRequest) {
        return new ResponseEntity<>(foldersService.updateItem(itemRequest), HttpStatus.OK);
    }*/

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteFolder(@RequestBody @Valid String folderName) throws FolderNotFoundException {
        return new ResponseEntity<>(foldersService.deleteFolder(folderName), HttpStatus.OK);
    }
}
