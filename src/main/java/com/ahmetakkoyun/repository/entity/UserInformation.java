package com.ahmetakkoyun.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String about;

    @OneToOne(cascade = CascadeType.ALL)  //adres olmadan info oluşturabilmek için. (id yok hatası vermeyecek id atayacak)
    @JoinColumn(unique = true)
    private Address address;



}
