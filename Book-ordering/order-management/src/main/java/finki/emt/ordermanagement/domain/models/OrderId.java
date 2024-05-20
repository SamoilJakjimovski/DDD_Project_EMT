package finki.emt.ordermanagement.domain.models;

import finki.emt.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class OrderId extends DomainObjectId {
    protected OrderId(@NonNull String uuid) {
        super(uuid);
    }
}
