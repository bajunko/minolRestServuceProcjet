package de.minol.gatways.rest.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.minol.gatways.rest.spring.boot.model.Folder;

@Repository
public interface FolderRepository extends CrudRepository<Folder, Long> {

}
