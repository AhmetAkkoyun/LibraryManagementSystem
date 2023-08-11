package com.ahmetakkoyun.repository.entity;

import com.ahmetakkoyun.repository.enums.EBookType;
import com.ahmetakkoyun.repository.enums.EStatus;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@NamedQueries(
        {
         @NamedQuery(name="findByBookType", query = "SELECT b FROM Book AS b WHERE b.bookType=:x"),
         @NamedQuery(name = "findById", query = "SELECT b FROM Book AS b WHERE b.id=:x")
        }
)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private EBookType bookType;

    @Enumerated(EnumType.STRING)
    @Builder.Default                      // başlangıç değeri available
    private EStatus status = EStatus.AVAILABLE;

    private int pageCount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    @ToString.Exclude
    private Author author;

}
