package de.minol.gatways.rest.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.minol.gatways.rest.spring.boot.model.FormBlatt;

@Repository
public interface FormBlattRepository extends CrudRepository<FormBlatt, Long> {

}
