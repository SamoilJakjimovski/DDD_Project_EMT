package finki.emt.ordermanagement.domain.models;

import finki.emt.sharedkernel.domain.base.AbstractEntity;
import finki.emt.sharedkernel.domain.globalValueObjects.Money;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_in_order")
public class BookInOrder extends AbstractEntity<BookInOrderId> {

    private Money bookPrice;

    private Integer orderQuantity;

    @AttributeOverride(name = "Id", column = @Column(name = "order_book_id", nullable = false))
    private BookId bookId;
}
