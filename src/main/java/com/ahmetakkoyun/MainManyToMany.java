package com.ahmetakkoyun;

import com.ahmetakkoyun.controller.AddressController;
import com.ahmetakkoyun.controller.UserInformationController;
import com.ahmetakkoyun.repository.entity.Address;
import com.ahmetakkoyun.repository.entity.UserInformation;

import java.util.HashSet;
import java.util.Set;

public class MainManyToMany {

    public static void main(String[] args) throws InterruptedException {

        UserInformationController userInformationController = new UserInformationController();
        AddressController addressController = new AddressController();

        Address address1 = Address.builder()
                .city("Ankara")
                .build();

        Address address2 = Address.builder()
                .city("İstanbul")
                .build();

        UserInformation userInformation1 = UserInformation.builder()
                .firstName("Mustafa")
                .address(Set.of(address1, address2))
                .build();

        UserInformation userInformation2 = UserInformation.builder()
                .firstName("Kemal")
                .address(Set.of(address1,address2))
                .build();

//        address1.getUserInformations().add(userInformation1);
//        address1.getUserInformations().add(userInformation2);
//        address2.getUserInformations().add(userInformation1);
//        address2.getUserInformations().add(userInformation2);

        userInformationController.save(userInformation1);
        userInformationController.save(userInformation2);

        Thread.sleep(2000);

        userInformationController.findAll().forEach(System.out::println);




    }

}
