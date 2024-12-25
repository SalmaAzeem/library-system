package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.repository.BookRepo;
import com.example.librarymanagementsystem.model.repository.LibraryRepo;
import com.example.librarymanagementsystem.model.dto.BookDescriptionDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

//Don't forget to have a creator class to initiate the Library
@Service
public class LibraryService {
    private final LibraryRepo libraryRepo;
    private final BookRepo bookRepo;

    public LibraryService(LibraryRepo libraryRepo, BookRepo bookRepo) {
        this.libraryRepo = libraryRepo;
        this.bookRepo = bookRepo;
    }

    //This could be modified to have a BookList Class so deletion and insertion will be through
    ArrayList<Book> Books;
    public List<Book> Search(String name)
    {

        ArrayList<Book> MatchedResults = new ArrayList<>();
        for (Book b: Books)
        {
            if(b.getDescription().getTitle().equalsIgnoreCase(name))
                MatchedResults.add(b);
        }
        return MatchedResults;
    }
    /*public Boolean SearchByIsbn(String ISBN)
    {
        for (Book b: Books)
        {
            if(b.getDescription().getISBN().equals(ISBN))
                return true;
        }
        return false;
    }*/
    /*public BookDTO FindById(int ID)
    {
        Book book =libraryRepo.findById(ID);
        if(book.isPresent())
            return BookDTO.toDto(book.get());
        return null;
    }*/
    //Should be modified to check that the current used is a librarian and not a normal user, Also which class should be responsible for creation
    @PostMapping
    public BookDTO CreateBook(String summary, String title, String genre, String publisher, String author, LocalDate publicationDate, String ISBN, int pages,List<String> tableOfContents)
    {
        //should validate that the book with that ISBN is not available in the database
        //if(!SearchByIsbn(ISBN)) {
            BookDescriptionDTO newBookDescription = new BookDescriptionDTO(ISBN, summary, title, genre, publisher,author, publicationDate, pages,tableOfContents);
            Book newBook = new Book();
            newBook.setDescription(newBookDescription);
        Book book1 = this.bookRepo.save(newBook);
        return BookDTO.toDto(book1);
    }
    @DeleteMapping("id/ {id}")
    public void DeleteBook(int id)
    {
        this.bookRepo.deleteById(id);
    }
}
