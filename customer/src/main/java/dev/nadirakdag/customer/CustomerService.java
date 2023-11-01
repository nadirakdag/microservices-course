package dev.nadirakdag.customer;

import dev.nadirakdag.amqp.RabbitMQMessageProducer;
import dev.nadirakdag.clients.fraud.FraudCheckResponse;
import dev.nadirakdag.clients.fraud.FraudClient;
import dev.nadirakdag.clients.notification.NotificationClient;
import dev.nadirakdag.clients.notification.NotificationRequest;
import dev.nadirakdag.config.CustomerConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer producer;
    private final CustomerConfig customerConfig;


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

        NotificationRequest notificationRequest = new NotificationRequest(customer.getId(), customer.getEmail(), "Your account created");
        producer.publish(notificationRequest, customerConfig.getInternalExchange(), customerConfig.getInternalNotificationRoutingKey());
    }
}
