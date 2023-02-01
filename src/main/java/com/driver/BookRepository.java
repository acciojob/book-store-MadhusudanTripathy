package com.driver;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private List<Book> bookList;
    private int id;
    public BookRepository(){
        bookList = new ArrayList<>();
        id=1;
    }

    public Book save(Book book){
        book.setId(id);
        bookList.add(book);
        this.id++;
        return book;
    }

    public Book findBookById(int id){
        for(Book book : bookList){
            if(book.getId()==id) return book;
        }
        return null;
    }

    public List<Book> findAll(){
        return bookList;
    }

    public void deleteBookById(int id){
        String message="Book Not Available";
        for(Book book : bookList) {
            if (book.getId() == id) {
                bookList.remove(book);
                message="Book With Id "+id+" Deleted Successfully";
                break;
            }
        }
    }

    public void deleteAll(){
        bookList.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> ls= new ArrayList<>();
        for(Book book : bookList){
            if(book.getAuthor().equals(author)) ls.add(book);
        }
        return ls;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> ls= new ArrayList<>();
        for(Book book : bookList){
            if(book.getAuthor().equals(genre)) ls.add(book);
        }
        return ls;
    }
}
