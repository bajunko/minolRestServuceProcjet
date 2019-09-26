package de.minol.gatways.rest.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.minol.gatways.rest.spring.boot.model.FileUploadMetaData;

/** A JPA repository used to perform crud operations on file meta data records in database*/
public interface FileUploadRepository extends JpaRepository<FileUploadMetaData, Long> {
}