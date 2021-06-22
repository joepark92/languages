package com.joepark.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joepark.languages.models.Lang;

@Repository
public interface LangRepository extends CrudRepository<Lang, Long>{
    // this method retrieves all the books from the database
    List<Lang> findAll();
}
