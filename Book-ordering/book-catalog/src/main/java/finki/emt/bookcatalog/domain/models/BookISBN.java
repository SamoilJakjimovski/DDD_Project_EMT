package finki.emt.bookcatalog.domain.models;

import finki.emt.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class BookISBN extends DomainObjectId {
    protected BookISBN(@NonNull String uuid) {
        super(uuid);
    }
}
