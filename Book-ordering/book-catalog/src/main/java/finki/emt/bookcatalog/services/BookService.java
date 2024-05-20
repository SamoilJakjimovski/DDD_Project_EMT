package finki.emt.bookcatalog.services;

import finki.emt.bookcatalog.domain.models.Book;
import finki.emt.bookcatalog.domain.models.BookISBN;
import finki.emt.bookcatalog.forms.BookForm;

import java.util.List;

public interface BookService {

    Book findById(BookISBN isbn) throws Exception;
    Book createBook (BookForm form);
    List<Book> getAll();
    void deleteBook(BookISBN bookISBN) throws Exception;
}
