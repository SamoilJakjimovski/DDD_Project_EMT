package finki.emt.ordermanagement.domain.models;

import finki.emt.ordermanagement.domain.enums.OrderState;
import finki.emt.ordermanagement.domain.valueObjects.Book;
import finki.emt.sharedkernel.domain.base.AbstractEntity;
import finki.emt.sharedkernel.domain.enums.Currency;
import finki.emt.sharedkernel.domain.globalValueObjects.Money;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "user_orders")
public class Order extends AbstractEntity<OrderId> {

    private Instant createdOn;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_currency")
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<BookInOrder> booksInOrder;

    public Money totalPrice(){
        return new Money(currency,booksInOrder.stream().mapToDouble(b -> b.subtotal().getAmount()).sum());
    }

    public BookInOrder addBookToOder(Book book, int quantity){
        BookInOrder item = new BookInOrder(book.getId(),book.getPrice(),quantity);
        booksInOrder.add(item);
        return item;
    }

    public void removeBookInOrder(BookInOrderId bookInOrderId){
        booksInOrder.removeIf(b -> b.getId().equals(bookInOrderId));
    }

    public Order() {
        super(OrderId.randomId(OrderId.class));
    }
    public Order(Instant now, Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.createdOn = now;
        this.currency = currency;
    }

}
