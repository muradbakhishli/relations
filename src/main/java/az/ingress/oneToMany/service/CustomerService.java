package az.ingress.oneToMany.service;

import az.ingress.oneToMany.entity.CustomerEntity;
import az.ingress.oneToMany.entity.OrderEntity;
import az.ingress.oneToMany.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void addCustomer(CustomerEntity customer) {
        if (customer.getOrders() != null)
            customer.getOrders().forEach(order -> order.setCustomer(customer));
        customerRepository.save(customer);
    }


    public List<CustomerEntity> getCustomerById(Long customerId) {
        return customerRepository.findCustomersById(customerId);
    }


    public CustomerEntity getCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
