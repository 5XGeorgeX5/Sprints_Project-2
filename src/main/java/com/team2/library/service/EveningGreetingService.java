package com.team2.library.service;

import org.springframework.stereotype.Service;

@Service
public class EveningGreetingService implements GreetingService{
    @Override
    public String greet() {
        return "Good Evening !!";
    }
}
