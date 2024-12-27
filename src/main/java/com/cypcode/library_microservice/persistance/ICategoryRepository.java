package com.cypcode.library_microservice.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cypcode.library_microservice.domain.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long>{

}
