package com.ahmetakkoyun;

import com.ahmetakkoyun.controller.AuthorController;
import com.ahmetakkoyun.controller.BookController;
import com.ahmetakkoyun.controller.BorrowController;
import com.ahmetakkoyun.repository.BookRepository;
import com.ahmetakkoyun.repository.entity.Users;
import com.ahmetakkoyun.repository.enums.EBookType;
import net.bytebuddy.matcher.ElementMatchers;

import java.util.Arrays;

public class MainHql {

    public static void main(String[] args) {

        BookController bookController = new BookController();
        AuthorController authorController = new AuthorController();
        BorrowController borrowController = new BorrowController();

//        bookController.getBooksByType(EBookType.NOVEL).forEach(x-> System.out.println(x));
//        authorController.getBooksWithAuthorNamesStartWith("A").forEach(x-> System.out.println(x));
//        bookRepository.getBooksByTypeNamedQuery(EBookType.NOVEL).forEach(System.out::println);
//        System.out.println(bookController.findByTitle("sevme sanatı"));
//        bookController.findByTitle2("yabancı").forEach(x-> System.out.println(x));
//        bookController.findByTitleWithCriteria("Yabancı").forEach(System.out::println);
//        bookController.findByTitleWithCriteria2("Yabancı").forEach(x-> System.out.println(Arrays.toString(x)));
//        borrowController.findByUserId(1L).forEach(x-> System.out.println(x));
//        borrowController.findBorrowedUsersByBookId(2L).forEach(x-> System.out.println(x));

//        bookController.getBookCountByType().forEach(x-> System.out.println(Arrays.toString(x)));
//        bookController.getBookCountByTypeWithCriteria().forEach(x-> System.out.println(Arrays.toString(x)));
//        bookController.getBookCountByTypeWithNamedQuery().forEach(x-> System.out.println(Arrays.toString(x)));

        LibraryManager libraryManager = new LibraryManager();

        libraryManager.startBorrow();








    }



}
