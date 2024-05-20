package finki.emt.bookcatalog.forms;

import finki.emt.sharedkernel.domain.globalValueObjects.Money;
import lombok.Data;

import java.util.Date;

@Data
public class BookForm {

    private String title;

    private String authorName;

    private String publisher;

    private Date publicationDate;

    private Money price;

    private int pages;

    private String genre;
}
