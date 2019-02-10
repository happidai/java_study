package first.train.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private FirefoxDriver wd;
    private EntryNavigationHelper entryNavigationHelper;
    private EntryHelper entryHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;


    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(wd);
        entryHelper = new EntryHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        entryNavigationHelper = new EntryNavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }


    public void stop() {
        logout();
        wd.quit();
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public EntryHelper getEntryHelper() {
        return entryHelper;
    }

    public EntryNavigationHelper getEntryNavigationHelper() {
        return entryNavigationHelper;
    }
}
