package finki.emt.ordermanagement.forms;

import finki.emt.ordermanagement.domain.valueObjects.Book;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class BookInOrderForm {

    @NotNull
    private Book book;

    @Min(1)
    private int quantity = 1;
}
