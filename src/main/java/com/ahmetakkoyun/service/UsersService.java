package com.ahmetakkoyun.service;

import com.ahmetakkoyun.repository.UsersRepository;
import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Users;

import java.util.List;
import java.util.Optional;

public class UsersService implements ICrud<Users> {

    private UsersRepository usersRepository;

    public UsersService() {
        this.usersRepository = new UsersRepository();
    }

    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users update(Users users) {
        return usersRepository.update(users);
    }

    @Override
    public void deleteById(Long id) {
        usersRepository.deleteById(id);

    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }
}