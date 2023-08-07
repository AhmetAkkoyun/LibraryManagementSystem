package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.entity.Users;
import com.ahmetakkoyun.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UsersRepository implements ICrud<Users> {

    Session session;
    Transaction transaction;

    @Override
    public Users save(Users users) {

        try {
            session = HibernateUtility.getSESSION_FACTORY().openSession();
            System.out.println("Oturum açıldı...");
            transaction = session.beginTransaction();
            session.save(users);
            transaction.commit();
            System.out.println("Kayıt başarılı...");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            System.out.println("KAYIT BASARISIZ!!!!");
        } finally{
            session.close();
            System.out.println("Oturum kapandı...");
        }
        return users;
    }



    @Override
    public Users update(Users users) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Optional<Users> findById(Long id) {
        return Optional.empty();
    }
}
