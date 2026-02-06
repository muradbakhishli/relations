package az.ingress.manyToMany.repository;

import az.ingress.manyToMany.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Override
    @EntityGraph(attributePaths = {"roles"})
    Optional<UserEntity> findById(Long id);
}
