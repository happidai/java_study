package first.train.addressbook.tests;

import first.train.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData("test1", null, null));
        }
    }


    @Test
    public void testGroupModification() {

        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test3").withHeader("test1").withFooter("test2");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());


        before.remove(modifiedGroup);
        before.add(group);
//        Comparator<? super GroupData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        before.sort(ById);
//        after.sort(ById);
        Assert.assertEquals(before, after);


    }




}
