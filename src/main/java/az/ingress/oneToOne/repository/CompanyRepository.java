package az.ingress.oneToOne.repository;


import az.ingress.oneToOne.entity.CompanyEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {

    @EntityGraph(attributePaths = "companyDetails")
    Optional<CompanyEntity> findById(Long id);
}
