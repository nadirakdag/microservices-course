package dev.nadirakdag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"dev.nadirakdag.customer", "dev.nadirakdag.amqp", "dev.nadirakdag.config"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "dev.nadirakdag.clients")
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}