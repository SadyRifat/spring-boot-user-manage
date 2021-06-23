package com.user.manage.repository;

import com.user.manage.entity.Role;
import com.user.manage.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role, String> {
    @Query("select role from Role role where role.name=:roleName")
    Role getRoleByName(ERole roleName);
}
