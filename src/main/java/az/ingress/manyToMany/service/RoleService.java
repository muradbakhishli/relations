package az.ingress.manyToMany.service;

import az.ingress.manyToMany.entity.RoleEntity;
import az.ingress.manyToMany.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final UserService userService;

    @Transactional
    public void addRole(Long userId, RoleEntity roleEntity) {
        var user = userService.findUserById(userId);
        user.getRoles().add(roleEntity);
    }
}
