package com.tyss.otp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {

	@Autowired
	SmsService service;

	@Autowired
	private SimpMessagingTemplate webSocket;

	private final String TOPIC_DESTINATION = "/lesson/sms";

	@RequestMapping("/sms")
	public void smsSubmit(@RequestBody SmsPojo sms) {
		webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: " + sms.getTo());

	}

	private String getTimeStamp() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
	}

}
