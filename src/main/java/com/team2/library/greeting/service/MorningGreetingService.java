package com.team2.library.greeting.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MorningGreetingService implements GreetingService {

    @Override
    public String greet() {
        return "Good Morning !!";
    }
}
