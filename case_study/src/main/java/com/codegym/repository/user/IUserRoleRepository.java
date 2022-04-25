package com.codegym.repository.user;

import com.codegym.model.employee.user.AppUser;
import com.codegym.model.employee.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole> findByAppUser(AppUser appUser);
}
