package first.train.addressbook.tests;


import first.train.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class GroupCreationTest extends TestBase {




    @Test
    public void testGroupCreation() throws Exception {

        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData("test1", null, null);
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());


//        int max = 0;
//        for(GroupData g : after){
//            if(g.getId() > max){
//                max = g.getId();
//            }
//        }

//        Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
//        int max1 = after.stream().max(byId).get().getId();
//        group.setId(max1);
        before.add(group);
//        Comparator<? super GroupData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        before.sort(ById);
//        after.sort(ById);
        Assert.assertEquals(before, after);
    }

}



