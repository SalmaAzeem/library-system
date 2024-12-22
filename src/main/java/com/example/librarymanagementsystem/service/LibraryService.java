package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.dto.BookDescriptionDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.entity.Librarian;
import com.example.librarymanagementsystem.model.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

//Don't forget to have a creator class to initiate the Library
public class LibraryService {
    Librarian Clark;
    //This could be modified to have a BookList Class so deletion and insertion will be through
    ArrayList<Book> Books;
    ArrayList<User> Clients;
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
    public Boolean SearchByIsbn(int ISBN)
    {
        for (Book b: Books)
        {
            if(b.getDescription().getISBN()==ISBN)
                return true;
        }
        return false;
    }
    public boolean AddBook(String summary, String title, String genre, String publisher, String Author, LocalDate publicationDate, int ISBN, int pages)
    {
        Book newBook=CreateBook(summary, title, genre, publisher,Author, publicationDate, ISBN, pages);
        if(newBook != null) {
            Books.add(newBook);
            return true;
        }
        else return false;
    }
    //Should be modified to check that the current used is a librarian and not a normal user, Also which class should be responsible for creation
    public Book CreateBook(String summary, String title, String genre, String publisher, String Author, LocalDate publicationDate, int ISBN, int pages)
    {
        if(!SearchByIsbn(ISBN)) {
            BookDescriptionDTO newBookDescription = new BookDescriptionDTO(ISBN, summary, title, genre, publisher,Author, publicationDate, pages);
            Book newBook = new Book();
            newBook.setDescription(newBookDescription);
            return newBook;
        }
        else
        {
            return null;
        }
    }
}
