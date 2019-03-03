package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactPhoneTests extends TestBase{

    @Test
    public void testContactPhones() {
        app.goToContact().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);


    }

}
