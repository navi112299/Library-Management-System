package com.example.BookStore.BookStore.Controller;

import com.example.BookStore.BookStore.Common.APIResponse;
import com.example.BookStore.BookStore.Entity.Book;
import com.example.BookStore.BookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@Controller + @ResponseBody
public class BookController {

    //Dependency Injection
    @Autowired
    private BookService bookService;

    //GET//http://localhost:8090/book
    @RequestMapping(value="/book", method = RequestMethod.GET)
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    //POST//http://localhost:8090/book(Body{"name":"street",yearOfPublication:"2009",bookType:"fictional"})
    @RequestMapping(value="/book", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    //GET/resourceId//http://localhost:8090/book/1
    @RequestMapping(value="/book/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Integer bookId){
        return bookService.getBookById(bookId);
    }

    //PUT//http://localhost:8090/book(Body{"name":"street",yearOfPublication:"2009",bookType:"fictional"})
    @RequestMapping(value="/book", method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    //DELETE//http://localhost:8090/book/1    @RequestMapping(value="/book/{bookId}", method = RequestMethod.DELETE)
    public String deleteBookById(@PathVariable Integer bookId){
        return bookService.deleteById(bookId);
    }

    //GET//http://localhost:8090/bookapi
    @RequestMapping(value="/bookapi", method = RequestMethod.GET)
    public APIResponse getBooksAPI(){
        return bookService.getBooksAPI();
    }

}
