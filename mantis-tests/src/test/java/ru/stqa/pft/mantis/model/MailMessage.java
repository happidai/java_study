package ru.stqa.pft.mantis.model;

import ru.stqa.pft.mantis.tests.TestBase;

public class MailMessage extends TestBase {

    public String to;
    public String text;

    public MailMessage(String to, String text) {
        this.to = to;
        this.text = text;
    }
}


