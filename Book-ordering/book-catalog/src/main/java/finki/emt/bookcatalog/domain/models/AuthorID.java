package finki.emt.bookcatalog.domain.models;

import finki.emt.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class AuthorID extends DomainObjectId {
    protected AuthorID(@NonNull String uuid) {
        super(uuid);
    }
}
