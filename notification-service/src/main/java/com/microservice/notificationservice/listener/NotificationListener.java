package com.microservice.notificationservice.listener;

import com.microservice.messaging.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author erayy
 */
@EnableBinding(Sink.class)
public class NotificationListener {

    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification){
        System.out.println("Message received");
        System.out.println(ticketNotification.toString());
        System.out.println("_____________________________________________");
    }
}
