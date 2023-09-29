package com.boot.graphql.controller;

import com.boot.graphql.model.Author;
import com.boot.graphql.model.Book;
import com.boot.graphql.repo.AuthorRepo;
import com.boot.graphql.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class BookController  {

    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    BookRepo bookRepo;

    @QueryMapping
    public Optional<Book> bookById(@Argument int id) {
        return bookRepo.findById(id);
    }

    @SchemaMapping
    public Optional<Author> author(Book book) {
        return authorRepo.findById(book.getAuthorId());
    }

    @MutationMapping
    public Author addAuthor(@Argument String firstName, @Argument String lastName){
        return authorRepo.save(new Author(firstName, lastName));
    }

    @MutationMapping
    public Book addBook(@Argument String name, @Argument int authorId){
        return bookRepo.save(new Book(name, authorId));
    }

    @MutationMapping
    public Book updateBook(@Argument int id, @Argument String name, @Argument int authorId){

        Optional<Book> optBook = bookRepo.findById(id);

        Book book1 = optBook.get();
        book1.setName(name);
        book1.setAuthorId(authorId);

        return bookRepo.save(book1);
    }
}