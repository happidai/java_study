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

        public void chooseUser() {
            //выбирается заданный юзер, который уже создан
            wd.findElement(By.cssSelector("a[href*='manage_user_edit_page.php?user_id=3']")).click();
        }

        public void resetPassword() {
            wd.findElement(By.cssSelector("input[value='Reset Password']")).click();
        }

        public String getUserName() {
            String username = wd.findElement(By.cssSelector("input[name='username']")).getAttribute("value");
            return username;
        }

        public String getMail() {
            String email = wd.findElement(By.cssSelector("input[name='email']")).getAttribute("value");
            return email;
        }

        public void changePasswordFinish(String resetPasswordLink, String newPassword) {
            wd.get(resetPasswordLink);
            type(By.name("password"), newPassword);
            type(By.name("password_confirm"), newPassword);
            click(By.cssSelector("input[value='Update User']"));
        }
    }