package com.ahmetakkoyun;

import com.ahmetakkoyun.repository.AddressRepository;
import com.ahmetakkoyun.repository.UserInformationRepository;
import com.ahmetakkoyun.repository.UsersRepository;
import com.ahmetakkoyun.repository.entity.Address;
import com.ahmetakkoyun.repository.entity.UserInformation;
import com.ahmetakkoyun.repository.entity.Users;

public class Main {
    public static void main(String[] args) {

        UsersRepository userRepository = new UsersRepository();
        UserInformationRepository userInformationRepository = new UserInformationRepository();
        AddressRepository addressRepository = new AddressRepository();

        Address address = Address.builder()
                .city("Ankara")
                .country("Türkiye")
                .build();
        addressRepository.save(address);


        UserInformation userInformation = UserInformation.builder()
                .firstName("Ahmet")
                .lastName("Akkoyun")
                .address(address)
                .build();
        userInformationRepository.save(userInformation);

        Users user = Users.builder()
                .username("Ahmet")
                .password("123")
                .userInformation(userInformation)
                .build();

        userRepository.save(user);

//        Users user2 = Users.builder()
//                .password("456")
//                .username("ahmet")
//                .userInformation(userInformation)
//                .build();
//        userRepository.save(user2);

    }




}