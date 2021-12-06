package app.todolist.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name= "items" )
public class ItemList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    @Column(name = "folder_id")
    private Folder folderId;
}
