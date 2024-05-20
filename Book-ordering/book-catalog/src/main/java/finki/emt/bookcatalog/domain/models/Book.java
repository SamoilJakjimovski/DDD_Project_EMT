package finki.emt.bookcatalog.domain.models;

import finki.emt.sharedkernel.domain.base.AbstractEntity;
import finki.emt.sharedkernel.domain.globalValueObjects.Money;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "book")
public class Book extends AbstractEntity<BookISBN> {

    private String title;

    @ManyToOne
    private Author author;

    private String publisher;

    private Date publicationDate;

    private Money price;

    private Integer pages;

    private String genre;

    protected Book(){
        super(BookISBN.randomId(BookISBN.class));
    }

    public static Book create(String title, String authorName,String publisher,Date publicationDate,Money price,int pages,String genre)
    {
        Book book = new Book();
        book.title = title;
        book.author = new Author(authorName);
        book.publicationDate = publicationDate;
        book.publisher = publisher;
        book.price = price;
        book.pages = pages;
        book.genre = genre;
        return book;
    }
}


