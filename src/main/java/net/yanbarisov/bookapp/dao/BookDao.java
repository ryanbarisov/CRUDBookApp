package net.yanbarisov.bookapp.dao;

import net.yanbarisov.bookapp.model.Book;

import java.util.List;

public interface BookDao {
    public void addBook(Book book);
    public void readBook(int id);
    public void updateBook(Book book);
    public void removeBook(int id);
    public Book getBookById(int id);
    public List<Book> listBooks(int page);
    public List<Book> listFoundBooks(String title, String author, int year, boolean read);

}
