package com.ahmetakkoyun;

import com.ahmetakkoyun.controller.BookController;
import com.ahmetakkoyun.controller.BorrowController;
import com.ahmetakkoyun.controller.UsersController;
import com.ahmetakkoyun.repository.entity.Book;
import com.ahmetakkoyun.repository.entity.Borrow;
import com.ahmetakkoyun.repository.entity.Users;
import com.ahmetakkoyun.repository.enums.EStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LibraryManager {

    public void startBorrow(){
        Scanner scan = new Scanner(System.in);

        UsersController usersController = new UsersController();
        List<Users> userList = usersController.findAll();
        System.out.println("işlem yapmak istediğiniz kullanıcıyı seçiniz");
        IntStream.range(0, userList.size())
                .forEach(i -> System.out.println(i+1 + " - " + userList.get(i)));
        int chosenUserNumber = scan.nextInt();
        Users chosenUser = userList.get(chosenUserNumber-1);
        System.out.println("seçilen kullanıcı -> "+chosenUser.getUserInformation().getFirstName()+" "+chosenUser.getUserInformation().getLastName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BookController bookController = new BookController();
        List<Book> availableBookList = bookController.getBooksByStatus(EStatus.AVAILABLE);
        System.out.println("kiralamak istediğiniz kitap numarasını giriniz");
        IntStream.range(0, availableBookList.size())
                .forEach(i -> System.out.println(i+1 + " - " + availableBookList.get(i)));
        int chosenBookNumber = scan.nextInt();
        Book chosenBook = availableBookList.get(chosenBookNumber-1);
        System.out.println("seçilen kitap -> "+chosenBook.getTitle()+" - "+chosenBook.getAuthor().getFirstName()+" "+chosenBook.getAuthor().getLastName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(chosenBook.getTitle()+" isimli kitabı kaç gün kiralamak istiyorsunuz?");
        int borrowPeriod = scan.nextInt();

        Borrow borrow = Borrow.builder()
                .users(chosenUser)
                .book(chosenBook)
                .period(borrowPeriod)
                .build();

        System.out.println("işlem yapılıyor...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            BorrowController borrowController = new BorrowController();
            borrowController.save(borrow);

            chosenBook.setStatus(EStatus.UNAVAILABLE);
            bookController.update(chosenBook);

            System.out.println("KİRALAMA İŞLEMi BAŞARIYLA TAMAMLANDI");

        } catch (Exception e){
            System.out.println("İŞLEM TAMAMLANAMADI!!!");
            System.out.println("Lütfen sistem yöneticisine (Ahmet Akkoyun) Başvurunuz...");
        }
    }
}
