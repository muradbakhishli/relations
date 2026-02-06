package az.ingress.manyToMany.controller;

import az.ingress.manyToMany.entity.RoleEntity;
import az.ingress.manyToMany.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/v1/many-to-many/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("{userId}")
    @ResponseStatus(NO_CONTENT)
    public void addRole(@PathVariable Long userId, @RequestBody RoleEntity role) {
        roleService.addRole(userId, role);
    }
}
