package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Author;
import com.ahmetakkoyun.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
            System.out.println("Kayyıt başarılı...");
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
}
