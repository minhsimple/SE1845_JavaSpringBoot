package com.example.se1845.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.se1845.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, String> {

}