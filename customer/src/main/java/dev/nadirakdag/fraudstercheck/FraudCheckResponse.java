package dev.nadirakdag.fraudstercheck;

import java.time.LocalDateTime;

public record FraudCheckResponse(Boolean isFraudster, LocalDateTime checkDate) {
}
