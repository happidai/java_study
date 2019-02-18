package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test

    public void testContactModification() {

        app.getContactNavigationHelper().gotoContactPageEdit();

        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Olga", "Zhivotovskaia", "ST-P", "+79218812075", "happidai@gmail.com", "test1"));
        }
        app.getContactNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Olgat", "Zhivotovskaia", "St.-Petersburg", "89218812075", "happidai@gmail.com", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactNavigationHelper().gotoHomePage();

    }


}
