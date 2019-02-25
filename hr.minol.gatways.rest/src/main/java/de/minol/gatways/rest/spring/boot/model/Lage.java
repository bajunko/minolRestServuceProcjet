package de.minol.gatways.rest.spring.boot.model;

public enum Lage {

	NICHTS("", ""),
	LINKS("L", "Links"),
	RECHTS("R", "Rechts"),
	MITTE("M", "Mitte");
	
	private String sifra;
	private String opis;
	
	private Lage(final String sifra, final String opis) {
		this.sifra = sifra;
		this.opis = opis;
	}
	
//	public static Lage fromSifra(final String sifra) {
//		for (Lage i : Lage.values()) {
//			if (sifra.equals(i.sifra)) {
//				return i;
//			}
//		}
//		throw new IllegalArgumentException("Nepoznata sifra za Lage: '" + sifra + "'.");
//	}
	
	public static Lage parse(String sifra) {
		for(Lage item : Lage.values()){
			if(item.getSifra().equals(sifra)) {
				return item;
			}
		}
		
		throw new IllegalArgumentException("Nepostojeći Lage '" + sifra + "'");
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
	
}
