package src.model;
import src.model.BookList;
import src.model.Person;
import src.model.Book;
public class User extends Person {
    private int ID;
    private int Frequency;
    private final BookList BorrowedList;
    private final BookList readingList;

    public User() {
        readingList = new BookList();
        BorrowedList = new BookList();
    }

    public void AddToBorrowedList(Book book)
  {
      BorrowedList.Add(book);
  }
  public void Retrieve(Book book)
  {
      BorrowedList.Delete(book);
  }
  public void AddToReadingList(Book book)
  {
      readingList.Add(book);
  }
  public boolean Reserve(Book book) {
      return true;
  }
}
