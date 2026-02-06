package az.ingress.manyToMany.repository;

import az.ingress.manyToMany.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
