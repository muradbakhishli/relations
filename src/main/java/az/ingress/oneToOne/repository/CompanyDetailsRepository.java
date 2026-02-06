package az.ingress.oneToOne.repository;

import az.ingress.oneToOne.entity.CompanyDetailsEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompanyDetailsRepository extends CrudRepository<CompanyDetailsEntity, Long> {
}
