package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        //app.goToContact().HomePage();

        if(app.db().contacts().size() == 0){
            app.goToContact().gotoContactPageEdit();
            app.contact().createContact(new ContactData().withFirstname("Olga").withLastname("Zhivotovskaia").withAddress("St. Petersburg").withMobilePhone("222").withHomePhone("1111").withWorkPhone("33").withEmail("happidai@gmail.com").withEmail2("olga.zhivotovskaia@t-systems.com").withEmail3("happidai@yandex.ru"));
        }
    }


    @Test(enabled = false)
    public void testContactDeletion() throws Exception {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.delay(10);
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.db().contacts();
         assertThat(after, equalTo(before.without(deletedContact)));
        verifyContactListInUi();

    }



}
