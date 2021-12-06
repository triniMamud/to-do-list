package app.todolist.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name= "folders")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folder_id")
    private int folderId;

    @Column(name = "folder_name")
    private String folderName;

    @OneToMany(mappedBy = "items")
    private List<ItemList> items;
}
