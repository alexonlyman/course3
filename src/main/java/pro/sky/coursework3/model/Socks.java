package pro.sky.coursework3.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Socks {
    @NotNull(message = "цвета - YELLOW, BLUE, RED, WHITE, GREED, BLACK")
    private Colour colour;
    @Range(min = 0, max = 100, message = "Содержание хлопка")
    private Integer CottonComposition;
    @Positive
    @Getter
    private Integer quantity;
    @Getter
    @NotNull(message = "размеры  S, M, L")
    private Size size;

    public Socks(Colour colour, Size size, Integer cottonComposition) {
    }
}
