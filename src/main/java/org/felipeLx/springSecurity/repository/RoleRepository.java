package org.felipeLx.springSecurity.repository;

import org.felipeLx.springSecurity.model.Role;
import org.felipeLx.springSecurity.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);


}
