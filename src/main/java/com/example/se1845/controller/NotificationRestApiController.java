package com.example.se1845.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.se1845.dto.NotificationDTO;
import com.example.se1845.service.NotificationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notifications")
public class NotificationRestApiController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<Object> getAllNotification() {
        return notificationService.getAllNotification();
    }

    @GetMapping("/{notifyid}")
    public ResponseEntity<Object> getNotificationById(@PathVariable String notifyid) {
        return notificationService.getNotificationById(notifyid);
    }

    @PostMapping
    public ResponseEntity<Object> createNotification(@Valid @RequestBody NotificationDTO notificationDto) {
        return notificationService.createNotification(notificationDto);
    }

    @PutMapping("/{notifyid}")
    public ResponseEntity<Object> updateNotification(@PathVariable String notifyid,
            @Valid @RequestBody NotificationDTO notificationDto) {
        return notificationService.updateNotification(notifyid, notificationDto);
    }

    @DeleteMapping("/{notifyid}")
    public ResponseEntity<Object> deleteNotification(@PathVariable String notifyid) {
        return notificationService.deleteNotification(notifyid);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
