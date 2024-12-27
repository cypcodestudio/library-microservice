package com.cypcode.library_microservice.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cypcode.library_microservice.domain.Shelf;

@Repository
public interface IShelfRepository extends JpaRepository<Shelf, Long>{

}
