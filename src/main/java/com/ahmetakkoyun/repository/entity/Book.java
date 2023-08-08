package com.ahmetakkoyun.repository.entity;

import com.ahmetakkoyun.repository.enums.EBookType;
import com.ahmetakkoyun.repository.enums.EStatus;
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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private EBookType bookType;

    @Enumerated(EnumType.STRING)
    @Builder.Default                      // başlangıç değeri available
    private EStatus eStatus = EStatus.AVAILABLE;

    private int pageCount;

    @ManyToOne
    private Author author;

}
