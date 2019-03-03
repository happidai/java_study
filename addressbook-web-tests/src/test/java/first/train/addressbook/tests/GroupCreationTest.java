package first.train.addressbook.tests;


import first.train.addressbook.model.GroupData;
import first.train.addressbook.model.Groups;
import jdk.nashorn.internal.runtime.regexp.joni.Matcher;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;


public class GroupCreationTest extends TestBase {




    @Test
    public void testGroupCreation() throws Exception {

        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size()+1));


        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));



//        int max = 0;
//        for(GroupData g : after){
//            if(g.getId() > max){
//                max = g.getId();
//            }
//        }

//        Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
//        int max1 = after.stream().max(byId).get().getId();
//        group.setId(max1);
//        before.add(group);
//        Comparator<? super GroupData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        before.sort(ById);
//        after.sort(ById);

    }

}



