package com.example.librarymanagementsystem.model.dto;

import com.example.librarymanagementsystem.model.entity.BookDescription;

import java.time.LocalDate;
import java.util.List;

/**
 * A DTO Class for the Book Description.
 */

public class BookDescriptionDTO {
    private String summary, title, genre, publisher, Author, ISBN;
    private int pages;
    private LocalDate publicationDate;
    private List<String> TableOfContents;
    public BookDescriptionDTO(String ISBN, String summary, String title, String genre, String publisher, String Author, LocalDate publicationDate, int pages, List<String> TableOfContents) {
        this.summary = summary;
        this.title=title;
        this.Author=Author;
        this.publicationDate = publicationDate;
        this.genre=genre;
        this.publisher=publisher;
        this.ISBN=ISBN;
        this.pages=pages;
        this.TableOfContents = TableOfContents;
    }
    public BookDescriptionDTO(String ISBN, String summary, String title, String genre, String publisher, String Author, LocalDate publicationDate, int pages) {
        this.summary = summary;
        this.title=title;
        this.genre=genre;
        this.publisher=publisher;
        this.ISBN=ISBN;
        this.pages=pages;
    }

    public static BookDescriptionDTO toDto(BookDescription entity) {
        return new BookDescriptionDTO(entity.getISBN(), entity.getSummary(), entity.getTitle(),
                entity.getGenre(), entity.getPublisher(), entity.getAuthor(), entity.getPublicationDate(),
                entity.getPages(), entity.getTableOfContents());
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public List<String> getTableOfContents() {
        return TableOfContents;
    }
    public void setTableOfContents(List<String> tableOfContents) {
        TableOfContents = tableOfContents;
    }
}
