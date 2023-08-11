package com.ahmetakkoyun.service;

import com.ahmetakkoyun.repository.AuthorRepository;
import com.ahmetakkoyun.repository.entity.Book;
import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Author;

import java.util.List;
import java.util.Optional;

public class AuthorService implements ICrud<Author> {

    private AuthorRepository authorRepository;

    public AuthorService() {
        this.authorRepository = new AuthorRepository();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.update(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);

    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Book> getBooksWithAuthorNamesStartWith(String character){
        return authorRepository.getBooksWithAuthorNamesStartWith(character);
    }
}