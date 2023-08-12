package com.ahmetakkoyun.service;

import com.ahmetakkoyun.repository.BookRepository;
import com.ahmetakkoyun.repository.enums.EBookType;
import com.ahmetakkoyun.repository.enums.EStatus;
import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Book;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BookService implements ICrud<Book> {

    private BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.update(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getBooksByType(EBookType eBookType) {
        return bookRepository.getBooksByType(eBookType);
    }

    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findByTitle2(String title) {
        return bookRepository.findByTitle2(title);
    }

    public List<Book> findByTitleWithCriteria(String title){
        return bookRepository.findByTitleWithCriteria(title);
    }

    public List<Object[]> findByTitleWithCriteria2(String title){
        return bookRepository.findByTitleWithCriteria2(title);
    }

    public List<Object[]> getBookCountByType(){
        return bookRepository.getBookCountByType();
    }

    public List<Object[]> getBookCountByTypeWithCriteria(){
        return bookRepository.getBookCountByTypeWithCriteria();
    }

    public List<Object[]> getBookCountByTypeWithNamedQuery(){
        return bookRepository.getBookCountByTypeWithNamedQuery();
    }

    public List<Book> getBooksByStatus(EStatus eStatus){
        return bookRepository.getBooksByStatus(eStatus);
    }
}