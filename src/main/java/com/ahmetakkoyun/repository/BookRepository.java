package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.entity.Borrow;
import com.ahmetakkoyun.repository.entity.Users;
import com.ahmetakkoyun.repository.enums.EBookType;
import com.ahmetakkoyun.repository.enums.EStatus;
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
import java.util.Map;
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
        List<Book> list = typedQuery.getResultList();
        session.close();
        return list;
    }

    public List<Book> getBooksByTypeWithCriteria(EBookType eBookType){
        EntityManager entityManager = HibernateUtility.getSESSION_FACTORY().createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("bookType"), eBookType));
        List<Book> list = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return list;
    }

    public List<Book> getBooksByTypeNamedQuery(EBookType eBookType){
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery = session.createNamedQuery("findByBookType", Book.class);
        typedQuery.setParameter("x",eBookType);
        List<Book> list = typedQuery.getResultList();
        session.close();
        return list;
    }

    //kitap ara fonksiyonu title a göre kitap getiren metodu yazalım

    public Optional<Book> findByTitle(String title){
        String hql = "SELECT b FROM Book AS b WHERE LOWER(b.title)=:x";
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
        typedQuery.setParameter("x", title.toLowerCase());
        Book book = null;
        try {
            book = typedQuery.getSingleResult();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("KİTAP BULUNAMADI!!!");
        } finally {
            session.close();
        }
        return Optional.ofNullable(book);
    }

    public List<Book> findByTitle2(String title){
        String hql = "SELECT b FROM Book AS b WHERE LOWER(b.title)=:x";
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
        typedQuery.setParameter("x", title.toLowerCase());
//        typedQuery.setMaxResults(1);   // tek bir sonuç getirmesini istersek
        List<Book> list = typedQuery.getResultList();
        session.close();
        return list;
    }

    public List<Book> findByTitleWithCriteria(String title){
        EntityManager entityManager = HibernateUtility.getSESSION_FACTORY().createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("title"),title));
        List<Book> list = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return list;
    }

    public List<Object[]> findByTitleWithCriteria2(String title){
        EntityManager entityManager = HibernateUtility.getSESSION_FACTORY().createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.multiselect(root.get("title"),root.get("author").get("firstName")).where(criteriaBuilder.equal(root.get("title"),title));
        List<Object[]> list = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return list;
    }

    public List<Object[]> getBookCountByType(){
        String hql = "SELECT b.bookType, COUNT(b) FROM Book AS b GROUP BY b.bookType";
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Object[]> typedQuery = session.createQuery(hql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        session.close();
        return list;
    }

    public List<Object[]> getBookCountByTypeWithCriteria(){
        EntityManager entityManager = HibernateUtility.getSESSION_FACTORY().createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.multiselect(root.get("bookType"),criteriaBuilder.count(root)).groupBy(root.get("bookType"));
        List<Object[]> list = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return list;
    }

    public List<Object[]> getBookCountByTypeWithNamedQuery(){
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Object[]> typedQuery = session.createNamedQuery("countBookType", Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        session.close();
        return list;
    }

    public List<Book> getBooksByStatus(EStatus eStatus){
        String hql = "SELECT b FROM Book AS b WHERE b.status=:x";
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
        typedQuery.setParameter("x", eStatus);
        List<Book> list = typedQuery.getResultList();
        session.close();
        return list;

    }







}
