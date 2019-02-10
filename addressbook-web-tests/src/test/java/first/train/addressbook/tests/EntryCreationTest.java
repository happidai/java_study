package first.train.addressbook.tests;

import first.train.addressbook.model.EntryData;
import org.testng.annotations.*;


public class EntryCreationTest extends TestBase{



    @Test
    public void testEntryCreation() throws Exception {

        app.getEntryNavigationHelper().gotoEntryPage();
        app.getEntryHelper().fillEntryForm(new EntryData("Olga", "Zhivotovskaia", "St.-Petersburg", "89218812075", "happidai@gmail.com"));
        app.getEntryHelper().submitEntryCreation();

    }


}
