package com.example.BookStore.BookStore.Repo;

import com.example.BookStore.BookStore.Entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {


}
