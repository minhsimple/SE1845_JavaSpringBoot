package com.example.se1845.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {

    @NotNull(message = "notifyid is required")
    @NotBlank(message = "notifyid is required")
    private String notifyid;

    @NotNull(message = "title is required")
    @NotBlank(message = "title is required")
    private String title;

    @NotNull(message = "detail is required")
    @NotBlank(message = "detail is required")
    private String detail;

    @NotNull(message = "start is required")
    @NotBlank(message = "start is required")
    private String start;

    @NotNull(message = "end is required")
    @NotBlank(message = "end is required")
    private String end;

    private String ssn;
}
