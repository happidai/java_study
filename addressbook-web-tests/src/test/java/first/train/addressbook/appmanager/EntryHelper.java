package first.train.addressbook.appmanager;

import first.train.addressbook.model.EntryData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EntryHelper extends HelperBase {


    public EntryHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitEntryCreation() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }


    public void fillEntryForm(EntryData entryData) {
        type(By.name("firstname"), entryData.getFirstname());
        type(By.name("lastname"), entryData.getLastname());
        type(By.name("address"), entryData.getAddress());
        type(By.name("mobile"), entryData.getMobile());
        type(By.name("email"), entryData.getEmail());

    }
}
