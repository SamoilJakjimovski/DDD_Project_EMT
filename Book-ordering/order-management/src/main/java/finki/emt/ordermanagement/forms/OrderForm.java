package finki.emt.ordermanagement.forms;

import finki.emt.sharedkernel.domain.enums.Currency;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderForm {

    @NotNull
    private Currency currency;

    @Valid
    @NotEmpty
    private List<BookInOrderForm> items = new ArrayList<>();

}
