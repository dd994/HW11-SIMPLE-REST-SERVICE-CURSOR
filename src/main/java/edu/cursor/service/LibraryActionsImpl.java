package edu.cursor.service;

import edu.cursor.repository.Author;
import edu.cursor.repository.Book;
import edu.cursor.repository.Genre;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LibraryActionsImpl implements LibraryActions {

    private List<Author> authors = new ArrayList<>(Arrays.asList(
            new Author(1, "A", "B"),
            new Author(2, "B", "dd"),
            new Author(3, "B", "dd"),
            new Author(4, "B", "dd")
    ));

    private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1, 1, "AAAAA", Genre.COMEDY, "dasdasd", 4.8),
            new Book(2, 1, "AAAAA", Genre.STORY, "dasdasd", 4.8),
            new Book(3, 3, "AAAAA", Genre.ROMAN, "dasdasd", 4.8),
            new Book(4, 4, "AAAAA", Genre.DETECTIVE, "dasdasd", 4.8)
    ));

    @Override
    public List<Author> addAuthor(Author author) {
        authors.add(author);
        return authors;
    }

    @Override
    public List<Author> addBook(Book book) {
        books.add(book);
        return authors;
    }

    @Override
    public List<Book> sortBookByGenre(Genre genre) {
        return books.stream()
                .filter(book -> book.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(Book book) {
        books.remove(book);
    }

    @Override
    public void refreshBook(int idOldBook, Book newBook) {
        books.remove(idOldBook);
        books.add(newBook);
    }

    @Override
    public List<Book> sortBookByAuthor(String authorLastName) {
        Author author = (Author) authors.stream()
                .filter(author1 -> author1.getLName().equalsIgnoreCase(authorLastName));
        return books.stream()
                .filter(book -> book.getAuthorId() == author.getId())
                .collect(Collectors.toList());
    }

}
