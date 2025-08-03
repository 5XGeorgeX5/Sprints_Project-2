package com.team2.library.common.controller;

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
