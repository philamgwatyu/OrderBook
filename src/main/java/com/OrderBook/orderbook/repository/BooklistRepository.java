package com.OrderBook.orderbook.repository;

import com.OrderBook.orderbook.entities.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooklistRepository extends JpaRepository<BookList, Integer> {
}
