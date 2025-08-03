package com.team2.library.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<BookModel> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public BookModel addBook(BookModel book) {
        book.setId(null);
        return bookRepository.save(book);
    }

    public Optional<BookModel> updateBook(Integer id, BookModel updatedBook) {
        Optional<BookModel> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            return Optional.empty();
        }
        BookModel existingBook = book.get();
        if (updatedBook.getTitle() != null) {
            existingBook.setTitle(updatedBook.getTitle());
        }
        if (updatedBook.getAuthor() != null) {
            existingBook.setAuthor(updatedBook.getAuthor());
        }
        if (updatedBook.getDescription() != null) {
            existingBook.setDescription(updatedBook.getDescription());
        }
        return Optional.of(bookRepository.save(existingBook));
    }

    public boolean deleteBook(Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<BookModel> findByAuthor(String author) {
        return bookRepository.findByAuthorIgnoreCase(author);
    }

    public List<BookModel> searchByTitle(String keyword) {
        return bookRepository.findByTitleIgnoreCaseContaining(keyword);
    }
}