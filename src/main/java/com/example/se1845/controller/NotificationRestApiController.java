package com.example.se1845.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationRestApiController {

    @PostMapping("/create")
    public ResponseEntity<Object> createNotification() {
        return null;
    }

    @PutMapping("/edit")
    public ResponseEntity<Object> editNotification() {
        return null;
    }

    @GetMapping
    public ResponseEntity<Object> getNotification() {
        return null;
    }

}
