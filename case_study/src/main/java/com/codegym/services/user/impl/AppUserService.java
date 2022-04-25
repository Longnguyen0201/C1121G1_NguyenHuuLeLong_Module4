package com.codegym.services.user.impl;


import com.codegym.model.employee.user.AppUser;
import com.codegym.repository.user.IAppUserRepository;
import com.codegym.services.user.IAppUserService;
//import com.codegym.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    private IAppUserRepository iAppUserRepository;
    @Override
    public void save(AppUser user) {
        iAppUserRepository.save(user);
    }
}
