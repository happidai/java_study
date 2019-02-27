package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() throws Exception {

        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Olga", "Zh", null, null, null, null);
        app.getContactNavigationHelper().gotoContactPageEdit();
        app.getContactHelper().createContact(contact);
        app.delay(15);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);


//        int max = 0;
//        for (ContactData c : after) {
//            if (c.getId() > max) {
//                max = c.getId();
//            }
//        }
        //Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());

      // contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
       before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
            }


}
