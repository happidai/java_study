package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhones() {

        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

      assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));


    }

    private String mergePhones(ContactData contact) {
     return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
             .map(ContactPhoneTests::cleanedPhone)
             .collect(Collectors.joining("\n"));

    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleanedEmail)
                .collect(Collectors.joining("\n"));

    }

    public static String cleanedPhone (String phone){

        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    public static String cleanedEmail (String email){
        return email.replaceAll("\\s", "").replaceAll("[()]", "");
    }


//    private String mergePhones(ContactData contact) {
//        String result = "";
//        if(contact.getHomePhone() != null){
//            result = result + contact.getHomePhone();
//        }
//        return result;
//
//    }



}
