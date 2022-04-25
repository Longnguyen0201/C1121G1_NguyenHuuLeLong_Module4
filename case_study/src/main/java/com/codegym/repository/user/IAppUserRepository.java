package com.codegym.repository.user;


import com.codegym.model.employee.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUserName(String username);
}
