package com.example.pr4.controllers;

import com.example.pr4.models.Item;
import com.example.pr4.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/items")
    public Item createItem(@RequestBody Item item){
        return itemService.saveItem(item);
    }

    @GetMapping("/items")
    public List<Item> getItems(){
        return itemService.findAll();
    }

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable Long id){
        return itemService.findById(id);
    }

    @PutMapping("/items/{id}")
    public Item updateItem(@RequestBody Item item, @PathVariable Long id){
        return itemService.updateItem(item, id);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
    }
}
