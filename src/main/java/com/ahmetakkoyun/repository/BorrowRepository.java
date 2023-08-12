package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.entity.Book;
import com.ahmetakkoyun.repository.entity.Users;
import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Borrow;
import com.ahmetakkoyun.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class BorrowRepository implements ICrud<Borrow> {

    Session session;
    Transaction transaction;

    @Override
    public Borrow save(Borrow borrow) {
        try {
            session = HibernateUtility.getSESSION_FACTORY().openSession();
            System.out.println("Oturum açıldı...");
            transaction = session.beginTransaction();
            session.save(borrow);
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
        return borrow;
    }

    @Override
    public Borrow update(Borrow borrow) {

        try {
            session = HibernateUtility.getSESSION_FACTORY().openSession();
            System.out.println("Oturum açıldı...");
            transaction = session.beginTransaction();
            session.update(borrow);
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
        return borrow;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Borrow> findAll() {
        return null;
    }

    @Override
    public Optional<Borrow> findById(Long id) {
        return Optional.empty();
    }


    public List<Borrow> findByUserId(Long userId) {
        String hql = "SELECT b FROM Borrow As b WHERE b.users.id=:x";
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Borrow> typedQuery = session.createQuery(hql, Borrow.class);
        typedQuery.setParameter("x", userId);
        List<Borrow> list = typedQuery.getResultList();
        session.close();
        return list;
    }

    public List<Users>findBorrowedUsersByBookId(Long bookId){
        String hql = "SELECT b.users FROM Borrow AS b WHERE b.book.id=:x";
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Users> typedQuery = session.createQuery(hql, Users.class);
        typedQuery.setParameter("x", bookId);
        List<Users> list = typedQuery.getResultList();
        session.close();
        if (list.size()==0){
            System.out.println("Bu kitap kiralanmamış...");
        }
        return list;
    }



}
