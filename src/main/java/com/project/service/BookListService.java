package src.service;
import src.repository.BookListRepository;

public class BookListService {
    private final BookListRepository bookListRepository;

    public BookListService(BookListRepository bookListRepository) {
        this.bookListRepository = bookListRepository;
    }
    public Book SearchByTitle(Book book)
    {
        for (Book book : BookListRepository) {
            if (book.getDescription().getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
