package finki.emt.sharedkernel.domain.base;

import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@MappedSuperclass
@Getter
public class DomainObjectId implements Serializable {

    private String Id;

}
