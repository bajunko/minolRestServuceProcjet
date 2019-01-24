package de.minol.gatways.rest.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.minol.gatways.rest.spring.boot.model.FormBlattEins;

@Repository
public interface FormBlattEinsRepository extends CrudRepository<FormBlattEins, Long> {

}
