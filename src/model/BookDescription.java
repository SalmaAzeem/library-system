package src.model;

import java.util.Date;
import java.util.List;

public class BookDescription {
    private String summary;
    private String title,Author,genre,publisher;
    private Date publicationDate;
    private int ISBN,pages;
    private int ID;
    private List<String> TableOfContents;

    public BookDescription(String summary,String title, String genre,String publisher,int ISBN, int pages) {
        this.summary = summary;
        this.title=title;
        this.genre=genre;
        this.publisher=publisher;
        this.ISBN=ISBN;
        this.pages=pages;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
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

