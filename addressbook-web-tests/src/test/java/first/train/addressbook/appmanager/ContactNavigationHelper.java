package first.train.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactNavigationHelper extends HelperBase{
    private FirefoxDriver wd;

    public ContactNavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoContactPageEdit() {
        click(By.linkText("add new"));
    }

    public void gotoHomePage() {click(By.linkText("home page"));
    }
}

