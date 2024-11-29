package src;

public class Book
{
    int Stock;
    BookDescription Description;
    boolean Available;
    public Book()
    {
        Description.setAuthor("Unknown");
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
