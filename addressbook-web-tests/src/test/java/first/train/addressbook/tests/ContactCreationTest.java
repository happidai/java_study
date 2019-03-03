package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.Contacts;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() throws Exception {

        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Olga").withLastname("Zhivotovskaia");
        app.goToContact().gotoContactPageEdit();
        app.contact().createContact(contact);
        app.delay(15);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

    @Test
    public void testBadContactCreation() throws Exception {

        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Olga'").withLastname("Zhivotovskaia");
        app.goToContact().gotoContactPageEdit();
        app.contact().createContact(contact);
        app.delay(15);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();


        assertThat(after, equalTo(before));

    }




//        int max = 0;
//        for (ContactData c : after) {
//            if (c.getId() > max) {
//                max = c.getId();
//            }
//        }
        //Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());

      // contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
//       before.add(contact);
////        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
////        before.sort(byId);
////        after.sort(byId);
//        Assert.assertEquals(before, after);
//            }


}
