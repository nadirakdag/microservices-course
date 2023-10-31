package dev.nadirakdag.customer;

import dev.nadirakdag.clients.fraud.FraudCheckResponse;
import dev.nadirakdag.clients.fraud.FraudClient;
import dev.nadirakdag.clients.notification.NotificationClient;
import dev.nadirakdag.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;


    public void registerCustomer(CustomerRequestModel requestModel){
        Customer customer = Customer.builder()
                .firstName(requestModel.firstName())
                .lastName(requestModel.lastName())
                .email(requestModel.email())
                .build();

        // todo: check if email valid
        // todo: check if email not taken
        // todo: check if fraudster

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());

        if (response != null && response.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        notificationClient.sendNotification(new NotificationRequest(customer.getId(), customer.getEmail(), "Your account created"));
    }
}
