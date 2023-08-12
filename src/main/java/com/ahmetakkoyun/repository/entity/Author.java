package com.ahmetakkoyun.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    // kitapları
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)  // ara tablo oluşturmadan iki tabloyu maplemek için.
                                                             // fetchtype lazy tasarruf için. sadece season içinde kayıt tutulur. season.close sonrası kayıt tutulmaz.

            // ara tablo özelliklerini vermek için kullanıyoruz.
//    @JoinTable(name = "yazar_kitap",
//    joinColumns = @JoinColumn(name = "kitap_id"),
//    inverseJoinColumns = @JoinColumn(name = "yazar_id")
//    )
            @ToString.Exclude
    List<Book> books;



}
