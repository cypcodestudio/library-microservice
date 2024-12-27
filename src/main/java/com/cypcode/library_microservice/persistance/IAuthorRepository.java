package com.cypcode.library_microservice.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cypcode.library_microservice.domain.Author;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long>{

}
