package dev.nadirakdag.clients.fraud;

import java.time.LocalDateTime;

public record FraudCheckResponse(Boolean isFraudster, LocalDateTime checkDate) {
}
