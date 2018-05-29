/**
 * 
 */
package com.tact.email;
import java.util.Arrays;
import java.util.List;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;


/**
 * @author Maz
 *
 */
public class AwsPostMan implements PostMan {

	/* (non-Javadoc)
	 * @see com.tact.email.PostMan#setFrom(java.lang.String)
	 */
	
	private String from, to, subject, body;
	private AmazonSimpleEmailService simpleEmailService;
	
	public AwsPostMan(AmazonSimpleEmailService simpleEmailService){
		this.simpleEmailService = simpleEmailService;
	}
	public void setFrom(String from) {
		// TODO Auto-generated method stub
		this.from = from;
	}

	/* (non-Javadoc)
	 * @see com.tact.email.PostMan#setTo(java.lang.String)
	 */
	public void setTo(String to) {
		// TODO Auto-generated method stub
		this.to = to;
	}

	/* (non-Javadoc)
	 * @see com.tact.email.PostMan#setSubject(java.lang.String)
	 */
	public void setSubject(String subject) {
		// TODO Auto-generated method stub
		this.subject = subject;
	}

	/* (non-Javadoc)
	 * @see com.tact.email.PostMan#setBody(java.lang.String)
	 */
	public void setBody(String body) {
		// TODO Auto-generated method stub
		this.body = body;
	}

	/* (non-Javadoc)
	 * @see com.tact.email.PostMan#send()
	 */
	
	private List<String> getToAsList(){
		return Arrays.asList(to.split(","));
	}
	public void send() {
		// TODO Auto-generated method stub
		Destination destination = new Destination(getToAsList());
		SendEmailRequest request = new SendEmailRequest(from, destination, createMessage());
	}

	private Message createMessage() {
		// TODO Auto-generated method stub
		Body amazonBody = new Body(new Content(body));
		//amazonBody.setText();
		Message message = new Message(new Content(subject), amazonBody);
		return message;
		
	}
	/* (non-Javadoc)
	 * @see com.tact.email.PostMan#withFron(java.lang.String)
	 */
	public PostMan withFrom(String from) {
		// TODO Auto-generated method stub
		this.from = from;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.tact.email.PostMan#withTo(java.lang.String)
	 */
	public PostMan withTo(String to) {
		// TODO Auto-generated method stub
		this.to= to;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.tact.email.PostMan#withSubject(java.lang.String)
	 */
	public PostMan withSubject(String subject) {
		// TODO Auto-generated method stub
		this.subject = subject;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.tact.email.PostMan#withBody(java.lang.String)
	 */
	public PostMan withBody(String body) {
		// TODO Auto-generated method stub
		this.body = body;
		return this;
	}

}
