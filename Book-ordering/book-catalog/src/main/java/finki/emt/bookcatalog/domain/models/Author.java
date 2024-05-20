package finki.emt.bookcatalog.domain.models;

import finki.emt.bookcatalog.domain.valueObjects.FullName;
import finki.emt.sharedkernel.domain.base.AbstractEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author extends AbstractEntity<AuthorID> {

    private FullName fullName;

    public Author(String fullName) {
        super(AuthorID.randomId(AuthorID.class));
        this.fullName = new FullName(fullName);
    }

    protected Author() {
        super(AuthorID.randomId(AuthorID.class));
    }
}
