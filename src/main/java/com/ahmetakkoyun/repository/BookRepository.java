package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.enums.EBookType;
import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Book;
import com.ahmetakkoyun.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class BookRepository implements ICrud<Book> {

    Session session;
    Transaction transaction;

    @Override
    public Book save(Book book) {
        try {
            session = HibernateUtility.getSESSION_FACTORY().openSession();
            System.out.println("Oturum açıldı...");
            transaction = session.beginTransaction();
            session.save(book);
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
        return book;
    }

    @Override
    public Book update(Book book) {
        try {
            session = HibernateUtility.getSESSION_FACTORY().openSession();
            System.out.println("Oturum açıldı...");
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
            System.out.println("Güncelleme başarılı...");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            System.out.println("GÜNCELLEME BASARISIZ!!!!");
        } finally{
            System.out.println("Oturum kapandı...");
            session.close();
        }
        return book;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    public List<Book> getBooksByType(EBookType eBookType){
        String hql = "SELECT b FROM Book AS b WHERE b.bookType=:x";
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
        typedQuery.setParameter("x",eBookType);
        return typedQuery.getResultList();
    }

    public List<Book> getBooksByTypeWithCriteria(EBookType eBookType){
        EntityManager entityManager = HibernateUtility.getSESSION_FACTORY().createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("bookType"), eBookType));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<Book> getBooksByTypeNamedQuery(EBookType eBookType){
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery = session.createNamedQuery("findByBookType", Book.class);
        typedQuery.setParameter("x",eBookType);
        return typedQuery.getResultList();
    }

}
