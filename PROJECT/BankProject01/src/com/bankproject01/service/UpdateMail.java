package com.bankproject01.service;

import com.bankproject01.dao.AccountDao;
import com.bankproject01.model.Account;
import com.bankproject01.testmain.TestMain;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class UpdateMail {

    private String emailAddressTo = new String();
    private String msgSubject = new String();
    private String msgText = new String();
    final String PASSSWORD = "elbbfmlofzzcsnts";  //Password of the Goole(gmail) account
    final String FROM_ADDRESS = "risingstarsbank@gmail.com";  //From addresss

    static String pin;
    static String email;

    public void setValue(String pin, String email) {
        this.pin = pin;
        this.email = email;
    }

    public UpdateMail() {
    }

    public static void main(String[] args) {
        UpdateMail email = new UpdateMail();
        //Sending test email
        email.createAndSendEmail("risingstarsbank@gmail.com", "Create bank account ",
                " Dear customer, \n your pin has been successfully update and PIN " + UpdateMail.pin + " Warning !! Do not share your pin number");
    }

    public void createAndSendEmail(String emailAddressTo, String msgSubject, String msgText) {
        this.emailAddressTo = emailAddressTo;
        this.msgSubject = msgSubject;
        this.msgText = msgText;
        sendEmailMessage();
    }

    private void sendEmailMessage() {

        // create a object of account: 
        Account account = new Account();

        //Create email sending properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("risingstarsbank@gmail.com", "elbbfmlofzzcsnts");
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("risingstarsbank@gmail.com")); //Set from address of the email
            message.setContent(msgText, "text/html"); //set content type of the email

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); //Set email recipient

            message.setSubject("RS BANK"); //Set email message subject
            Transport.send(message); //Send email message

            System.out.println(TestMain.setGreen + "Pin successfully updated...." + TestMain.resetColor);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
