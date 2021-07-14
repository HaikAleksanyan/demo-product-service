package am.demo.product.controller;


import am.demo.product.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders/")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("{name}")
    public void createOrder(@PathVariable("name") String name) {
        orderService.createOrder(name);
    }
}
