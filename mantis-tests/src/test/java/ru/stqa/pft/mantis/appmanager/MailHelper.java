package ru.stqa.pft.mantis.appmanager;

import org.subethamail.wiser.Wiser;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static afu.org.checkerframework.checker.units.UnitsTools.m;

public class MailHelper {
    public ApplicationManager app;
    private final Wiser wiser;


    public MailHelper(ApplicationManager applicationManager) {
        this.app  = app;
        wiser = new Wiser();

public List<MailMessage> waitForMail(int count, long timeout){
long start = System.currentTimeMillis();
while(System.currentTimeMillis() < start + timeout) {
    if(wiser.getMessages().size() >= count){
        return wiser.getMessages().stream().map((m) -> toModeMail(m)).collect(Collectors.toList());
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
}
throw new Error("No mail:(");

        }

        public static mailMessage toModelMail(WiserMessage m){
    try{
        MimeMessage mm = m.getMimeMessage();
        return new MailMessage(mm.getAllRecipients()[0].toString(), (String) mm.getContent());
    } catch(MessagingException e){
        e.printStackTrace();
        return null;
    }catch(IOException e){
        e.printStackTrace();
    }

        }






    }
}
