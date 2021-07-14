package am.demo.product.service.event_listener;


import am.demo.product.dto.order.OrderCreatedEvent;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;


@Component
@AllArgsConstructor
public class OrderCreatedListener {

    private final Logger log = LoggerFactory.getLogger(OrderCreatedListener.class);

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onOrderCreated(final OrderCreatedEvent event) {
        log.info("Order has been created by " + event.getOwner());
    }
}