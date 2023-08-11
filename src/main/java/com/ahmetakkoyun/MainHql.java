package com.ahmetakkoyun;

import com.ahmetakkoyun.controller.AuthorController;
import com.ahmetakkoyun.controller.BookController;
import com.ahmetakkoyun.repository.BookRepository;
import com.ahmetakkoyun.repository.enums.EBookType;

public class MainHql {

    public static void main(String[] args) {

        BookController bookController = new BookController();
        AuthorController authorController = new AuthorController();
        BookRepository bookRepository = new BookRepository();
//        bookController.getBooksByType(EBookType.NOVEL).forEach(x-> System.out.println(x));
//        authorController.getBooksWithAuthorNamesStartWith("A").forEach(x-> System.out.println(x));
        bookRepository.getBooksByTypeNamedQuery(EBookType.NOVEL).forEach(System.out::println);


    }


}
