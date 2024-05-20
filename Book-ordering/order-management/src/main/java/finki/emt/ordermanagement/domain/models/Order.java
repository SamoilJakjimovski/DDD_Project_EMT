package finki.emt.ordermanagement.domain.models;

import finki.emt.ordermanagement.domain.enums.OrderState;
import finki.emt.sharedkernel.domain.base.AbstractEntity;
import finki.emt.sharedkernel.domain.globalValueObjects.Money;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "user_orders")
public class Order extends AbstractEntity<OrderId> {

    private Instant createdOn;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    private Money totalPrice;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<BookInOrder> booksInOrder;
}
