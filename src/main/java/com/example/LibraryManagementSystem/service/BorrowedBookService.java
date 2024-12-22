package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.entity.Book;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BorrowedBookService {
    private  final List<Book> books = new ArrayList<Book>();
    public boolean Add(Book book)
    {
        books.add(book);
        return true;

    }
    public boolean Delete(Book book)
    {
        int idToRemove=book.getDescription().getISBN();
        return ( books.removeIf(b -> b.getDescription().getISBN() == idToRemove));
    }
    public Book SearchByTitle(String title)
    {
        for (Book book : books) {
            if (book.getDescription().getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    public List<Book> SearchByAuthor(String author)
    {
        List<Book> matchedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getDescription().getAuthor().equalsIgnoreCase(author)) {
                matchedBooks.add(book);
            }
        }
        return matchedBooks;
    }
    public void Update()
    {

    }
    public List<List<Book>> Categorize()
    {
        //Find the categories first
        Map<String, List<Book>> categorizedBooks = books.stream()
                .collect(Collectors.groupingBy(book -> book.getDescription().getGenre()));
        return (List<List<Book>>) categorizedBooks;
    }
}
