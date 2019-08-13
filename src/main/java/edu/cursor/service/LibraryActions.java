package edu.cursor.service;

import edu.cursor.repository.Author;
import edu.cursor.repository.Book;
import edu.cursor.repository.Genre;

import java.util.List;

public interface LibraryActions {

    List<Author> addAuthor (Author author);
    void deleteBook(Book book);
    void refreshBook(int idOldBook, Book newBook);
    List<Author> addBook(Book book);
    List<Book> sortBookByGenre(Genre genre);
    List<Book> sortBookByAuthor(String authorLastName);

}
