package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private Map<Integer,Book> bookDB;
    private int id;
    public BookRepository(){
        bookDB = new HashMap<>();
        id=1;
    }

    public Book save(Book book){
        book.setId(id++);
        bookDB.put(book.getId(),book);
        return book;
    }

    public Book findBookById(int id){

        return bookDB.get(id);
    }

    public List<Book> findAll(){
        return new ArrayList<Book>(bookDB.values());
    }

    public void deleteBookById(int id){
        bookDB.remove(id);
    }

    public void deleteAll() {
        bookDB.clear();
    }
    public List<Book> findBooksByAuthor(String author){
        List<Book> ls= new ArrayList<>();
        for(Book book : bookDB.values()){
            if(book.getAuthor().equals(author)) ls.add(book);
        }
        return ls;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> ls= new ArrayList<>();
        for(Book book : bookDB.values()){
            if(book.getAuthor().equals(genre)) ls.add(book);
        }
        return ls;
    }
}
