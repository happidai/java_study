package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class PasswordHelper extends HelperBase {

        public PasswordHelper(ApplicationManager app) {
            super(app);
        }

    private String user;
    private String password;
    private String username;

    public void login(String user, String password){
        this.user = user;
        this.password = password;
        type(By.name("username"), user);
        type(By.name("password"), password);
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


    public void resetPassword(String user) throws InterruptedException {
        //   Thread.sleep(3000);
        this.username = user;
        click(By.linkText("Manage Users"));
        click(By.linkText(username));
        //    Thread.sleep(3000);
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public void finish(String confirmationLink, String newpassword) throws InterruptedException {
        // Thread.sleep(2000);
        wd.get(confirmationLink);
        type(By.name("password"),newpassword);
        type(By.name("password_confirm"),newpassword);
        click((By.cssSelector("input[value='Update User']")));
    }
}
