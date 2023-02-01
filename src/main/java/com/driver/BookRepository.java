package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    HashMap<Integer, Book> dbBook;
    private int id;

    public BookRepository(){
        dbBook = new HashMap<>();
        id = 1;
    }

    public Book save(Book book){
        book.setId(id);

        dbBook.put(id, book);
        id++;
        return book;
    }

    public Book findBookById(int id){
        return dbBook.get(id);
    }

    public List<Book> findAll(){
        List<Book> list = new ArrayList<>();
        for(Book book : dbBook.values())
            list.add(book);
        return list;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> list = new ArrayList<>();
        for(Book book : dbBook.values()){
            if(book.getAuthor().equals(author))
                list.add(book);
        }
        return list;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> list = new ArrayList<>();
        for(Book book : dbBook.values()){
            if(book.getGenre().equals(genre))
                list.add(book);
        }
        return list;
    }
    public void deleteBookById(int id){
        dbBook.remove(id);
    }

    public void deleteAll(){
        dbBook.clear();
    }
}
