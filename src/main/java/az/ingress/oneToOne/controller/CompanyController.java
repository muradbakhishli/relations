package az.ingress.oneToOne.controller;

import az.ingress.oneToOne.entity.CompanyEntity;
import az.ingress.oneToOne.service.CompanyService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/one-to-one")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void addCompany(@RequestBody CompanyEntity company) {
        companyService.addCompany(company);
    }

    @GetMapping("/{id}")
    public CompanyEntity getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCompanyById(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
    }
}
