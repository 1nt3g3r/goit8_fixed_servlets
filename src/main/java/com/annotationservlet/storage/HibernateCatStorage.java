package com.annotationservlet.storage;

import com.annotationservlet.entity.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.UUID;

public class HibernateCatStorage implements ICatStorage {
    private SessionFactory sessionFactory;

    public HibernateCatStorage() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Cat add(Cat cat) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cat);
        transaction.commit();
        session.close();
        return cat;
    }

    public void delete(Cat cat) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cat);
        transaction.commit();
        session.close();
    }

    public Cat get(UUID catId) {
        Cat cat = null;
        Session session = sessionFactory.openSession();
        cat = (Cat) session.get(Cat.class, catId);
        session.close();
        return cat;
    }

    public List<Cat> listAllCats() {
        Session session = sessionFactory.openSession();
        List<Cat> cats = session.createQuery("from Cat").list();
        session.close();
        return cats;
    }

    public Cat update(Cat cat) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(cat);
        transaction.commit();
        session.close();
        return cat;
    }

    public static void main(String[] args) {
        String uuidStr = "d95e7b1c-f3f7-4830-9dc0-fcf1b3a59bc9";
        HibernateCatStorage catStorage = new HibernateCatStorage();

        Cat cat = catStorage.get(UUID.fromString(uuidStr));
        System.out.println(cat);
//
//        Cat cat = new Cat();
//        cat.setName("Max");
//        cat.setSex(true);
//
//        catStorage.add(cat);
//
//        UUID uuid = cat.getId();
//
//        System.out.println(uuid.toString());
//
//        List<Cat> cats = catStorage.listAllCats();
//
//        System.out.println("Cat count: " + cats.size());
//        for(Cat cat: cats) {
//            System.out.println(cat);
//        }

    }
}
