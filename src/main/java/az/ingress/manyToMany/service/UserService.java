package az.ingress.manyToMany.service;

import az.ingress.manyToMany.entity.UserEntity;
import az.ingress.manyToMany.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void addUser(UserEntity user) {
        var role = user.getRoles();
        user.setRoles(role);
        userRepository.save(user);
    }

    public UserEntity findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }
}
