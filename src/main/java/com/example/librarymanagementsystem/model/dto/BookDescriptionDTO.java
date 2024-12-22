package com.example.librarymanagementsystem.model.dto;

import java.time.LocalDate;

/**
 * A DTO Class for the Book Description.
 */

public class BookDescriptionDTO {
    private String summary, title, genre, publisher, Author;
    private Integer ISBN, pages;
    private LocalDate publicationDate;
    public BookDescriptionDTO(Integer ISBN, String summary,String title, String genre,String publisher, String Author, LocalDate publicationDate, Integer pages) {
        this.summary = summary;
        this.title=title;
        this.genre=genre;
        this.publisher=publisher;
        this.ISBN=ISBN;
        this.pages=pages;
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
    public Integer getISBN() {
        return ISBN;
    }
    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }
    public Integer getPages() {
        return pages;
    }
    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
