package finki.emt.bookcatalog.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class FullName {

    private final String firstName;

    private final String lastName;

    public FullName(String fullName) {
        this.firstName = fullName.split(" ")[0];
        this.lastName = fullName.split(" ")[1];
    }

    protected FullName() {
        this.firstName = "";
        this.lastName = "";
    }
}
