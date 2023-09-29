package com.boot.graphql.repo;

import com.boot.graphql.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AuthorRepo extends CrudRepository<Author, Integer> {}
