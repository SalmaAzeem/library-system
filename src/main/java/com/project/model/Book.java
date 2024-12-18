package com.project.model;
public class Book
{
    private int Stock;
    private BookDescription Description;
    private boolean Available;
    public Book()
    {

    }
    public Book(BookDescription description) {
        Description = description;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public BookDescription getDescription() {
        return Description;
    }

    public void setDescription(BookDescription description) {
        Description = description;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }

}
