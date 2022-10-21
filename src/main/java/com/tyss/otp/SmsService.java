package com.tyss.otp;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component

public class SmsService {

	private final String ACCOUNT_SID = "ACf372909c8d89c708496133a432049f47";

	private final String AUTH_TOKEN = "e87cf927c4f315e4a0c1c1ba79e42812";

	private final String FROM_NUMBER = "+18584334344";

	public void send(SmsPojo sms) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
				.create();

		System.out.println("here is my id:" + message.getSid());// Unique resource ID created to manage this transaction

	}

}
