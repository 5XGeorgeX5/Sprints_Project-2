package com.team2.library;

import com.team2.library.config.LibraryConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {

    public DevController() {
    }

    @GetMapping("/dev")
    public String devEndpoint() {
        return "This endpoint is under development, remove it from Component Scan.";
    }
}
