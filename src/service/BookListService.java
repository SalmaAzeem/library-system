package src.service;
import src.repository.BookListRepository;
import src.model.Book;

public class BookListService {
    private final BookListRepository bookListRepository;

    public BookListService(BookListRepository bookListRepository) {
        this.bookListRepository = bookListRepository;
    }
    public Book SearchByTitle(Book book1)
    {
        for (Book book : BookListRepository) {
            if (book.getDescription().getTitle().equalsIgnoreCase(book1.getDescription().getTitle())) {
                return book;
            }
        }
        return new Book();
    }
}
