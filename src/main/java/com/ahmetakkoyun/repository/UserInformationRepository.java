package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.UserInformation;
import com.ahmetakkoyun.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserInformationRepository implements ICrud<UserInformation> {

    Session session;
    Transaction transaction;

    @Override
    public UserInformation save(UserInformation userInformation) {

        try {
            session = HibernateUtility.getSESSION_FACTORY().openSession();
            System.out.println("Oturum açıldı...");
            transaction = session.beginTransaction();
            session.save(userInformation);
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
        return userInformation;
    }

    @Override
    public UserInformation update(UserInformation userInformation) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<UserInformation> findAll() {
        return null;
    }

    @Override
    public Optional<UserInformation> findById(Long id) {
        return Optional.empty();
    }
}
