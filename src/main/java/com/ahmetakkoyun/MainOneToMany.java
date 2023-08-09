package com.ahmetakkoyun;

import com.ahmetakkoyun.controller.AuthorController;
import com.ahmetakkoyun.controller.BookController;
import com.ahmetakkoyun.repository.entity.Author;
import com.ahmetakkoyun.repository.entity.Book;
import com.ahmetakkoyun.repository.enums.EBookType;

import java.util.List;

public class MainOneToMany {

    public static void main(String[] args) {

        AuthorController authorController = new AuthorController();
        BookController bookController = new BookController();


        Author author = Author.builder()
                .firstName("Kemal")
                .lastName("Tahir")
                .build();

        Book book1 = Book.builder()
                .title("Hür Şehrin İnsanları")
                .bookType(EBookType.HISTORY)
                .author(author)
                .build();

        Book book2 = Book.builder()
                .title("Esir Şehrin İnsanları")
                .bookType(EBookType.HISTORY)
                .author(author)
                .build();

        Book book3 = Book.builder()
                .title("Yorgun Savaşçı")
                .bookType(EBookType.HISTORY)
                .author(author)
                .build();


//        yazarı kaydederek:
//        author.setBooks(List.of(book1, book2, book3));
//        authorController.save(author);


//        kitapları kaydederek
        bookController.save(book1);
        bookController.save(book2);
        bookController.save(book3);



    }
}
