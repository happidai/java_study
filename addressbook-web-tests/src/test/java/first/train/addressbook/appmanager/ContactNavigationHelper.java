package first.train.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactNavigationHelper extends HelperBase{
    private FirefoxDriver wd;

    public ContactNavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoContactPageEdit() {
        click(By.linkText("add new"));
    }

    public void HomePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home page"));
    }
}

