package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class PasswordHelper extends HelperBase {

        public PasswordHelper(ApplicationManager app) {
            super(app);
        }

    public void login() {
        String admin = app.getProperty("web.adminLogin");
        String adminPw = app.getProperty("web.adminPassword");
        type(By.name("username"), admin);
        click(By.cssSelector("input[value='Login']"));
        type(By.name("password"), adminPw);
        click(By.cssSelector("input[value='Login']"));
    }

    public void goToManagePage() {
        wd.findElement(By.linkText("Manage")).click();
    }

    public void goToManageUsersPage() {
        wd.findElement(By.linkText("Manage Users")).click();
    }

    public void chooseUser(String username) {
        wd.findElement(By.linkText(username)).click();
    }

    public void resetPassword() {
        wd.findElement(By.cssSelector("input[value='Reset Password']")).click();
    }

    
}