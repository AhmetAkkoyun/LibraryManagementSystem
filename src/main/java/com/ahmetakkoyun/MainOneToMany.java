package com.ahmetakkoyun;

import com.ahmetakkoyun.controller.AuthorController;
import com.ahmetakkoyun.controller.BookController;
import com.ahmetakkoyun.repository.entity.Author;
import com.ahmetakkoyun.repository.entity.Book;
import com.ahmetakkoyun.repository.enums.EBookType;
import com.ahmetakkoyun.utility.HibernateUtility;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
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

        Session session = HibernateUtility.getSESSION_FACTORY().openSession();
        String hql = "SELECT a FROM Author AS a WHERE a.id=1";
        TypedQuery<Author> typedQuery = session.createQuery(hql, Author.class);
        Author newAuthor = typedQuery.getSingleResult();
//        session.close();    // season.close burda olsaydı lazy olan değerleri okuyamayacaktı.
        System.out.println(newAuthor.getFirstName());
        System.out.println(newAuthor.getBooks());
        session.close();



    }
}
