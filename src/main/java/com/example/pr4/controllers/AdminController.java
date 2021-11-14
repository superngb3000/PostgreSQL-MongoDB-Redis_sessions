package com.example.pr4.controllers;

import com.example.pr4.models.Item;
import com.example.pr4.services.ItemService;
import com.example.pr4.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    @GetMapping
    public String getUsersAndItems(Model model){
        model.addAttribute("users", userService.findAll());
        model.addAttribute("items", itemService.findAll());
        return "admin";
    }

    @PostMapping
    public String addAndDel(@RequestParam(defaultValue = "название_товара") String name,
                            @RequestParam(defaultValue = "0.0") Double price,
                            @RequestParam(defaultValue = "описание_товара") String description,
                            @RequestParam(defaultValue = "") Long userId,
                            @RequestParam(defaultValue = "") Long itemId,
                            @RequestParam(defaultValue = "") String action){
        if(action.equals("addItem")){
            itemService.addItem(new Item(name, price, description));
        }
        else if(action.equals("deleteItem")){
            itemService.deleteItem(itemId);
        }
        else if(action.equals("deleteUser")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }
}
