package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.GroupData;
import first.train.addressbook.model.Groups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DeleteContactFromGroupTest extends TestBase{

    @BeforeClass
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goToContact().HomePage();
            app.contact().createContact(new ContactData()
                    .withFirstname("TestTest").withEmail2("email2"));
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData()
                    .withName("TestTest"));
        }
    }

    @Test
    public void testDeleteContactFromGroup() {
        Groups before = null;
        GroupData availableGroup = null;
        ContactData availableContact = null;
        int groupId = 0;
        for (ContactData contact : app.db().contacts()) {
            if (contact.getGroups().size() == 0) {
                app.goToContact().HomePage();
                app.contact().selectContactById(contact.getId());
                app.contact().addContactToGroup();
                availableContact = contact;
                availableGroup = app.db().contactByIdInDB(availableContact.getId()).iterator().next().getGroups().iterator().next();
                groupId = availableGroup.getId();
                before = contact.getGroups();
            } else {
                availableContact = contact;
                availableGroup = contact.getGroups().iterator().next();
                groupId = availableGroup.getId();
                before = contact.getGroups();
            }
        }
        app.goToContact().HomePage();
        app.group().selectByIdOnHomePage(groupId);
        app.contact().selectContactById(availableContact.getId());
        app.contact().removeContactFromGroup();
        Groups after = app.db().contactByIdInDB(availableContact.getId()).iterator().next().getGroups();
        assertEquals(after, before.without(availableGroup));
    }




}
