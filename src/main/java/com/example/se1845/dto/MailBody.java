package com.example.se1845.dto;

import lombok.Builder;

@Builder
public record MailBody(String to, String subject, String text) {

}
