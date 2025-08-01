package com.team2.library.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("evening")
public class EveningGreetingService implements GreetingService{
    @Override
    public String greet() {
        return "Good Evening !!";
    }
}
