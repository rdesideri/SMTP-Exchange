package smtp2;

import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import java.util.Properties;



public class MailClass {
    
    String user_auth = "leickietl_br@oracle.com";
    String user_password = "Leicki2018!";
    String host="stbeehive.oracle.com";
    String port = "465";


    public void SendMail(String emailTo, String emailSubject, String emailText) {            
        
        String from = "leickietl_br@oracle.com";
        String to = emailTo;
        String Subject = emailSubject;
        String MessageText = emailText;

        Properties mailProp = new Properties();
        mailProp.put("mail.smtp.host",host); 
        mailProp.put("mail.smtp.port",port);
        /*
         * Itt jonnek a TLS beallitasok
         */
        mailProp.put("mail.smtp.starttls.enable","true");
        mailProp.put("mail.smtp.auth","true");
        mailProp.put("mail.smtp.socketFactory.port",port);
        mailProp.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        mailProp.put("mail.smtp.socketFactory.fallback","false");

       // Optionalisan debug
        mailProp.put("mail.debug", "true");

       
         try {

        Authenticator myAuth = new MyAuthenticator();
        Session session = Session.getDefaultInstance(mailProp,myAuth);
        

        session.setDebug(true);

        MimeMessage mymsg = new MimeMessage(session);
        mymsg.setText(MessageText);
        mymsg.setSubject(Subject);
        mymsg.setFrom(new InternetAddress(from));
        mymsg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        Transport.send(mymsg);
        session.getDebugOut();

         } catch (Exception e){
            e.printStackTrace();
        }
    }


   private class MyAuthenticator extends javax.mail.Authenticator{
      @Override
      public PasswordAuthentication getPasswordAuthentication()
       {
           return new PasswordAuthentication(user_auth, user_password);
       }
   }
}
