package com.hcl.msa.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import com.hcl.msa.parser.ApplicationParser;

@Component
public class MSAMessageReceiver {
	private static final Logger logger = LoggerFactory.getLogger(MSAMessageReceiver.class);
	@JmsListener(destination = "msa.reqeust.queue", concurrency = "3-40")
	public void receiveQueue(String text) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Message Received: " + text);
		logger.info("Calling parser to parse the application code : " + text);
		ApplicationParser parser = new ApplicationParser();
		try {
			parser.parseApplication(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("*******Parser Task - COMPLETED******* ");
	}
}
