package first.train.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.Contacts;
import first.train.addressbook.model.Groups;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ContactCreationTest extends TestBase {


    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {

            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactData.class);
            List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }

    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {

            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
            }.getType());
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

        }

    }


    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactData contact) throws Exception {
        Groups groups = app.db().groups();
        Contacts before = app.db().contacts();
        app.goToContact().gotoContactPageEdit();
        app.contact().createContact(contact.inGroup(groups.iterator().next()));
        app.delay(15);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();
        verifyContactListInUi();

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

    @Test(enabled = false)
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
