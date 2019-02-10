package first.train.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EntryNavigationHelper {
    private FirefoxDriver wd;

    public EntryNavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void gotoEntryPage() {
        wd.findElement(By.linkText("add new")).click();
    }
}
