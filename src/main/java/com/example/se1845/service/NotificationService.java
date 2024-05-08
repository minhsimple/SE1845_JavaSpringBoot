package com.example.se1845.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.se1845.dto.NotificationDTO;

public interface NotificationService {
    public ResponseEntity<Object> createNotification(NotificationDTO notificationDto);

    public ResponseEntity<Object> updateNotification(String notifyid, NotificationDTO notificationDto);

    public ResponseEntity<Object> getNotificationById(String notifyid);

    public List<NotificationDTO> getAllNotification();

    public ResponseEntity<Object> deleteNotification(String notifyid);
}
