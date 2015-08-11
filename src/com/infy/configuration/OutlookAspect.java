/**
 * 
 */
package com.infy.configuration;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infy.domain.OutlookDetails;

/**
 * @author AvinashVaidya
 *
 */
@Aspect
public class OutlookAspect {

	private static Logger LOGGER = LoggerFactory.getLogger(OutlookAspect.class);

	@AfterReturning(pointcut = "@annotation(OutlookEmail)", returning = "retVal")
	public void emailAdvice(JoinPoint jp, OutlookDetails retVal) {

		// test email account created for this project to show case the java
		// mail
		// api
		final String username = "projectinfosys1984@gmail.com";
		final String password = "Project1984";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("projectinfosys@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(retVal.getUserEmail()));
			message.setSubject("Infy Online Store Welcomes You");
			message.setText("Dear User," + "\n\n Welcome to Infy Online Store!");

			Transport.send(message);

			LOGGER.info("Email sent to " + retVal.getUserEmail());

		} catch (MessagingException e) {
			LOGGER.error("Error in Outlook Advice - " + e);
			throw new RuntimeException(e);
		}
	}

}
