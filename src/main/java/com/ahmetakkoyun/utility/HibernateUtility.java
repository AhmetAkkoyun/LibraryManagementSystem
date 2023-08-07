package com.ahmetakkoyun.utility;

import com.ahmetakkoyun.repository.entity.*;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    @Getter
    private static final SessionFactory SESSION_FACTORY = createSessionFactory();
    private static SessionFactory createSessionFactory() {
        System.out.println("SessionFactory oluşturuldu...");
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Users.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(UserInformation.class);
            configuration.addAnnotatedClass(Borrow.class);
            System.out.println("Sınıflar configurationa eklendi...");
            SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            System.out.println("SessionFactory configure edildi...");
            System.out.println("Configuration tamamlandı...");
            return sessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("CONFIGURATION HATASI!!!!");
            return null;
        }
    }


}
