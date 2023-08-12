package com.ahmetakkoyun.service;

import com.ahmetakkoyun.repository.BorrowRepository;
import com.ahmetakkoyun.repository.entity.Users;
import com.ahmetakkoyun.utility.ICrud;
import com.ahmetakkoyun.repository.entity.Borrow;

import java.util.List;
import java.util.Optional;

public class BorrowService implements ICrud<Borrow> {

    private BorrowRepository borrowRepository;

    public BorrowService() {
        this.borrowRepository = new BorrowRepository();
    }

    @Override
    public Borrow save(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    @Override
    public Borrow update(Borrow borrow) {
        saveReturnDate(borrow);
        return borrowRepository.update(borrow);
    }

    @Override
    public void deleteById(Long id) {
        borrowRepository.deleteById(id);

    }

    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public Optional<Borrow> findById(Long id) {
        return borrowRepository.findById(id);
    }

    public void saveReturnDate(Borrow borrow) {
        borrow.setReturnDate(borrow.getBorrowDate().plusDays(borrow.getPeriod()));
    }

    public List<Borrow> findByUserId(Long userId) {
        return borrowRepository.findByUserId(userId);
    }

    public List<Users> findBorrowedUsersByBookId(Long bookId){
        return borrowRepository.findBorrowedUsersByBookId(bookId);
    }
}