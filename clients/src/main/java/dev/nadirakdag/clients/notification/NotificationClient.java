package dev.nadirakdag.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notification", path = "api/v1/notifications")
public interface NotificationClient {
    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest request);
}
