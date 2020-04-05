package br.com.enviandoEmail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	String userName ="ramirovictordev@gmail.com";
	String password = "";
	
	@Test
	public void testEmail() {// olhar as configurações smtp do email

		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");// Autorização
			properties.put("mail.smtp.starttls", "true");// Autenticação
			properties.put("mail.smtp.host", "smtp.gmail.com");// Servidor do gmail do google
			properties.put("mail.smtp.port", "465");// Porta do servidor
			properties.put("mail.smtp.socketFactory.port", "465");// especifica a porta a ser conetada pelo socket
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// Classe socket de
																								// conexão ao SMTP
			Session session = Session.getInstance(properties, new Authenticator( ) {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, password);
				}
			});
			
			Address[] toUser = InternetAddress.parse("ramirovictor3@gmail.com, ramiro.alves@engesoftware.com.br");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName));//quem está enviando
			message.setRecipients(Message.RecipientType.TO, toUser);//Email de destino
			message.setSubject("Chegou email enviado com o java");//assunto do email
			message.setText("Olá amigo, você acaba de recebere um email enviado com java");
			
			
			Transport.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
