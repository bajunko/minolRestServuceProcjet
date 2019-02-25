package de.minol.gatways.rest.spring.boot.model;

public enum MontagePositionRaum {
	
	NICHTS("", ""),
	TREPPENHAUS("T", "Treppenhaus"),
	DACH("D", "Dach");
	
	private String sifra;
	private String opis;
	
	private MontagePositionRaum(final String sifra, final String opis) {
		this.sifra = sifra;
		this.opis = opis;
	}
	
//	public static MontagePositionRaum fromSifra(final String sifra) {
//		for (MontagePositionRaum i : MontagePositionRaum.values()) {
//			if (sifra.equals(i.sifra)) {
//				return i;
//			}
//		}
//		throw new IllegalArgumentException("Nepoznata sifra za Lage: '" + sifra + "'.");
//	}
	
	public static MontagePositionRaum parse(String sifra) {
		for(MontagePositionRaum item : MontagePositionRaum.values()){
			if(item.getSifra().equals(sifra)) {
				return item;
			}
		}
		
		throw new IllegalArgumentException("Nepostojeći MontagePositionRaum '" + sifra + "'");
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
