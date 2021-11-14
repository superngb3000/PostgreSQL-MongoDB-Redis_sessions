package com.example.pr4.services;

import com.example.pr4.models.Item;
import com.example.pr4.repositories.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> findAll(){
        List<Item> items = itemRepository.findAll();
        return items;
    }

    public void addItem(Item item){
        if(itemRepository.findItemByName(item.getName()) != null){
            return;
        }
        itemRepository.save(item);
    }

    public void deleteItem(Long id){
        Optional<Item> itemOptional = itemRepository.findById(id);
        if(itemOptional.isPresent()){
            itemRepository.deleteById(id);
            return;
        }
    }

    public Item findById(Long id){
        Optional<Item> itemOptional = itemRepository.findById(id);
        return itemOptional.get();
    }

    public Item saveItem(Item item){
        itemRepository.save(item);
        return item;
    }

    public Item updateItem(Item item, Long id){
        Optional<Item> tmpOptional = itemRepository.findById(id);
        if (tmpOptional.isPresent()){
            Item tmp = tmpOptional.get();
            tmp.setName(item.getName());
            tmp.setPrice(item.getPrice());
            tmp.setDescription(item.getDescription());
            return tmp;
        }
        return null;
    }
}
