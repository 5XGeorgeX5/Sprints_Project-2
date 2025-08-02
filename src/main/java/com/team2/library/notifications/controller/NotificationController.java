package com.team2.library.notifications.controller;

import com.team2.library.notifications.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private final NotificationService emailService;
    private final NotificationService smsService;

    @Autowired
    public NotificationController(NotificationService emailService, @Qualifier("sms") NotificationService smsService){
        this.emailService = emailService;
        this.smsService = smsService;
    }

    @GetMapping("/notify/email")
    public String sendEmail(){
        return emailService.sendNotification();
    }

    @GetMapping("notify/sms")
    public String sendSms(){
        return smsService.sendNotification();
    }
}
