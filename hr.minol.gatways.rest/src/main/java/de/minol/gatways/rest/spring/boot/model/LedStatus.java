package de.minol.gatways.rest.spring.boot.model;

public enum LedStatus {
	
	NICHTS("", ""),
	KEINE_FUNKTION("KF", "Aus / Keine Funktion"),
	ORANGE("OR", "Orange"),
	GRUEN("GR", "Gruen");
	
	private String sifra;
	private String opis;
	
	private LedStatus(final String sifra, final String opis) {
		this.sifra = sifra;
		this.opis = opis;
	}
	
//	public static LedStatus fromSifra(final String sifra) {
//		for (LedStatus i : LedStatus.values()) {
//			if (sifra.equals(i.sifra)) {
//				return i;
//			}
//		}
//		throw new IllegalArgumentException("Nepoznata sifra za Lage: '" + sifra + "'.");
//	}

	public static LedStatus parse(String sifra) {
		for(LedStatus item : LedStatus.values()){
			if(item.getSifra().equals(sifra)) {
				return item;
			}
		}
		
		throw new IllegalArgumentException("Nepostojeći LedStatus '" + sifra + "'");
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
