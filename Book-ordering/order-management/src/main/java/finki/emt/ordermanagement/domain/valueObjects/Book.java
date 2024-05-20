package finki.emt.ordermanagement.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import finki.emt.ordermanagement.domain.models.BookISBN;
import finki.emt.sharedkernel.domain.enums.Currency;
import finki.emt.sharedkernel.domain.globalValueObjects.Money;
import lombok.Getter;

@Getter
public class Book{

    private final BookISBN id;

    private final String title;

    private final Money price;

    private Book(){
        this.id = BookISBN.randomId(BookISBN.class);
        this.title = "";
        this.price = Money.valueOf(Currency.EUR,0);

    }

    @JsonCreator
    public Book(BookISBN id, String title, Money price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}
