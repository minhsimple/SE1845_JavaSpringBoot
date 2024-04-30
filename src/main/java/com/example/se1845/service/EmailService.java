package com.example.se1845.service;

import com.example.se1845.dto.MailBody;

public interface EmailService {

    public void sendSimpleMessage(MailBody mailBody);
}
