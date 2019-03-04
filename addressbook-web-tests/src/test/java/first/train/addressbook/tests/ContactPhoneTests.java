package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhones() {
        app.goToContact().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
        assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
        assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
        assertThat(contact.getEmail(), equalTo(contactInfoFromEditForm.getEmail()));
        assertThat(contact.getEmail2(), equalTo(contactInfoFromEditForm.getEmail2()));
        assertThat(contact.getEmail3(), equalTo(contactInfoFromEditForm.getEmail3()));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));


    }

    public String cleaned (String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
