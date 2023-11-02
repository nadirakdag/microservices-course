package dev.nadirakdag.clients.notification;

public record NotificationRequest (Integer toCustomerId, String toCustomerEMail, String message) {
}
