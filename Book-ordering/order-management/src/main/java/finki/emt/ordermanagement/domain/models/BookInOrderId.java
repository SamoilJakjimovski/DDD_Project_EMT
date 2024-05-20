package finki.emt.ordermanagement.domain.models;

import finki.emt.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class BookInOrderId extends DomainObjectId {
    protected BookInOrderId(@NonNull String uuid) {
        super(uuid);
    }
}
