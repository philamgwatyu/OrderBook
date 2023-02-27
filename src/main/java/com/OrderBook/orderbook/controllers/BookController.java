package com.OrderBook.orderbook.controllers;

import com.OrderBook.orderbook.entities.Book;
import com.OrderBook.orderbook.entities.BookList;
import com.OrderBook.orderbook.services.BookService;
import com.OrderBook.orderbook.services.MyBooklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bService;

    @Autowired
    private MyBooklistService listbService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister()
    {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook(){
        List<Book>list = bService.getAllBooks();
        ModelAndView m = new ModelAndView();
        m.setViewName("booklist");
        m.addObject("book",list);
        return m;
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book )
    {
        bService.AddTobook(book);
        return "redirect:/available_books";
    }

    @GetMapping("my_books")
    public String getMyBooks(Model model)
    {
        List<BookList>list= listbService.getBookList();
        model.addAttribute("book",list);
        return "mybooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getBooklist(@PathVariable("id") int id)
    {
        Book b  = bService.getBookById(id);
        BookList bl = new BookList(b.getId(), b.getName(),b.getAuthor(), b.getPrice());
        listbService.saveBook(bl);
        return "redirect:/my_books";
    }

    @RequestMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") int id,Model model)

    {
        Book b = bService.getBookById(id);
        model.addAttribute("book", b);
        return "bookedit";
    }

    @RequestMapping("/deleteList/{id}")
    public String DeleteBook(@PathVariable("id") int id)
    {
        bService.DeleteBookById(id);
        return "redirect:/available_books";
    }
}
