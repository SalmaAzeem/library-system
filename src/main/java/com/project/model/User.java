package com.project.model;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private int ID;
    private int Frequency;
    private final BookList BorrowedList;
    private final BookList readingList;

    public User() {
        readingList = new BookList();
        BorrowedList = new BookList();
    }
    @Override
    public List<String> ShowInfo()
    {
        List<String> data = new ArrayList<>();
        data.add(String.valueOf(ID));
        return data;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFrequency() {
        return Frequency;
    }

    public void setFrequency(int frequency) {
        Frequency = frequency;
    }

    public BookList getBorrowedList() {
        return BorrowedList;
    }

    public BookList getReadingList() {
        return readingList;
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
