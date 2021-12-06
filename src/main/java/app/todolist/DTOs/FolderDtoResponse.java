package app.todolist.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FolderDtoResponse {

    private String name;
    private List<ItemDtoResponse> items;
}
