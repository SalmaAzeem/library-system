package src.service;
import com.project.repository.BookDescriptionRepository;
import src.repository.*;
public class BookDescriptionService {
    private final BookDescriptionRepository bookDescriptionRepository;

    public BookDescriptionService(BookDescriptionRepository bookDescriptionRepository) {
        this.bookDescriptionRepository = bookDescriptionRepository;
    }
}
