package dev.nadirakdag.rabbitmq;

import dev.nadirakdag.clients.notification.NotificationRequest;
import dev.nadirakdag.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(NotificationRequest request) {
        log.info("consumed {} from queue", request);
        notificationService.sendNotification(request);
    }
}
