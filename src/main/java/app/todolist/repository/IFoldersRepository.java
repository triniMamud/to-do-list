package app.todolist.repository;

import app.todolist.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IFoldersRepository extends JpaRepository<Folder, Integer> {

    Folder findByName(String folderName);
    boolean existsByName(String folderName);
    @Query("FROM Folders WHERE name = :name:")
    Folder getByFolderName(String name);
}
