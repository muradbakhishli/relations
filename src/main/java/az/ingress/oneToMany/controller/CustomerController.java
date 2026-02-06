package az.ingress.oneToMany.controller;

import az.ingress.oneToMany.entity.CustomerEntity;
import az.ingress.oneToMany.entity.OrderEntity;
import az.ingress.oneToMany.service.CustomerService;
import az.ingress.oneToMany.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/v1/one-to-many")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;


    @GetMapping("/{id}")
    public List<CustomerEntity> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void addCustomer(@RequestBody CustomerEntity customer) {
        customerService.addCustomer(customer);
    }

    @PostMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void addOrder(@PathVariable Long id, @RequestBody OrderEntity order) {
        orderService.addOrder(id, order);
    }

}
