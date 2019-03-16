package first.train.addressbook.appmanager;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.GroupData;
import first.train.addressbook.model.Groups;
import first.train.addressbook.model.Contacts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper(){

        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

    }

    public Groups groups(){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        java.util.List<GroupData> result = (java.util.List<GroupData>) session.createQuery( "from GroupData" ).list();
        session.getTransaction().commit();
        session.close();
        return new Groups(result);

    }


    public Contacts contacts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        java.util.List<ContactData> result;
        result = (java.util.List<ContactData>) session.createQuery( "from ContactData where deprecated = '0000-00-00'" ).list();
        session.getTransaction().commit();
        session.close();
        return new Contacts(result);

    }



}
