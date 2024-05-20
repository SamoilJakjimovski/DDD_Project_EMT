package finki.emt.bookcatalog.domain.repository;

import finki.emt.bookcatalog.domain.models.Book;
import finki.emt.bookcatalog.domain.models.BookISBN;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, BookISBN> {
}
