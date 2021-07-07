/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.repository;

import java.util.List;
import muhasebe.entities.Musteri;
import muhasebe.entities.Urun;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author kaan
 */
public class Database {

    private SessionFactory factory;

    private static Database INSTANCE;

    private Database() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    public void insertCustomer(Musteri musteri) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.persist(musteri.getTur());
        session.persist(musteri);

        session.getTransaction().commit();
        session.close();
    }

    public List<Musteri> getCustomers() {
        Session session = factory.getCurrentSession();
        List<Musteri> musteriler;
        session.beginTransaction();

        musteriler = session.createQuery("from Musteri").list();

        session.getTransaction().commit();
        session.close();
        return musteriler;
    }

    public void insertProduct(Urun urun) {
         Session session = factory.getCurrentSession();

        session.beginTransaction();
//        session.persist(urun.getMusteri());
        session.persist(urun);

        session.getTransaction().commit();
        session.close();
    }
    
     public List<Urun> getProducts() {
        Session session = factory.getCurrentSession();
        List<Urun> urunler;
        session.beginTransaction();

        urunler = session.createQuery("from Urun").list();

        session.getTransaction().commit();
        session.close();
        return urunler;
    }
}
