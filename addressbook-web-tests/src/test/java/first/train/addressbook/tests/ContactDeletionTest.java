package first.train.addressbook.tests;

import first.train.addressbook.appmanager.HelperBase;
import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.GroupData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactDeletionTest extends TestBase {


    @Test
    public void testContactDeletion() throws Exception {

        app.getContactNavigationHelper().gotoContactPageEdit();

        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Olga", "Zhivotovskaia", "St.-P.", "+79218812075", "happidai@gmail.com", "test1"));
        }
        app.getContactNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().closeAlert();
        app.delay(10);
        app.getContactNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);





        before.remove(before.size()-1);
        Assert.assertEquals(before, after);

    }


}
