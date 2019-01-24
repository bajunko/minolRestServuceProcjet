package de.minol.gatways.rest.spring.boot.model;

public enum Bausubstanz {

	ALTBAU("A", "Altbau"),
	RENOVIERT("R", "Renoviert"),
	NEUBAU("N", "Neubau");
	
	private String sifra;
	private String opis;
	
	private Bausubstanz(final String sifra, final String opis) {
		this.sifra = sifra;
		this.opis = opis;
	}
	
	public static Bausubstanz fromSifra(final String sifra) {
		for (Bausubstanz i : Bausubstanz.values()) {
			if (sifra.equals(i.sifra)) {
				return i;
			}
		}
		throw new IllegalArgumentException("Nepoznata sifra za IndikatorKlase: '" + sifra + "'.");
	}

	/**
	 * @return the sifra
	 */
	public String getSifra() {
		return sifra;
	}

	/**
	 * @return the opis
	 */
	public String getOpis() {
		return opis;
	}

	public static Bausubstanz parse(String sifra) {
		for(Bausubstanz item : Bausubstanz.values()){
			if(item.getSifra().equals(sifra)) {
				return item;
			}
		}
		
		throw new IllegalArgumentException("Nepostojeći Bausubstanz '" + sifra + "'");
	}	
	
}
