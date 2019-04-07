package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        if(app.db().contacts().size() == 0){
            app.goToContact().gotoContactPageEdit();
            app.contact().createContact(new ContactData().withFirstname("Olga").withLastname("Zhivotovskaia").withAddress("St. Petersburg").withMobilePhone("222").withHomePhone("1111").withWorkPhone("33").withEmail("happidai@gmail.com").withEmail2("olga.zhivotovskaia@t-systems.com").withEmail3("happidai@yandex.ru"));
        }
    }

    @Test(enabled = false)
    public void testContactModification() {

        Set<ContactData> before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Olga").withLastname("Zhivotovskaia");
        app.contact().modifyContact(contact);
       // assertThat(app.contact().count(), equalTo(before.size()));
        Set<ContactData> after = app.db().contacts();
        verifyContactListInUi();

//        before.remove(modifiedContact);
//        before.add(contact);
////        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
////        before.sort(byId);
////        after.sort(byId);
//        Assert.assertEquals(before, after);
//
    }




}
