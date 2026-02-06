package az.ingress.oneToMany.repository;

import az.ingress.oneToMany.entity.CustomerEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    @EntityGraph(attributePaths = "orders")
    List<CustomerEntity> findCustomersById(Long customerId);
}
