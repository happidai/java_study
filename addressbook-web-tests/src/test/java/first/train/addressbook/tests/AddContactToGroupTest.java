package first.train.addressbook.tests;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.GroupData;
import first.train.addressbook.model.Groups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AddContactToGroupTest extends TestBase{

    @BeforeClass
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goToContact().gotoContactPageEdit();
            app.contact().createContact(new ContactData()
                    .withFirstname("TestTest").withEmail2("email2"));
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData()
                    .withName("TestTest"));
        }
        for (ContactData contact : app.db().contacts()) {
            if (contact.getGroups().size() < app.db().groups().size()) {
                break;
            } else {
                app.goTo().groupPage();
                app.group().create(new GroupData()
                        .withName("TestTest"));
            }
        }
    }


    @Test
    public void testAddContactToGroup() {
        ContactData contact = null;
        for (ContactData newContact : app.db().contacts())
            if (newContact.getGroups().size() < app.db().groups().size()) {
                contact = newContact;
            }
        Groups before = contact.getGroups();
        Groups allGroups = app.db().groups();
        allGroups.removeAll(before);
        GroupData group = allGroups.iterator().next();
        app.contact().selectContactById(contact.getId());
        app.group().selectNew(group.getId());
        app.contact().addContactToGroup();
        Groups after = app.db().contactByIdInDB(contact.getId()).iterator().next().getGroups();
        assertEquals(after, before.withAdded(group));
    }


}




