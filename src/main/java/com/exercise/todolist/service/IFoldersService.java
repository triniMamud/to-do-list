package com.exercise.todolist.service;

import com.exercise.todolist.DTOs.FolderDtoResponse;
import com.exercise.todolist.DTOs.ItemDtoResponse;
import com.exercise.todolist.exceptions.folderException.FolderAlreadyExistsException;
import com.exercise.todolist.exceptions.folderException.FolderNotFoundException;

import java.util.List;

public interface IFoldersService {

    List<FolderDtoResponse> getFolders();
    List<ItemDtoResponse> getItems(String folderName);
    Void createFolder(String fodlerName) throws FolderAlreadyExistsException;
    Void deleteFolder (String folderName) throws FolderNotFoundException;

}
