package first.train.addressbook.tests;


import first.train.addressbook.model.GroupData;
import org.testng.annotations.*;


public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation() throws Exception {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();

    }

       }



