package com.ninos.repository.security;

import com.ninos.model.security.Role;
import com.ninos.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findRoleByRoleName(String roleName);
}
