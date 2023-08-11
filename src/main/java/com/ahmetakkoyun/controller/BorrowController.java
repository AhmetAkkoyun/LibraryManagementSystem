package com.ahmetakkoyun.controller;

import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Borrow;
import com.ahmetakkoyun.service.BorrowService;

import java.util.List;
import java.util.Optional;

public class BorrowController implements ICrud<Borrow> {

    private BorrowService borrowService;

    public BorrowController() {
        this.borrowService = new BorrowService();
    }

    @Override
    public Borrow save(Borrow borrow) {
        borrowService.saveReturnDate(borrow);
        return borrowService.save(borrow);
    }

    @Override
    public Borrow update(Borrow borrow) {
        return borrowService.update(borrow);
    }

    @Override
    public void deleteById(Long id) {
        borrowService.deleteById(id);

    }

    @Override
    public List<Borrow> findAll() {
        return borrowService.findAll();
    }

    @Override
    public Optional<Borrow> findById(Long id) {
        return borrowService.findById(id);
    }


}
