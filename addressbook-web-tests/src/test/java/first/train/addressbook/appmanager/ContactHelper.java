package first.train.addressbook.appmanager;

import first.train.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }


    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());

    }


    public void selectContact() { click(By.xpath("//input[@id='5']"));
    }


    public void initContactModification() { click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {click(By.xpath("(//input[@name='update'])"));
    }


    public void deleteSelectedContact()  {
        click(By.xpath("//input[@value='Delete']"));
    }



    public void closeAlert() {wd.switchTo().alert().accept();
    }
}

