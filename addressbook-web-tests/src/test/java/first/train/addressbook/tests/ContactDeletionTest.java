package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {

        app.getContactNavigationHelper().gotoContactPageEdit();

        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Olga", "Zhivotovskaia", "St.-P.", "+79218812075", "happidai@gmail.com", "test1"));
        }

        app.getContactNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().closeAlert();

    }


}
