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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)    // info olmadan user oluşturabilmek için (id yok hatası vermeyecek id atayacak)
    @JoinColumn(unique = true, nullable = false, name="ui_id")     // birden fazla user için tek userinformation olamasın diye.
    private UserInformation userInformation;


}
