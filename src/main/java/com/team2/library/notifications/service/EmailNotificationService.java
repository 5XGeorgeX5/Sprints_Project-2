package com.team2.library.notifications.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailNotificationService implements NotificationService{
    @Override
    public String sendNotification(){
        return "Email notification sent!";
    }
}
