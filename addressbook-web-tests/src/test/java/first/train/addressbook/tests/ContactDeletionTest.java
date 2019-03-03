package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goToContact().HomePage();

        if(app.contact().all().size() == 0){
            app.goToContact().gotoContactPageEdit();
            app.contact().createContact(new ContactData().withFirstname("Olga").withLastname("Zhivotovskaia").withAddress("St.-P.").withMobile("+79218812075").withEmail("happidai@gmail.com"));
        }
    }


    @Test
    public void testContactDeletion() throws Exception {

        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.delay(10);
        app.goToContact().HomePage();
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
         assertThat(after, equalTo(before.without(deletedContact)));


    }



}
