package com.team2.library.notifications.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("sms")
public class SmsNotificationService implements NotificationService {
    @Override
    public String sendNotification(){
        return "SMS notification sent!";
    }
}
