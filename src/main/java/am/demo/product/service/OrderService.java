package am.demo.product.service;

import am.demo.product.dto.order.OrderCreatedEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class OrderService {

    private final ApplicationEventPublisher publisher;

    @Transactional
    public void createOrder(String owner) {
        publisher.publishEvent(new OrderCreatedEvent(owner));
    }
}