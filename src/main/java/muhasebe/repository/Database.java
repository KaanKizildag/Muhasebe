/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.repository;

import java.util.List;
import muhasebe.entities.Musteri;
import muhasebe.entities.Urun;
import muhasebe.entities.UrunIsmi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author kaan
 */
public class Database {

    private final SessionFactory factory;

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
        try ( Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            session.persist(musteri.getTur());
            session.persist(musteri);

            session.getTransaction().commit();
        }
    }

    public List<Musteri> getCustomers() {
        List<Musteri> musteriler;
        try ( Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            musteriler = session.createQuery("from Musteri").list();

            session.getTransaction().commit();
        }
        return musteriler;
    }

    public void insertProduct(Urun urun) {
        try ( Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            session.persist(urun);

            session.getTransaction().commit();
        }
    }

    public List<Urun> getProducts() {
        List<Urun> urunler;
        try ( Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            urunler = session.createQuery("from Urun").list();

            session.getTransaction().commit();
        }
        return urunler;
    }

    public Musteri getById(int id) {
        Musteri musteri;
        try ( Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            musteri = session.byId(Musteri.class).getReference(id);

            session.getTransaction().commit();
        }
        return musteri;
    }

    public void insertProductName(UrunIsmi urunIsmi) {
        try ( Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            session.persist(urunIsmi);

            session.getTransaction().commit();
        }
    }

    public List<UrunIsmi> getAllProductNames() {
        List<UrunIsmi> productNames;
        try ( Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            productNames = session.createQuery("from UrunIsmi").list();

            session.getTransaction().commit();
        }
        return productNames;
    }

}
