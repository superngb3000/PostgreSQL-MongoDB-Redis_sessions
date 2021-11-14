package com.example.pr4.controllers;

import com.example.pr4.services.ItemService;
import com.example.pr4.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @GetMapping
    public String getAllItems(Model model){
        model.addAttribute("items", itemService.findAll());
        return "shop";
    }
}
