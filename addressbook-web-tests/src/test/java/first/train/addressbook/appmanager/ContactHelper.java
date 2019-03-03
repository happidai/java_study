package first.train.addressbook.appmanager;

import first.train.addressbook.model.ContactData;
import first.train.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    public void selectContact(int index) {
        //click(By.xpath("//input[@name='selected[]']"));
        wd.findElements(By.xpath("//input[@name='selected[]']")).get(index).click();
        // click(By.name("selected[]"));
    }


    public void initContactModification(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void initContactModificationById(int id) {
       // wd.findElement(By.xpath("//a[contains(@href='"+ id +"')]"));
       // wd.findElement(By.xpath("//a[contains(@href='"+ id +"')]//*[@alt='Edit']")).click();
       // wd.findElement(By.xpath("//img[@alt='Edit']")).findElement(By.xpath("//a[contains(@href='"+ id +"')]")).click();
       // wd.findElement(By.xpath("//a[contains(@href='"+ id +"')]")).findElement(By.xpath("//img[@alt='Edit']")).click();
       // wd.findElement(By.xpath("//a[href='edit.php?id="+ id +"')]")).click();
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
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
        return isElementPresent(By.xpath(".//tr[@name='entry']"));
        //return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contactData) {

        fillContactForm(contactData);
        submitContactCreation();
        contactCache = null;

    }

    private Contacts contactCache = null;


    public Contacts all() {
        if(contactCache != null){
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath(".//tr[@name='entry']"));
        for (WebElement element : elements) {
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.xpath("//input[@name='selected[]']")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return new Contacts(contactCache);


    }



    public void modifyContact(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactForm(contact);
        submitContactModification();
        contactCache = null;
    }


    public void delete(ContactData contact) {

        initContactModificationById(contact.getId());
        deleteSelectedContact();
contactCache = null;
    }

    public int count() {
        return wd.findElements(By.xpath(".//tr[@name='entry']")).size();
    }
}

