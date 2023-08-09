package com.ahmetakkoyun;

import com.ahmetakkoyun.repository.AddressRepository;
import com.ahmetakkoyun.repository.UserInformationRepository;
import com.ahmetakkoyun.repository.UsersRepository;
import com.ahmetakkoyun.repository.entity.Address;
import com.ahmetakkoyun.repository.entity.UserInformation;
import com.ahmetakkoyun.repository.entity.Users;

public class MainWithCascade {
    public static void main(String[] args) {

        UsersRepository userRepository = new UsersRepository();

//        Users user = Users.builder()
//                .username("Ahmet")
//                .password("123")
//                .userInformation(UserInformation.builder()
//                        .firstName("Ahmet")
//                        .lastName("Akkoyun")
//                        .address(Address.builder()
//                                .city("Ankara")
//                                .country("Türkiye")
//                                .build()
//                        )
//                        .build()
//                )
//                .build();
//
//        userRepository.save(user);


    }

}