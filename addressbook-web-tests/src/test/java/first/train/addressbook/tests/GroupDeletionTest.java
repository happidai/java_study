package first.train.addressbook.tests;

import first.train.addressbook.model.GroupData;
import first.train.addressbook.model.Groups;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupDeletionTest extends TestBase {


    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().groups().size()==0) {
            app.goTo().groupPage();
            if (app.group().all().size() == 0) {
                app.group().create(new GroupData().withName("test1"));
            }
        }
    }



    @Test
    public void testGroupDeletion() throws Exception {
        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() -1));
        Groups after = app.db().groups();


        before.remove(deletedGroup);
        assertThat(after, equalTo(before.without(deletedGroup)));
        Assert.assertEquals(before, after);
        verifyGroupListInUi();

    }




}
