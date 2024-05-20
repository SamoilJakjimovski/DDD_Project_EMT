package finki.emt.ordermanagement.domain.models;

import finki.emt.sharedkernel.domain.base.DomainObjectId;
import jakarta.persistence.Embeddable;
import lombok.NonNull;

@Embeddable
public class BookISBN extends DomainObjectId {
    public BookISBN(@NonNull String uuid) {
        super(uuid);
    }

    public BookISBN()
    {
        super(BookISBN.randomId(BookISBN.class).getId());
    }
}
