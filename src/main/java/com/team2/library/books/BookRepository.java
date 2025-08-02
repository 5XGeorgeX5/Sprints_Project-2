package com.team2.library.books;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<BookModel, Integer> {
    List<BookModel> findByAuthorIgnoreCase(String author);

    List<BookModel> findByTitleIgnoreCaseContaining(String title);
}
