package com.ahmetakkoyun.controller;

import com.ahmetakkoyun.repository.entity.Users;
import com.ahmetakkoyun.repository.ICrud;

import java.util.List;
import java.util.Optional;

public class UsersController implements ICrud<Users> {
    @Override
    public Users save(Users users) {
        return null;
    }

    @Override
    public Users update(Users users) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Optional<Users> findById(Long id) {
        return Optional.empty();
    }
}
