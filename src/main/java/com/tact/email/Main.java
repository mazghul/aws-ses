package com.tact.email;

import java.io.IOException;
import java.util.Properties;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;

public class Main {

	private AWSCredentials createAwsCredentials() throws IOException {
		Properties properties = new Properties();
		properties.load(getClass().getClassLoader().getResourceAsStream("aws.properties"));
		AWSCredentials credentials = new BasicAWSCredentials(properties.getProperty("aws.accessKey"),
				properties.getProperty("aws.secretKey"));
		// AWSCredentials credentials2 = new
		// PropertiesCredentials(getClass().getClassLoader().getResourceAsStream("aws.properties"));
		return credentials;
	}

	@SuppressWarnings("deprecation")
	private AmazonSimpleEmailService createSimpleEmailService() throws IOException {
		return new AmazonSimpleEmailServiceClient(createAwsCredentials());
	}

	private void sendTestEmail() throws IOException{
		PostMan postMan = new AwsPostMan(createSimpleEmailService());
		postMan.withFrom("illuminati.nec@gmail.com").withTo("tentkottaa@gmail.com").withSubject("Email from AWS!!").withBody("This is a test email from AWS").send();
	}

	public static void main(String[] args) throws IOException {
		new Main().sendTestEmail();
	}
}
