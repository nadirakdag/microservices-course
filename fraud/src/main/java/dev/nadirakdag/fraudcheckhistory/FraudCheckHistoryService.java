package dev.nadirakdag.fraudcheckhistory;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckResponse isFraudulentCustomer(Integer customerId) {

        LocalDateTime checkDate = LocalDateTime.now();

        FraudCheckHistory history = FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(checkDate)
                .build();

        fraudCheckHistoryRepository.save(history);

        return new FraudCheckResponse(false, checkDate);
    }

}
