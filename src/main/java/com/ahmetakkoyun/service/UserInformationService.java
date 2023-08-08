package com.ahmetakkoyun.service;

import com.ahmetakkoyun.repository.UserInformationRepository;
import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.UserInformation;

import java.util.List;
import java.util.Optional;

public class UserInformationService implements ICrud<UserInformation> {

    private UserInformationRepository UserInformationRepository;

    public UserInformationService() {
        this.UserInformationRepository = new UserInformationRepository();
    }

    @Override
    public UserInformation save(UserInformation UserInformation) {
        return UserInformationRepository.save(UserInformation);
    }

    @Override
    public UserInformation update(UserInformation UserInformation) {
        return UserInformationRepository.update(UserInformation);
    }

    @Override
    public void deleteById(Long id) {
        UserInformationRepository.deleteById(id);

    }

    @Override
    public List<UserInformation> findAll() {
        return UserInformationRepository.findAll();
    }

    @Override
    public Optional<UserInformation> findById(Long id) {
        return UserInformationRepository.findById(id);
    }
}