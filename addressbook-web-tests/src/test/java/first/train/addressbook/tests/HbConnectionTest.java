package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.GroupData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class HbConnectionTest {


    private SessionFactory sessionFactory;


    @BeforeClass
    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }



    @Test
    public void testHbConnection() {

//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        java.util.List<GroupData> result = (java.util.List<GroupData>) session.createQuery( "from GroupData" ).list();
//        for ( GroupData group : result) {
//            System.out.println(group);
//        }
//        session.getTransaction().commit();
//        session.close();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        java.util.List<ContactData> result;
        result = (java.util.List<ContactData>) session.createQuery( "from ContactData" ).list();
        for ( ContactData contact : result) {
            System.out.println(contact);
        }
        session.getTransaction().commit();
        session.close();

    }

}
