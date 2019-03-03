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
        assertThat(app.group().count(), equalTo(before.size()+1));
        Groups after = app.group().all();

        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

   }


    @Test
    public void testBadGroupCreation() throws Exception {

        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();

        assertThat(after, equalTo(before));

    }





}



