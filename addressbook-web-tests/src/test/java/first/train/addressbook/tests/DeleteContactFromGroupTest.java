package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.Contacts;
import first.train.addressbook.model.GroupData;
import first.train.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteContactFromGroupTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
        }
        if (app.db().contacts().size() == 0) {
            app.goToContact().HomePage();
            Groups groups = app.db().groups();
            app.contact().createContact(new ContactData()
                    .withFirstname("Olga").withLastname("Zhvotovskaia").withAddress("Saint-Petersburg").withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail("email@email.com").inGroup(groups.iterator().next()));
        }
    }

    @Test(enabled = false)
    public void testDeleteContactFromGroup() {

        Contacts contactsBefore = app.db().contacts();
        Groups groupList = app.db().groups();
        ContactData selectedContact = contactsBefore.iterator().next();
        GroupData fromGroup = groupList.iterator().next();
        app.contact().removeContactFromGroup2(selectedContact, fromGroup);
        Contacts contactsAfter = app.db().contacts();
        assertThat(contactsAfter, equalTo(contactsBefore));
        verifyContactListInUi();
        }
//        app.goToContact().HomePage();
//        app.group().selectByIdOnHomePage(groupId);
//        app.contact().selectContactById(availableContact.getId());
//        app.contact().removeContactFromGroup();
//        Groups after = app.db().contactByIdInDB(availableContact.getId()).iterator().next().getGroups();
//        assertEquals(after, before.without(availableGroup));
//removeContactFromGroup(selectedContact, fromGroup);
    }






