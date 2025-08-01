package com.team2.library.greeting;

import com.team2.library.greeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {
    //constructor injection
    private final GreetingService morningGreetingService;
    //set injection
    private GreetingService eveningGreetingService;

    @Autowired
    public GreetingController(GreetingService morningGreetingService) {
        this.morningGreetingService = morningGreetingService;
    }

    @Autowired
    public void setEveningGreetingService(@Qualifier("evening") GreetingService eveningGreetingService) {
        this.eveningGreetingService = eveningGreetingService;
    }

    //field injection
    @Autowired
    private GreetingService defaultGreetingService;

    @GetMapping("/morning")
    public String greetMorning() {
        return morningGreetingService.greet();
    }

    @GetMapping("/evening")
    public String greetEvening() {
        return eveningGreetingService.greet();
    }

    @GetMapping("/default")
    public String greetDefault() {
        return defaultGreetingService.greet();
    }
}

// to run in postman : http://localhost:8080/greet/morning
// bdl morning el GetMapping blzbt