package az.ingress.oneToMany.repository;

import az.ingress.oneToMany.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
