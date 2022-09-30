package fil.rouge.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import fil.rouge.model.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByName(String role);
}
