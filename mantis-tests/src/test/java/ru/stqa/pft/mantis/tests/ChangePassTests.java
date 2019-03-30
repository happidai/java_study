package ru.stqa.pft.mantis.tests;


import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePassTests extends TestBase {

    //@BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testChangePassword() throws IOException, MessagingException {
        String newPassword = "newPassword";
        app.password().login();
        app.password().goToManagePage();
        app.password().goToManageUsersPage();
        app.password().chooseUser();
        String user = app.password().getUserName();
        String email = app.password().getMail();
        app.password().resetPassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 20000);
        String resetPasswordLink = findResetPasswordLink(mailMessages, email);
        app.password().changePasswordFinish(resetPasswordLink, newPassword);
        HttpSession session = app.newSession();
        assertTrue(session.login(user, newPassword));
        assertTrue(session.isLoggedInAsUser(user));
    }

    private String findResetPasswordLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    //@AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
