package com.exercise.todolist.repository;

import com.exercise.todolist.model.Folder;
import com.exercise.todolist.model.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IFoldersRepository extends JpaRepository<Folder, Integer> {

    Folder findByName(String folderName);
    boolean existsByName(String folderName);
    @Query("FROM Folders WHERE name = :name:")
    Folder getByFolderName(String name);
}
