package com.team2.library.books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;

        // Create books
        BookModel book1 = new BookModel();
        book1.setTitle("Java Programming");
        book1.setAuthor("John Doe");
        book1.setDescription("Learn Java programming");

        BookModel book2 = new BookModel();
        book2.setTitle("Spring Boot Guide");
        book2.setAuthor("Jane Smith");
        book2.setDescription("Master Spring Boot");


        bookService.addBook(book1);
        bookService.addBook(book2);

    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        List<BookModel> books = bookService.getAllBooks();

        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();  // 204 No Content
        }
        return ResponseEntity.ok(books);  // 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookModel>> getBookByID(@PathVariable Integer id) {

        Optional<BookModel> book = bookService.getBookById(id);
        if (book.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  // Automatically returns 201
    public BookModel createBook(@RequestBody BookModel book) {
        return bookService.addBook(book);
    }

    //another way of returning optional
    @PutMapping("/{id}")
    public ResponseEntity<BookModel> updateBook(@PathVariable Integer id, @RequestBody BookModel updatedBook) {
        Optional<BookModel> book = bookService.updateBook(id,updatedBook);
        return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        boolean deleted = bookService.deleteBook(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }


    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookModel>> findBooksByAuthor(@PathVariable String author) {
         List<BookModel> books = bookService.findByAuthor(author);
         return ResponseEntity.ok(books);

    }

    @GetMapping("/search")
    public ResponseEntity<List<BookModel>> searchByTitle(@RequestParam String keyword){
        List<BookModel> books = bookService.searchByTitle(keyword);
        return ResponseEntity.ok(books);
    }


}