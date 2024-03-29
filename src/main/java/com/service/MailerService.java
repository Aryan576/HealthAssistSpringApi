package com.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.springframework.stereotype.Service;

import com.bean.BookAppointmentBean;
import com.bean.DoctorProfileBean;
import com.bean.UserBean;

@Service
public class MailerService {
	public void sendOtpForUserVerification(UserBean userBean) {
		// mail logic
		
		
		String to = userBean.getEmail();// change accordingly

		// Sender's email ID needs to be mentioned
		String from = "aryanshah576@gmail.com";// change accordingly
		final String username = "aryanshah576@gmail.com";// change accordingly
		final String password = "rbpo kshr zoqt slzs";// change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("EmailVerification OTP");

			String url = "<a href='http://localhost:9595/verifyemail'>Verify</a>";
			// Now set the actual message
			message.setContent(
					"Hello " + userBean.getFirstname() + ", <b>" + userBean.getOtp()
							+ "</b> is your OTP to verify your Email<br> click below to verify your account<br>" + url,
					"text/html");

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	
	
	public void sendOtpForForgetPassword(UserBean userBean) {
		String to = userBean.getEmail();// change accordingly

		// Sender's email ID needs to be mentioned
		String from = "aryanshah576@gmail.com";// change accordingly
		final String username = "aryanshah576@gmail.com";// change accordingly
		final String password = "rbpo kshr zoqt slzs";// change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Password Reset OTP");

			// Now set the actual message
			message.setContent("Hello " + userBean.getFirstname() + ", <b>" + userBean.getOtp()
					+ "</b> is your OTP to verify your Identity For Reset Password<br>", "text/html");

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	

	public void sendWelcomeMail(UserBean userBean) {

	}

	public void sendDoctorRegisterMail(DoctorProfileBean doctorProfileBean) {
		
	}

	public void sendDoctorWelcomeMail(DoctorProfileBean doctorProfileBean) {
		
	}
	
	public void sendMailForPasswordUpdate(UserBean userBean) {

		String to = userBean.getEmail();// change accordingly

		// Sender's email ID needs to be mentioned
		String from = "aryanshah576@gmail.com";// change accordingly
		final String username = "aryanshah576@gmail.com";// change accordingly
		final String password = "rbpo kshr zoqt slzs";// change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Password Updated!!!");

			// Now set the actual message
			message.setContent("Hello " + userBean.getFirstname() + ",   Your Password succssfully update.. <br>",
					"text/html");

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	
	public void sendRescheduleReason(BookAppointmentBean appointmentBean) {
		String to = appointmentBean.getEmail();// change accordingly

		// Sender's email ID needs to be mentioned
		String from = "aryanshah576@gmail.com";// change accordingly
		final String username = "aryanshah576@gmail.com";// change accordingly
		final String password = "rbpo kshr zoqt slzs";// change accordingly


		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
		}
		});

		try {
		// Create a default MimeMessage object.
		Message message = new MimeMessage(session);

		// Set From: header field of the header.
		message.setFrom(new InternetAddress(from));

		// Set To: header field of the header.
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

		// Set Subject: header field
		message.setSubject("Please, Reschedule Your Appointment");

		String url = "<a href='https://healthassist-frontend.herokuapp.com'>Reschedule Your Appointment Here</a>";
		// Now set the actual message
		message.setContent("Hello " + appointmentBean.getPatientname() + ","+ "<br>" + "Sorry for your inconvience, your appointment with Dr. "+ appointmentBean.getFirstname() + " " + appointmentBean.getLastname() +" has been reschedule due to following reason : " + "<br>" + "<b> Reason For Reschedule Appointment : </b>" + appointmentBean.getStatusreason()
		+"<br><br>"+ "Please Click on the below line reschedule your appointment"+"<br>"+ url +"<br><br><br><br>"+"Yours Faithful, "+ "<br>"+"Health Assist" , "text/html");

		// Send message
		Transport.send(message);

		System.out.println("Sent Reschedule message successfully....");

		} catch (MessagingException e) {
		e.printStackTrace();
		}
		}


	public void sendRejectReason(BookAppointmentBean appointmentBean) {
		// TODO Auto-generated method stub
		
		String to = appointmentBean.getEmail();// change accordingly

		// Sender's email ID needs to be mentioned
		String from = "aryanshah576@gmail.com";// change accordingly
		final String username = "aryanshah576@gmail.com";// change accordingly
		final String password = "rbpo kshr zoqt slzs";// change accordingly


		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
		}
		});

		try {
		// Create a default MimeMessage object.
		Message message = new MimeMessage(session);

		// Set From: header field of the header.
		message.setFrom(new InternetAddress(from));

		// Set To: header field of the header.
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

		// Set Subject: header field
		 message.setSubject("Your Appointment Has Been Rejected");

         String url = "<a href='https://healthassist-frontend.herokuapp.com'>Book Your Appointment Here</a>";
         // Now set the actual message
         message.setContent("Hello " + appointmentBean.getPatientname() + ","+ "<br>" + "Sorry for your inconvience, your appointment with Dr. "+ appointmentBean.getFirstname() + " " + appointmentBean.getLastname() +" has been rejected due to following reason : " + "<br>" + "<b> Reason For Rejected Appointment  :  </b>" + appointmentBean.getStatusreason() 
         +"<br><br>"+ "Please click on the below line for book your new appointment"+"<br>"+ url +"<br><br><br><br>"+"Yours Faithful, "+ "<br>"+"Health Assist" , "text/html");

         // Send message
         Transport.send(message);

         System.out.println("Sent Rejected message successfully....");
		} catch (MessagingException e) {
		e.printStackTrace();
		}
		
	}
	

}
