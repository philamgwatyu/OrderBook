package com.OrderBook.orderbook.services;


import com.OrderBook.orderbook.entities.BookList;
import com.OrderBook.orderbook.repository.BookRepository;
import com.OrderBook.orderbook.repository.BooklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBooklistService {
    @Autowired
    private BooklistRepository bRepo;

    public void saveBook(BookList book){
        bRepo.save(book);
    }

    public List<BookList>  getBookList()
    {
        return bRepo.findAll();
    }

    public void DeleteBookById(int id)
    {
        bRepo.deleteById(id);
    }
}
