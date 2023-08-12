package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.entity.Book;
import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Author;
import com.ahmetakkoyun.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class AuthorRepository implements ICrud<Author> {

    Session session;
    Transaction transaction;

    @Override
    public Author save(Author author) {
        try {
            session = HibernateUtility.getSESSION_FACTORY().openSession();
            System.out.println("Oturum açıldı...");
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
            System.out.println("Kayıt başarılı...");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            System.out.println("KAYIT BASARISIZ!!!!");
        } finally{
            System.out.println("Oturum kapandı...");
            session.close();
        }
        return author;
    }



    @Override
    public Author update(Author author) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.empty();
    }

    // ismi a ile başlayan yazarların kitaplarını getir

    public List<Book> getBooksWithAuthorNamesStartWith(String character){
        String hql = "SELECT b FROM Book AS b WHERE b.author.firstName LIKE :x";
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
        typedQuery.setParameter("x",character+"%");
        List<Book> list = typedQuery.getResultList();
        session.close();
        return list;
    }

}
