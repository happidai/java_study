package first.train.addressbook.tests;

import first.train.addressbook.appmanager.ApplicationManager;
import first.train.addressbook.model.GroupData;
import first.train.addressbook.model.Groups;
import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.Contacts;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();

    }

    public void verifyGroupListInUi() {
        if(Boolean.getBoolean("verifyUI")){
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupData().withId(g.getId()).withName(g.getName())).collect(Collectors.toSet())) );
        }
    }

    public void verifyContactListInUi() {

        if(Boolean.getBoolean("verifyUI")){
            Contacts dbContacts = app.db().contacts();
            Contacts uiContacts = app.contact().all();
            assertThat(uiContacts, equalTo(dbContacts.stream().map((g) -> new ContactData().withId(g.getId()).withFirstname(g.getFirstname()).withLastname(g.getLastname())).collect(Collectors.toSet())) );
        }

    }

}
