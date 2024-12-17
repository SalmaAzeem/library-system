package src.model;
import src.model.Librarian;
import src.model.Book;
import src.model.User;
import src.model.BookDescription;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//Don't forget to have a creator class to initiate the Library
public class Library {
     private Librarian Clark;
     //This could be modified to have a BookList Class so deletion and insertion will be through
     private List<Book> Books;
     private List<User> Clients;
     public List<Book> search(String name)
     {
         List<Book> MatchedResults = new ArrayList<>();
         for (Book b: Books)
         {
            if(b.getDescription().getTitle().equalsIgnoreCase(name)) {
                MatchedResults.add(b);
            }
         }
         return MatchedResults;
     }
    public Boolean SearchByIsbn(int ISBN)
    {
        for (Book b: Books)
        {
            if(b.getDescription().getISBN()==ISBN) {
                return true;
            }
        }
        return false;
    }
    public boolean AddBook(String summary,String title, String genre,String publisher,int ISBN, int pages)
    {
        Book newBook=CreateBook(summary, title, genre, publisher, ISBN, pages);
        if(newBook != null) {
            Books.add(newBook);
            return true;
        }
        else {
            return false;
        }
    }
    //Should be modified to check that the current used is a librarian and not a normal user, Also which class should be responsible for creation
     public Book CreateBook(String summary,String title, String genre,String publisher,int ISBN, int pages)
     {
         if(!SearchByIsbn(ISBN)) {
             BookDescription newBookDescription = new BookDescription(summary, title, genre, publisher, ISBN, pages);
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
