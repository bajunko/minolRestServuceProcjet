package de.minol.gatways.rest.spring.boot.pdf;

import de.minol.gatways.rest.spring.boot.model.FormBlatt;


public interface ReportFactory {

	byte[] printReport (FormBlatt blatt);
}
