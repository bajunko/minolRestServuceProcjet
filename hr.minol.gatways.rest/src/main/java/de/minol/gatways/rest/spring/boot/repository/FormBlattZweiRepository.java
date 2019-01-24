package de.minol.gatways.rest.spring.boot.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.minol.gatways.rest.spring.boot.model.FormBlattZwei;

@Repository
@Transactional
public interface FormBlattZweiRepository extends CrudRepository<FormBlattZwei, Long>{

}
