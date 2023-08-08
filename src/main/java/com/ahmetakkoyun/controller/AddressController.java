package com.ahmetakkoyun.controller;

import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Address;
import com.ahmetakkoyun.service.AddressService;

import java.util.List;
import java.util.Optional;

public class AddressController implements ICrud<Address> {

    private AddressService addressService;

    public AddressController() {
        this.addressService = new AddressService();
    }

    @Override
    public Address save(Address address) {
        return addressService.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressService.update(address);
    }

    @Override
    public void deleteById(Long id) {
        addressService.deleteById(id);

    }

    @Override
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressService.findById(id);
    }
}
