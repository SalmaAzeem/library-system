package src.model;
public class User extends Person {
    private int ID;
    private int Frequency;
    private BookList BorrowedList = new BookList();
    private BookList readingList;
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
