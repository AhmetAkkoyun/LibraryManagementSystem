package com.ahmetakkoyun.controller;

import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Users;
import com.ahmetakkoyun.service.UsersService;

import java.util.List;
import java.util.Optional;

public class UsersController implements ICrud<Users> {

    private UsersService usersService;

    public UsersController() {
        this.usersService = new UsersService();
    }

    @Override
    public Users save(Users users) {
        return usersService.save(users);
    }

    @Override
    public Users update(Users users) {
        return usersService.update(users);
    }

    @Override
    public void deleteById(Long id) {
        usersService.deleteById(id);

    }

    @Override
    public List<Users> findAll() {
        return usersService.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersService.findById(id);
    }
}
