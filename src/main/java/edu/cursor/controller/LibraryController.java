package edu.cursor.controller;

import edu.cursor.repository.Author;
import edu.cursor.repository.Book;
import edu.cursor.repository.Genre;
import edu.cursor.service.LibraryActionsImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("server/library")
@AllArgsConstructor
public class LibraryController {

    @Autowired
    private LibraryActionsImpl libraryActionsImpl;

    @PostMapping("/addAuthor")
    public List<Author> addAuthor(@RequestBody Author author) {
        return libraryActionsImpl.addAuthor(author);
    }

    @PostMapping("/addBook")
    public List<Author> addBook(@RequestBody Book book) {
        return libraryActionsImpl.addBook(book);
    }

    @PostMapping("/deleteBook")
    public void deleteBook(@RequestBody Book book) {
        libraryActionsImpl.deleteBook(book);
    }

    @PostMapping("/refreshBook/{idOldBook}")
    public void refreshBook(@PathVariable("idOldBook") int idOldBook, @RequestBody Book newBook) {
        libraryActionsImpl.refreshBook(idOldBook, newBook);
    }
    @GetMapping("/getSortByGenres")
    public List<Book> sortBookByGenre(Genre genre) {
        return  libraryActionsImpl.sortBookByGenre(genre);
    }

    @GetMapping("/getSortByAuthor/{lastname}")
    public List<Book> sortBookByAuthor(@PathVariable("lastname") String authorLastName){
        return  libraryActionsImpl.sortBookByAuthor(authorLastName);
    }

}
