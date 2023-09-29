package com.boot.graphql;

import com.boot.graphql.model.Author;
import com.boot.graphql.model.Book;
import com.boot.graphql.repo.AuthorRepo;
import com.boot.graphql.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlApplication implements ApplicationRunner {

	@Autowired
	AuthorRepo authorRepo;

	@Autowired
	BookRepo bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		authorRepo.save(new Author(1,"FN1","LN1" ));
		authorRepo.save(new Author(2,"FN2","LN2" ));
		bookRepo.save(new Book(1,"BookName1", 1));
		bookRepo.save(new Book(2,"BookName2", 2));
	}
}
