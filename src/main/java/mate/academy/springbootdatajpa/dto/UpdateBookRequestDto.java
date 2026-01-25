package mate.academy.springbootdatajpa.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class UpdateBookRequestDto {
    private String author;
    private String title;
    private BigDecimal price;
    private String description;
    private String coverImage;
    private String isbn;
}
