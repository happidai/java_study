package first.train.addressbook.appmanager;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }


    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }


    public void selectContact(int index) {
        //click(By.xpath("//input[@name='selected[]']"));
        wd.findElements(By.xpath("//input[@name='selected[]']")).get(index).click();
        // click(By.name("selected[]"));
    }


    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])"));
    }


    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }


    public void closeAlert() {
        wd.switchTo().alert().accept();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//input[@id='selected[]']"));
        //return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contactData) {

        fillContactForm(contactData, true);
        submitContactCreation();

    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.xpath(".//tr[@name='entry']"));
        for (WebElement element : elements) {
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
           // int id = Integer.parseInt(element.findElement(By.xpath("//input[@name='selected[]']")).getAttribute("value"));
            ContactData contact = new ContactData(firstname, lastname, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;


    }
}

//    public List<GroupData> getGroupList() {
//        List<GroupData> groups = new ArrayList<GroupData>();
//        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
//        for(WebElement element : elements){
//            String name = element.getText();
//            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//            GroupData group = new GroupData(id, name, null, null);
//            groups.add(group);
//        }
//        return groups;
//    }