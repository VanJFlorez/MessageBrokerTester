package com.ram.receiver;

import com.ram.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver
{

  @Autowired
  private ApplicationContext context;
  
  private static final String MESSAGE_QUEUE = "message_queue";
	
	@JmsListener(destination = MESSAGE_QUEUE)
	public void receiveMessage(Product product)
	{
    System.out.println("Received " + product);
    JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
    
    Product product1 = new Product(1, "nose", 100);
    Product product2 = new Product(2, "nose2", 200);
    jmsTemplate.convertAndSend(MESSAGE_QUEUE, product1);
    System.out.println("enviando producto 1");
	}
}
