package com.example.BookStore.BookStore.Service;

import com.example.BookStore.BookStore.Common.APIResponse;
import com.example.BookStore.BookStore.Common.BadRequestException;
import com.example.BookStore.BookStore.Common.Error;
import com.example.BookStore.BookStore.Data.BookData;
import com.example.BookStore.BookStore.Entity.Book;
import com.example.BookStore.BookStore.Repo.BookRepository;
import com.example.BookStore.BookStore.Validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    //Dependency Injection
    @Autowired
    private BookRepository bookrepository;

    @Autowired
    private BookValidator bookValidator;

    public List<Book> getBooks(){
        List<Book> bookList = new ArrayList<>();
        bookrepository.findAll().forEach(book -> bookList.add(book));
        return bookList;
    }

    public Book createBook(Book book){

        List<Error> errors = bookValidator.validateRequest(book);

        if(errors.size() > 0){
            throw new BadRequestException("bad request", errors);
        }

        return bookrepository.save(book);
    }

    public Optional<Book> getBookById(Integer bookId){
        return bookrepository.findById(Long.valueOf(bookId));
    }

    public Book updateBook(Book book){
        return bookrepository.save(book);
    }


    public String deleteById(Integer bookId) {
        bookrepository.deleteById(Long.valueOf(bookId));
        return "Book Deleted Successfully";
    }

    public APIResponse getBooksAPI() {
        APIResponse apiResponse = new APIResponse();
        List<Book> bookList = new ArrayList<>();
        bookrepository.findAll().forEach(book -> bookList.add(book));

        BookData bookData = new BookData();
        bookData.setBooks(bookList);

        apiResponse.setData(bookData);
        apiResponse.setStatus(200) ;
        return apiResponse;
    }
}
