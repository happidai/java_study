package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import org.testng.annotations.*;


public class ContactCreationTest extends TestBase{



    @Test
    public void testContactCreation() throws Exception {

        app.getContactNavigationHelper().gotoContactPageEdit();
        app.getContactHelper().createContact(new ContactData("Olga", "Zhivotovskaia", null, null, "happidai@gmail.com", "test1"));


    }


}
