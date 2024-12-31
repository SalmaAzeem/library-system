package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.dto.LibraryDTO;
import com.example.librarymanagementsystem.model.dto.UserDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.entity.Library;
import com.example.librarymanagementsystem.model.repository.LibraryRepo;
import com.example.librarymanagementsystem.model.dto.BookDescriptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

//Don't forget to have a creator class to initiate the Library
@Service
public class LibraryService {
    @Autowired
    private LibraryRepo libraryRepo;
    private BookService bookService;
    private BookDescriptionService bookDescriptionService;

    public List<LibraryDTO> getAllLibraries() {
        return this.libraryRepo.findAll()
                .stream()
                .map(library -> new LibraryDTO(
                        library.getID(),
                        library.getName(),
                        library.getLocation()
                ))
                .collect(Collectors.toList());
    }

    public List<BookDescriptionDTO> search(String name)
    {
       return bookDescriptionService.searchBooksByTitle(name);
    }
    public BookDTO searchByIsbn(String ISBN)
    {
       return bookService.getBookByISBN(ISBN);
    }
    public List<BookDescriptionDTO> seacrhByAuthor(String author)
    {
        return bookDescriptionService.searchBooksByAuthor(author);
    }
    //Should be modified to check that the current used is a librarian and not a normal user, Also which class should be responsible for creation
    public BookDTO createBook(int stock,String summary, String title, String genre, String publisher, String author, LocalDate publicationDate, String ISBN, int pages,List<String> tableOfContents, boolean availability)
    {
        //should validate that the book with that ISBN is not available in the database
        if(bookService.getBookByISBN(ISBN)!= null)
        {
            BookDescriptionDTO bookDescriptionDTO = new BookDescriptionDTO(ISBN,summary, title,genre,publisher,author,publicationDate,pages,tableOfContents);
            bookDescriptionService.saveBookDescription(bookDescriptionDTO);
            BookDTO bookDTO = new BookDTO(stock,bookDescriptionDTO,availability,ISBN) ;
            return bookService.saveOrUpdateBook(bookDTO);
        }
        else
        {
            return null;
        }
    }

    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    public List<Map<String, Object>> getBooksWithDescriptions() {
        return bookService.getBookAndDescription();
    }

    public Map<String, Object> getBookDetailsByISBN(String ISBN) {
        return bookService.getBookAndDescriptionByISBN(ISBN);
    }

    public BookDTO saveOrUpdateBook(BookDTO bookDTO) {
        return bookService.saveOrUpdateBook(bookDTO);
    }

    public void deleteBook(String ISBN) {
        bookService.deleteBook(ISBN);
    }

    public BookDTO updateBookStock(String ISBN, int newStock) {
        return bookService.updateStock(ISBN, newStock);
    }

    public List<BookDTO> getAnyNBooks(int n) {
        return bookService.getAny7Books(n);
    }
    /*public List<BookDTO> getBooksByGenre(@RequestParam String genre) {
        List<BookDTO> books = bookService.categorize(genre);
        if (books.isEmpty()) {
            return null;
        }
        return books;
    }*/
}
