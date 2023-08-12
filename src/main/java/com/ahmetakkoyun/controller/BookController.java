package com.ahmetakkoyun.controller;

import com.ahmetakkoyun.repository.entity.Borrow;
import com.ahmetakkoyun.repository.entity.Users;
import com.ahmetakkoyun.repository.enums.EBookType;
import com.ahmetakkoyun.repository.enums.EStatus;
import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Book;
import com.ahmetakkoyun.service.BookService;

import java.util.List;
import java.util.Optional;

public class BookController implements ICrud<Book> {

    private BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }

    @Override
    public Book save(Book book) {
        return bookService.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookService.update(book);
    }

    @Override
    public void deleteById(Long id) {
        bookService.deleteById(id);

    }

    @Override
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookService.findById(id);
    }

    public List<Book> getBooksByType(EBookType eBookType){
        return bookService.getBooksByType(eBookType);
    }

    public Optional<Book>findByTitle(String title){
        return bookService.findByTitle(title);
    }

    public List<Book>findByTitle2(String title){
        return bookService.findByTitle2(title);
    }

    public List<Book> findByTitleWithCriteria(String title){
        return bookService.findByTitleWithCriteria(title);
    }

    public List<Object[]> findByTitleWithCriteria2(String title){
        return bookService.findByTitleWithCriteria2(title);
    }

    public List<Object[]> getBookCountByType(){
        return bookService.getBookCountByType();
    }

    public List<Object[]> getBookCountByTypeWithCriteria(){
        return bookService.getBookCountByTypeWithCriteria();
    }

    public List<Object[]> getBookCountByTypeWithNamedQuery(){
        return bookService.getBookCountByTypeWithNamedQuery();
    }

    public List<Book> getBooksByStatus(EStatus eStatus){
        return bookService.getBooksByStatus(eStatus);
    }

}
