package first.train.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public final Properties properties;
    WebDriver wd;
    private ContactNavigationHelper contactNavigationHelper;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String browser;
    private DbHelper dbHelper;


    public ApplicationManager(String browser)  {
        this.browser = browser;
        properties = new Properties();
    }


    public void init()throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        dbHelper = new DbHelper();

        if(browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if(browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if(browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }

        delay(0);
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        contactNavigationHelper = new ContactNavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        wd.get(properties.getProperty("web.baseUrl"));
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword") );



    }

    public void delay(int time) {
        wd.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }


    public void stop() {
       // logout();
        wd.quit();
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public ContactNavigationHelper goToContact() {
        return contactNavigationHelper;
    }

    public DbHelper db() {return dbHelper;}
}
