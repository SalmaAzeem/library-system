package com.example.librarymanagementsystem.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Table(name="book_description")
@Entity
public class BookDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ISBN;
    @Column(name="summary")
    private String summary;
    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="genre")
    private String genre;
    @Column(name="publisher")
    private String publisher;
    @Column(name="publication_date")
    private LocalDate publicationDate;
    @Column(name="pages")
    private int pages;

    private List<String> TableOfContents;
    public BookDescription() {}

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
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
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

