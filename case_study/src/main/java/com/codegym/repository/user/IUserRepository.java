package com.codegym.repository.user;

import com.codegym.model.employee.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
