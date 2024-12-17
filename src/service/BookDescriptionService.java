package src.service;
import repository.BookDescriptionRepository;
import src.repository.*;
public class BookDescriptionService {
    private final BookDescriptionRepository bookDescriptionRepository;

    public BookDescriptionService(BookDescriptionRepository bookDescriptionRepository) {
        this.bookDescriptionRepository = bookDescriptionRepository;
    }
}
