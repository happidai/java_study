package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.Contacts;
import first.train.addressbook.model.GroupData;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ContactCreationTest extends TestBase {


    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        File photo = new File("src/test/resources/stru.png");
        list.add(new Object[]{new ContactData().withFirstname("firstname 1").withLastname("lastname 1").withAddress("address 1").withEmail("email 1").withMobilePhone("mobile 1").withPhoto(photo)});
        list.add(new Object[]{new ContactData().withFirstname("firstname 2").withLastname("lastname 2").withAddress("address 2").withEmail("email 2").withMobilePhone("mobile 2").withPhoto(photo)});
        list.add(new Object[]{new ContactData().withFirstname("firstname 3").withLastname("lastname 3").withAddress("address 3").withEmail("email 3").withMobilePhone("mobile 3").withPhoto(photo)});
        return list.iterator();
    }


    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) throws Exception {
        Contacts before = app.contact().all();
        app.goToContact().gotoContactPageEdit();
        app.contact().createContact(contact);
        app.delay(15);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();

      //  assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

//    @Test
//    public void testCurrentDir(){
//        File currentDir = new File(".");
//        System.out.println(currentDir.getAbsolutePath());
//        File photo = new File("src/test/resources/stru.png");
//        System.out.println(photo.getAbsolutePath());
//        System.out.println(photo.exists());
//    }

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
