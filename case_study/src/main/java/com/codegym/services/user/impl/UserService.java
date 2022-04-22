package com.codegym.services.user.impl;

import com.codegym.model.employee.user.User;
import com.codegym.repository.user.IUserRepository;
import com.codegym.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
