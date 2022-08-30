package ru.connor;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.connor.model.Item;
import ru.connor.model.Person;

/**
 * Hello world!
 * @author John Connor
 */

public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try{

            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Item item = session.get(Item.class, 2);
            System.out.println("Get item");

            // Lazy
            System.out.println(item.getOwner());

            session.getTransaction().commit();

            // Session closed
        }finally {
            sessionFactory.close();
        }
    }
}

