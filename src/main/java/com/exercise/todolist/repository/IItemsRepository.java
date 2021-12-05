package com.exercise.todolist.repository;

import com.exercise.todolist.model.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemsRepository extends JpaRepository<ItemList, String> {

    boolean existsByItemValue (String value);
}
