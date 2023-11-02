package dev.nadirakdag.notification;

import dev.nadirakdag.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRespository notificationRepository;

    public void sendNotification(NotificationRequest request){
        Notification notification = Notification.builder()
                .message(request.message())
                .sender("System")
                .sentAt(LocalDateTime.now())
                .toCustomerEMail(request.toCustomerEMail())
                .toCustomerId(request.toCustomerId())
                .build();

        notificationRepository.save(notification);
    }

}
