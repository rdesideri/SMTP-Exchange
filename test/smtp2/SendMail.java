package smtp2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author leickiet
 */


public class SendMail {
    
    public static void main(String[] args) {
        MailClass m = new MailClass();
        m.user_auth = "email@email.com";
        m.user_password = "senha";
        m.host="stbeehive.oracle.com";
        m.port = "465";
        m.SendMail("rdesideri@gmail.com","teste","teste");
    }
}