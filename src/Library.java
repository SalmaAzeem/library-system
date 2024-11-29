package src;

import java.util.ArrayList;
import java.util.List;

public class Library {
     Librarian Clark;
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
     public boolean CreateBook(String summary,String title, String genre,String publisher,int ISBN, int pages)
     {
         if(!SearchByIsbn(ISBN)) {
             BookDescription newBookDescription = new BookDescription(summary, title, genre, publisher, ISBN, pages);
             Book newBook = new Book();
             newBook.setDescription(newBookDescription);
             Books.add(newBook);
             return true;
         }
         else
         {
             return false;
         }
     }
}
