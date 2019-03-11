package de.minol.gatways.rest.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.minol.gatways.rest.spring.boot.model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

}
