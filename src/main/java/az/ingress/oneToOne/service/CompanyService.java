package az.ingress.oneToOne.service;

import az.ingress.oneToOne.entity.CompanyEntity;
import az.ingress.oneToOne.repository.CompanyDetailsRepository;
import az.ingress.oneToOne.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyDetailsRepository companyDetailsRepository;

    public void addCompany(CompanyEntity company) {
        if (company.getCompanyDetails() != null)
            company.getCompanyDetails().setCompany(company);
        companyRepository.save(company);
    }

    public CompanyEntity getCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }
}
