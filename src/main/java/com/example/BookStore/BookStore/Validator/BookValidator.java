package com.example.BookStore.BookStore.Validator;

import com.example.BookStore.BookStore.Common.Error;
import com.example.BookStore.BookStore.Entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookValidator {

    public List<Error> validateRequest(Book book) {
        List<Error> errors = new ArrayList<>();

        if(book.getName()==null){
            Error error = new Error("name", "bookname should not be null");
            errors.add(error);
        }
        if(book.getYearOfPublication()==null){
            Error error = new Error("yearofpublication", "yearofpublication should not be null");
            errors.add(error);
        }


        return  errors;
    }
}
