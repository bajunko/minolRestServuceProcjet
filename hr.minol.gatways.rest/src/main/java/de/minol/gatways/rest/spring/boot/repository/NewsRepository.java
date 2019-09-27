package de.minol.gatways.rest.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.minol.gatways.rest.spring.boot.model.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {

}
