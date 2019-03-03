package first.train.addressbook.tests;

import first.train.addressbook.model.GroupData;
import first.train.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }


    @Test
    public void testGroupModification() {

        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test3").withHeader("test1").withFooter("test2");
        app.group().modify(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));


//        before.remove(modifiedGroup);
//        before.add(group);
////        Comparator<? super GroupData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
////        before.sort(ById);
////        after.sort(ById);
//        Assert.assertEquals(before, after);


    }




}
