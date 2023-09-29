package com.boot.graphql.repo;

import com.boot.graphql.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository <Book, Integer> {}
