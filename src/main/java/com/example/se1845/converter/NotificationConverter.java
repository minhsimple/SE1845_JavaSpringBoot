package com.example.se1845.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.se1845.dto.NotificationDTO;
import com.example.se1845.model.Notification;

@Component
public class NotificationConverter {
    private ModelMapper modelMapper;

    public NotificationConverter() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(Notification.class, NotificationDTO.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getEmployee().getSsn(), NotificationDTO::setSsn);
                });

        modelMapper.typeMap(NotificationDTO.class, Notification.class)
                .addMappings(mapper -> {
                    mapper.<String>map(NotificationDTO::getSsn, (dest, value) -> dest.getEmployee().setSsn(value));
                });
    }

    public Notification toNotification(NotificationDTO notificationDto) {
        return modelMapper.map(notificationDto, Notification.class);
    }

    public NotificationDTO toNotificationDTO(Notification notification) {
        return modelMapper.map(notification, NotificationDTO.class);
    }

}
