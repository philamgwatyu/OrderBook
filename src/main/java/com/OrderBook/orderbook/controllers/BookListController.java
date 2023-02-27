package com.OrderBook.orderbook.controllers;

import com.OrderBook.orderbook.services.MyBooklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookListController {

    @Autowired
    private MyBooklistService blService;

    @RequestMapping("/deleteFromList/{id}")
    public  String deleteFromOrder(@PathVariable("id") int id){
        blService.DeleteBookById(id);
        return "redirect:/my_books";
    }
}


