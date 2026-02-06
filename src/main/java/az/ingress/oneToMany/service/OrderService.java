package az.ingress.oneToMany.service;

import az.ingress.oneToMany.entity.OrderEntity;
import az.ingress.oneToMany.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;

    public void addOrder(Long customerId, OrderEntity order) {
        var customer = customerService.getCustomer(customerId);
        order.setCustomer(customer);
        orderRepository.save(order);
    }
}
