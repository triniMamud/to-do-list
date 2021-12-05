package com.exercise.todolist.service;

import com.exercise.todolist.DTOs.FolderDtoResponse;
import com.exercise.todolist.DTOs.ItemDtoResponse;
import com.exercise.todolist.exceptions.folderException.FolderAlreadyExistsException;
import com.exercise.todolist.exceptions.folderException.FolderNotFoundException;
import com.exercise.todolist.exceptions.itemsException.ItemAlreadyExistsOnToDoListException;
import com.exercise.todolist.exceptions.itemsException.ItemNotFoundException;
import com.exercise.todolist.model.Folder;
import com.exercise.todolist.model.ItemList;
import com.exercise.todolist.repository.IFoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoldersService implements IFoldersService {

    @Autowired
    IFoldersRepository foldersRepository;
    @Autowired
    ModelMapper mapper;

    @Override
    public List<FolderDtoResponse> getFolders() {
        List<FolderDtoResponse> folders = new ArrayList<>();
        foldersRepository.findAll()
                .stream()
                .map(folder -> folders.add(new FolderDtoResponse(folder.getFolderName(),
                        folder.getItems()
                        .stream()
                        .map(itemList -> mapper.map(itemList, ItemDtoResponse.class))
                        .collect(Collectors.toList())
                )))
                .collect(Collectors.toList());
        return folders;
    }

    @Override
    public List<ItemDtoResponse> getItems(String folderName) {
        return foldersRepository.findByName(folderName).getItems()
                .stream()
                .map(itemList -> mapper.map(itemList, ItemDtoResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Void createFolder(String folderName) throws FolderAlreadyExistsException {
        if (foldersRepository.existsByName(folderName))
            throw new FolderAlreadyExistsException(folderName);

        Folder folder = new Folder();
        folder.setFolderName(folderName);
        folder.setItems(new ArrayList<>());
        foldersRepository.save(folder);
        return null;
    }

    @Override
    public Void deleteFolder(String folderName) throws FolderNotFoundException {
        if (!foldersRepository.existsByName(folderName))
            throw new FolderNotFoundException(folderName);

        Folder folder = foldersRepository.getByFolderName(folderName);
        foldersRepository.deleteById(folder.getFolderId());
        return null;
    }
}
