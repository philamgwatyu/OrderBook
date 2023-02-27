package com.OrderBook.orderbook.services;


import com.OrderBook.orderbook.entities.Book;
import com.OrderBook.orderbook.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private  BookRepository bookRepository;

    public void AddTobook(Book b){
        bookRepository.save(b);
    }

    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    public Book getBookById(int id)
    {
        return bookRepository.findById(id).get();
    }

    public void DeleteBookById(int id)
    {
        bookRepository.deleteById(id);
    }
}
