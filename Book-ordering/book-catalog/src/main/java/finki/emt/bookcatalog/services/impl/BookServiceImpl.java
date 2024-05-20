package finki.emt.bookcatalog.services.impl;

import finki.emt.bookcatalog.domain.models.Book;
import finki.emt.bookcatalog.domain.models.BookISBN;
import finki.emt.bookcatalog.domain.repository.BookRepository;
import finki.emt.bookcatalog.forms.BookForm;
import finki.emt.bookcatalog.services.BookService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findById(BookISBN isbn) throws Exception {
        return bookRepository.findById(isbn).orElseThrow(Exception::new);
    }

    @Override
    public Book createBook(BookForm form) {
        Book book = Book.create(form.getTitle(),form.getAuthorName(),form.getPublisher(),form.getPublicationDate(),form.getPrice(),form.getPages(),form.getGenre());
        bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(BookISBN bookISBN){
        bookRepository.deleteById(bookISBN);
    }
}
