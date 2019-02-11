package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import org.testng.annotations.*;


public class ContactCreationTest extends TestBase{



    @Test
    public void testContactCreation() throws Exception {

        app.getContactNavigationHelper().gotoContactPageEdit();
        app.getContactHelper().fillContactForm(new ContactData("Olga", "Zhivotovskaia", "St.-Petersburg", "89218812075", "happidai@gmail.com"));
        app.getContactHelper().submitContactCreation();

    }


}
