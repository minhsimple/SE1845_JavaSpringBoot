package com.example.se1845.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.se1845.converter.NotificationConverter;
import com.example.se1845.dto.NotificationDTO;
import com.example.se1845.model.Notification;
import com.example.se1845.repository.NotificationRepository;

@Service
public class NotificationServiceImp implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationConverter notificationConverter;

    @Override
    public ResponseEntity<Object> createNotification(NotificationDTO notificationDto) {
        Notification notification = notificationConverter.toNotification(notificationDto);
        notificationRepository.save(notification);
        return new ResponseEntity<>(notificationDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateNotification(String notifyid, NotificationDTO notificationDto) {
        if (notificationRepository.existsById(notifyid)) {
            Notification notification = notificationConverter.toNotification(notificationDto);
            notificationRepository.save(notification);
            return new ResponseEntity<>(notificationDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> getNotificationById(String notifyid) {
        Optional<Notification> notificationOptional = notificationRepository.findById(notifyid);

        if (!notificationOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Notification notification = notificationOptional.get();
        NotificationDTO notificationDto = notificationConverter.toNotificationDTO(notification);
        return new ResponseEntity<>(notificationDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getAllNotification() {
        Iterable<Notification> notifications = notificationRepository.findAll();
        List<NotificationDTO> notificationDtos = new ArrayList<>();

        for (Notification notification : notifications) {
            NotificationDTO notificationDto = notificationConverter.toNotificationDTO(notification);
            notificationDtos.add(notificationDto);
        }
        return new ResponseEntity<>(notificationDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteNotification(String notifyid) {
        if (notificationRepository.existsById(notifyid)) {
            notificationRepository.deleteById(notifyid);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
