package finki.emt.ordermanagement.domain.models;

import finki.emt.ordermanagement.domain.valueObjects.Book;
import finki.emt.sharedkernel.domain.base.AbstractEntity;
import finki.emt.sharedkernel.domain.base.DomainObjectId;
import finki.emt.sharedkernel.domain.enums.Currency;
import finki.emt.sharedkernel.domain.globalValueObjects.Money;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_in_order")
@Getter
public class BookInOrder extends AbstractEntity<BookInOrderId> {

    private Money bookPrice;

    private Integer orderQuantity;

    @AttributeOverride(name = "Id", column = @Column(name = "order_book_id", nullable = false))
    private BookISBN bookISBN;

    public BookInOrder() {
        super(DomainObjectId.randomId(BookInOrderId.class));
    }

    public Money subtotal() {
        return bookPrice.multiply(orderQuantity);
    }

    public BookInOrder(BookISBN bookISBN, Money bookPrice, int orderQuantity) {
        super(DomainObjectId.randomId(BookInOrderId.class));
        this.bookISBN = bookISBN;
        this.bookPrice = bookPrice;
        this.orderQuantity = orderQuantity;
    }
}
