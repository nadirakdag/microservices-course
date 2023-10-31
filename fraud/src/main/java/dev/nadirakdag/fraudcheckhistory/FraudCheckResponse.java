package dev.nadirakdag.fraudcheckhistory;

import java.time.LocalDateTime;

public record FraudCheckResponse(Boolean isFraudster, LocalDateTime checkDate) {
}
