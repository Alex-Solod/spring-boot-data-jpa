package mate.academy.springbootdatajpa.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "books")
@SQLDelete(sql = "UPDATE books SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String isbn;

    private BigDecimal price;
    private String description;
    private String coverImage;

    @Column(nullable = false)
    private Boolean deleted = false;
}
