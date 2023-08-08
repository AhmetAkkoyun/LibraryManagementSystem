package com.ahmetakkoyun.service;

import com.ahmetakkoyun.repository.BookRepository;
import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Book;

import java.util.List;
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
}