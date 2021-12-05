package com.exercise.todolist.repository;

import com.exercise.todolist.model.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemsRepository extends JpaRepository<ItemList, Integer> {

    boolean existsByItemValue (String value);

    @Query("FROM Items WHERE value = :value:")
    ItemList getItemByValue(String value);
}
