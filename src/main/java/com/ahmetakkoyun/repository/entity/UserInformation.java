package com.ahmetakkoyun.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  //cascade adres olmadan info oluşturabilmek için. (id yok hatası vermeyecek id atayacak)
    @ToString.Exclude
    private Set<Address> address;



}
