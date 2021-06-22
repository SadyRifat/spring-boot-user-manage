package com.user.manage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serve")
public class ServiceController {
    @GetMapping("/content")
    public String allAccess() {
        return "JWT Verified.";
    }
}
