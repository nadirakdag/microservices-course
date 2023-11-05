package dev.nadirakdag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"dev.nadirakdag.notification", "dev.nadirakdag.amqp", "dev.nadirakdag.configuration","dev.nadirakdag.rabbitmq"})
public class NotificationApplication {
    public static void main(String[] args) {

        SpringApplication.run(NotificationApplication.class, args);
    }
}