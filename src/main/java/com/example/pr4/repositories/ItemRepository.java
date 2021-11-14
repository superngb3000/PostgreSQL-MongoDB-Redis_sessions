package com.example.pr4.repositories;

import com.example.pr4.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    public Item findItemByName(String name);
}
