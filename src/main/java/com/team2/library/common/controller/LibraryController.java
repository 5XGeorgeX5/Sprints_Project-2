package com.team2.library.common.controller;

import com.team2.library.config.LibraryConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    private final LibraryConfig libraryConfig;

    public LibraryController(LibraryConfig libraryConfig) {
        this.libraryConfig = libraryConfig;
    }

    @GetMapping("/library-info")
    public String getLibraryInfo() {
        return libraryConfig.toString();
    }

    @GetMapping("/health")
    public String PrintOk(){
        return "OK";
    }
}
