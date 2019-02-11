package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test

    public void testContactModification() {

        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Olgat", "Zhivotovskaia", "St.-Petersburg", "89218812075", "happidai@gmail.com"));
        app.getContactHelper().submitContactModification();
        app.getContactNavigationHelper().gotoHomePage();

    }


}
