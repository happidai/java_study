package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class ContactCreationTest extends TestBase{



    @Test
    public void testContactCreation() throws Exception {

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactNavigationHelper().gotoContactPageEdit();
        app.getContactHelper().createContact(new ContactData("Olga", "Zhivotovskaia", null, null, "happidai@gmail.com", "test1"));
        app.delay(15);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }


}
