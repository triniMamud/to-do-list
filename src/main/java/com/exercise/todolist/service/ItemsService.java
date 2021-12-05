package com.exercise.todolist.service;

import com.exercise.todolist.DTOs.ItemDtoRequest;
import com.exercise.todolist.DTOs.ItemDtoResponse;
import com.exercise.todolist.exceptions.ItemAlreadyExistsOnToDoListException;
import com.exercise.todolist.model.ItemList;
import com.exercise.todolist.repository.IItemsRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ItemsService implements IItemsService{

    @Autowired
    IItemsRepository itemsRepository;

    @Override
    public List<ItemDtoResponse> getItemList() {
        List<ItemDtoResponse> listItems = new ArrayList<>();
        itemsRepository.findAll()
                .stream()
                .map(itemList -> listItems.add(new ItemDtoResponse(itemList.getValue())))
                .collect(Collectors.toList());
        return listItems;
    }

    @Override
    public Void createItem(ItemDtoRequest itemRequest) throws ItemAlreadyExistsOnToDoListException {
        if (itemsRepository.existsByItemValue(itemRequest.getValue()))
            throw new ItemAlreadyExistsOnToDoListException(itemRequest.getValue());

        ItemList item = new ItemList();
        item.setValue(itemRequest.getValue());
        itemsRepository.save(item);
        return null;
    }

    @Override
    public ItemDtoResponse updateItem(ItemDtoRequest itemRequest) {
        ItemList item = itemsRepository.getItemByValue(itemRequest.getValue());
        item.setValue(itemRequest.getValue());
        itemsRepository.save(item);
        return null;
    }

    @Override
    public Void deleteItem(ItemDtoRequest itemRequest) {
        ItemList itemDeleted = itemsRepository.getItemByValue(itemRequest.getValue());
       itemsRepository.deleteById(itemDeleted.getItemId());
        return null;
    }
}
