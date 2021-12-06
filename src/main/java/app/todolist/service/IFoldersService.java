package app.todolist.service;

import app.todolist.DTOs.ItemDtoResponse;
import app.todolist.exceptions.folderException.FolderAlreadyExistsException;
import app.todolist.exceptions.folderException.FolderNotFoundException;
import app.todolist.DTOs.FolderDtoResponse;

import java.util.List;

public interface IFoldersService {

    List<FolderDtoResponse> getFolders();
    List<ItemDtoResponse> getItems(String folderName);
    Void createFolder(String fodlerName) throws FolderAlreadyExistsException;
    Void deleteFolder (String folderName) throws FolderNotFoundException;

}
